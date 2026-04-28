# Continuous Median

**Category:** Heaps

```
## Problem Statement

Continuous Median
Write a ContinuousMedianHandler class that supports:
- The continuous insertion of numbers with the insert method.
- The instant (O(1) time) retrieval of the median of the numbers that have been inserted thus far with the getMedian method.
The getMedian method has already been written for you. You simply have to write the insert method.
Sample Usage
// All operations below are performed sequentially.
ContinuousMedianHandler(): - // instantiate a ContinuousMedianHandler
insert(5): -
insert(10): -
getMedian(): 7.5
insert(100): -
getMedian(): 10
Hints
Hint 1
The median of a set of numbers is often, by denition, one of the numbers in the set. Thus, you likely have to store all of the inserted numbers somewhere to be able to continuously
compute their median.
Hint 2
The median of a set of numbers is either the middle number of that set (if the set has an odd amount of numbers) or the average of the middle numbers (if the set has an even amount
of numbers). This means that if you could somehow keep track of the middle number(s) of the set of inserted numbers, you could easily compute the median by nding the indices of
the middle numbers and doing some simple calculations. Perhaps storing all of the numbers in a sorted array could work, but what would be the runtime implication of inserting each
new number into a sorted array?
Hint 3
Realizing that you only need to keep track of the middle numbers in the set of inserted numbers to compute the median, try keeping track of two subsets of the numbers: a max-heap of
the lower half of the numbers and a min-heap of the greater half of the numbers. Any time you insert a number, pick the heap to place it in by comparing it to the max / min values of
the heaps. Then, re-balance the heaps in an eort to keep their sizes apart by at most one. Doing so will allow you to access the middle number(s) of the set of inserted numbers very
easily, which will make calculating the median a trivial computation. Re-balancing the heaps can be accomplished by simply removing a value from the larger heap and inserting it in the
smaller one. What are the runtime implications of all these operations?
Optimal Space & Time Complexity
Insert: O(log(n)) time | O(n) space - where n is the number of inserted numbers

```
---

## Approach & Solution

### Solution 1

```
}
} else {
idxToSwap = childOneIdx;
}
if (comparisonFunc.apply(heap.get(idxToSwap), heap.get(currentIdx))) {
swap(currentIdx, idxToSwap, heap);
currentIdx = idxToSwap;
childOneIdx = currentIdx * 2 + 1;
} else {
return;
}
}
}
public void siftUp(int currentIdx, List<Integer> heap) {
int parentIdx = (currentIdx - 1) / 2;
while (currentIdx > 0) {
if (comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
swap(currentIdx, parentIdx, heap);
currentIdx = parentIdx;
parentIdx = (currentIdx - 1) / 2;
} else {
return;
}
}
}
public int peek() {
return heap.get(0);
}
public int remove() {
swap(0, heap.size() - 1, heap);
int valueToRemove = heap.get(heap.size() - 1);
heap.remove(heap.size() - 1);
length--;
siftDown(0, heap.size() - 1, heap);
return valueToRemove;
}
public void insert(int value) {
heap.add(value);
length++;
siftUp(heap.size() - 1, heap);
}
public void swap(int i, int j, List<Integer> heap) {
Integer temp = heap.get(j);
heap.set(j, heap.get(i));
heap.set(i, temp);
}
}
public static Boolean MAX_HEAP_FUNC(Integer a, Integer b) {
return a > b;
}
public static Boolean MIN_HEAP_FUNC(Integer a, Integer b) {
return a < b;
}
}

### Solution 2

```
53 comparisonFunc func;
54 length = heap.size();
55 }
56
57 public List<Integer> buildHeap(List<Integer> array) {
58 int firstParentIdx = (array.size() - 2) / 2;
59 for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
60 siftDown(currentIdx, array.size() - 1, array);
61 }
62 return array;
63 }
64
65 public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
66 int childOneIdx = currentIdx * 2 + 1;
67 while (childOneIdx <= endIdx) {
68 int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
69 int idxToSwap;
70 if (childTwoIdx != -1) {
71 if (comparisonFunc.apply(heap.get(childTwoIdx), heap.get(childOneIdx))) {
72 idxToSwap = childTwoIdx;
73 } else {
74 idxToSwap = childOneIdx;
75 }
76 } else {
77 idxToSwap = childOneIdx;
78 }
79 if (comparisonFunc.apply(heap.get(idxToSwap), heap.get(currentIdx))) {
80 swap(currentIdx, idxToSwap, heap);
81 currentIdx = idxToSwap;
82 childOneIdx = currentIdx * 2 + 1;
83 } else {
84 return;
85 }
86 }
87 }
88
89 public void siftUp(int currentIdx, List<Integer> heap) {
90 int parentIdx = (currentIdx - 1) / 2;
91 while (currentIdx > 0) {
92 if (comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
93 swap(currentIdx, parentIdx, heap);
94 currentIdx = parentIdx;
95 parentIdx = (currentIdx - 1) / 2;

### Solution 3

```java
import java.util.*;
import java.util.function.BiFunction;
class Program {
static class ContinuousMedianHandler {
Heap lowers = new Heap(Program::MAX_HEAP_FUNC, new ArrayList<Integer>());
Heap greaters = new Heap(Program::MIN_HEAP_FUNC, new ArrayList<Integer>());
double median = 0;
// O(log(n)) time | O(n) space
public void insert(int number) {
if (lowers.length == 0 || number < lowers.peek()) {
lowers.insert(number);
} else {
greaters.insert(number);
}
rebalanceHeaps();
updateMedian();
}
public void rebalanceHeaps() {
if (lowers.length - greaters.length == 2) {
greaters.insert(lowers.remove());
} else if (greaters.length - lowers.length == 2) {
lowers.insert(greaters.remove());
}
}
public void updateMedian() {
if (lowers.length == greaters.length) {
median = ((double) lowers.peek() + (double) greaters.peek()) / 2;
} else if (lowers.length > greaters.length) {
median = lowers.peek();
} else {
median = greaters.peek();
}
}
public double getMedian() {
return median;
}
}

```
---

## Test Cases

```
Test Case 1
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 2
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 3
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 4
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 5
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 6
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [51], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [52], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 7
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [51], "method": "insert"},
    {"arguments": [52], "method": "insert"},
    {"arguments": [1000], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [10000], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 8
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [51], "method": "insert"},
    {"arguments": [52], "method": "insert"},
    {"arguments": [1000], "method": "insert"},
    {"arguments": [10000], "method": "insert"},
    {"arguments": [10001], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [10002], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 9
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [51], "method": "insert"},
    {"arguments": [52], "method": "insert"},
    {"arguments": [1000], "method": "insert"},
    {"arguments": [10000], "method": "insert"},
    {"arguments": [10001], "method": "insert"},
    {"arguments": [10002], "method": "insert"},
    {"arguments": [10003], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [10004], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
Test Case 10
{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [6], "method": "insert"},
    {"arguments": [13], "method": "insert"},
    {"arguments": [14], "method": "insert"},
    {"arguments": [50], "method": "insert"},
    {"arguments": [51], "method": "insert"},
    {"arguments": [52], "method": "insert"},
    {"arguments": [1000], "method": "insert"},
    {"arguments": [10000], "method": "insert"},
    {"arguments": [10001], "method": "insert"},
    {"arguments": [10002], "method": "insert"},
    {"arguments": [10003], "method": "insert"},
    {"arguments": [10004], "method": "insert"},
    {"arguments": [75], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [80], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}

