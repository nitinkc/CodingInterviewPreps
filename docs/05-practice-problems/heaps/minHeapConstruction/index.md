# Min Heap Construction

**Category:** Heaps

```
## Problem Statement

Min Heap Construction
Implement a MinHeap class that supports:
- Building a Min Heap from an input array of integers.
- Inserting integers in the heap.
- Removing the heap's minimum / root value.
- Peeking at the heap's minimum / root value.
- Sifting integers up and down the heap, which is to be used when inserting and removing values.
Note that the heap should be represented in the form of an array.
If you're unfamiliar with Min Heaps, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.
Sample Usage
array = [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41]
// All operations below are performed sequentially.
MinHeap(array): - // instantiate a MinHeap (calls the buildHeap method and populates the heap)
buildHeap(array): [-5, 2, 6, 7, 8, 8, 24, 391, 24, 56, 12, 24, 48, 41]
insert(76): [-5, 2, 6, 7, 8, 8, 24, 391, 24, 56, 12, 24, 48, 41, 76]
peek(): -5
remove(): [2, 7, 6, 24, 8, 8, 24, 391, 76, 56, 12, 24, 48, 41]
peek(): 2
remove(): [6, 7, 8, 24, 8, 24, 24, 391, 76, 56, 12, 41, 48]
peek(): 6
insert(87): [6, 7, 8, 24, 8, 24, 24, 391, 76, 56, 12, 41, 48, 87]
Hints
Hint 1
For the buildHeap(), remove(), and insert() methods of the Heap, you will need to use the siftDown() and siftUp() methods. These two methods should essentially allow you to take any
node in the heap and move it either down or up in the heap until it's in its nal, appropriate position. This can be done by comparing the node in question to its child nodes in the case
of siftDown() or to its parent node in the case of siftUp().
Hint 2
In an array-based Heap, you can easily access a node's children nodes and parent node by using the nodes' indices. If a node is located at index i, then its children nodes are located at
indices 2 * i + 1 and 2 * i + 2, and its parent node is located at index Math.oor((i - 1) / 2).
Hint 3
To implement the buildHeap() method, you can either sift every node in the input array down to its nal, correct position, or you can sift every node in the input array up to its nal,
correct position. What are the runtime implications of both approaches? Which methods (siftDown() or siftUp()) will insert() and remove() utilize? What about peek()?
Optimal Space & Time Complexity
BuildHeap: O(n) time | O(1) space - where n is the length of the input array
SiftDown: O(log(n)) time | O(1) space - where n is the length of the heap
SiftUp: O(log(n)) time | O(1) space - where n is the length of the heap
Peek: O(1) | O(1)

```
---

## Approach & Solution

### Solution 1

```
int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
int idxToSwap;
if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
idxToSwap = childTwoIdx;
} else {
idxToSwap = childOneIdx;
}
if (heap.get(idxToSwap) < heap.get(currentIdx)) {
swap(currentIdx, idxToSwap, heap);
currentIdx = idxToSwap;
childOneIdx = currentIdx * 2 + 1;
} else {
return;
}
}
}
// O(log(n)) time | O(1) space
public void siftUp(int currentIdx, List<Integer> heap) {
int parentIdx = (currentIdx - 1) / 2;
while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
swap(currentIdx, parentIdx, heap);
currentIdx = parentIdx;
parentIdx = (currentIdx - 1) / 2;
}
}
public int peek() {
return heap.get(0);
}
public int remove() {
swap(0, heap.size() - 1, heap);
int valueToRemove = heap.get(heap.size() - 1);
heap.remove(heap.size() - 1);
siftDown(0, heap.size() - 1, heap);
return valueToRemove;
}
public void insert(int value) {
heap.add(value);
siftUp(heap.size() - 1, heap);
}
public void swap(int i, int j, List<Integer> heap) {
Integer temp = heap.get(j);
heap.set(j, heap.get(i));
heap.set(i, temp);
}
}
}

### Solution 2

```java
import java.util.*;
4
class Program {
static class MinHeap {
List<Integer> heap = new ArrayList<Integer>();
8
public MinHeap(List<Integer> array) {
heap = buildHeap(array);
}
12
// O(n) time | O(1) space
public List<Integer> buildHeap(List<Integer> array) {
int firstParentIdx = (array.size() - 2) / 2;
for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
siftDown(currentIdx, array.size() - 1, array);
}
return array;
}
21
// O(log(n)) time | O(1) space
public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
int childOneIdx = currentIdx * 2 + 1;
while (childOneIdx <= endIdx) {
int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
int idxToSwap;
if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
idxToSwap = childTwoIdx;
} else {
idxToSwap = childOneIdx;
}
if (heap.get(idxToSwap) < heap.get(currentIdx)) {
swap(currentIdx, idxToSwap, heap);
currentIdx = idxToSwap;
childOneIdx = currentIdx * 2 + 1;
} else {
return;
}
}
}
42
// O(log(n)) time | O(1) space
public void siftUp(int currentIdx, List<Integer> heap) {
int parentIdx = (currentIdx - 1) / 2;

```
---

## Test Cases

```
Test Case 1
{
  "array": [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41],
  "classMethodsToCall": [
    {"arguments": [76], "method": "insert"},
    {"arguments": [], "method": "peek"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "peek"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "peek"},
    {"arguments": [87], "method": "insert"}
  ]
}
Test Case 2
{
  "array": [2, 3, 1],
  "classMethodsToCall": [{"arguments": [], "method": "peek"}]
}
Test Case 3
{
  "array": [1, 2, 3, 4, 5, 6, 7, 8, 9],
  "classMethodsToCall": [{"arguments": [], "method": "peek"}]
}
Test Case 4
{
  "array": [
    -4,
    5,
    10,
    8,
    -10,
    -6,
    -4,
    -2,
    -5,
    3,
    5,
    -4,
    -5,
    -1,
    1,
    6,
    -7,
    -6,
    -7,
    8
  ],
  "classMethodsToCall": [{"arguments": [], "method": "peek"}]
}
Test Case 5
{
  "array": [-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8],
  "classMethodsToCall": [
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "peek"},
    {"arguments": [-8], "method": "insert"},
    {"arguments": [], "method": "peek"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "peek"},
    {"arguments": [8], "method": "insert"},
    {"arguments": [], "method": "peek"}
  ]
}
Test Case 6
{
  "array": [
    427,
    787,
    222,
    996,
    -359,
    -614,
    246,
    230,
    107,
    -706,
    568,
    9,
    -246,
    12,
    -764,
    -212,
    -484,
    603,
    934,
    -848,
    -646,
    -991,
    661,
    -32,
    -348,
    -474,
    -439,
    -56,
    507,
    736,
    635,
    -171,
    -215,
    564,
    -710,
    710,
    565,
    892,
    970,
    -755,
    55,
    821,
    -3,
    -153,
    240,
    -160,
    -610,
    -583,
    -27,
    131
  ],
  "classMethodsToCall": [{"arguments": [], "method": "peek"}]
}
Test Case 7
{
  "array": [
    991,
    -731,
    -882,
    100,
    280,
    -43,
    432,
    771,
    -581,
    180,
    -382,
    -998,
    847,
    80,
    -220,
    680,
    769,
    -75,
    -817,
    366,
    956,
    749,
    471,
    228,
    -435,
    -269,
    652,
    -331,
    -387,
    -657,
    -255,
    382,
    -216,
    -6,
    -163,
    -681,
    980,
    913,
    -169,
    972,
    -523,
    354,
    747,
    805,
    382,
    -827,
    -796,
    372,
    753,
    519,
    906
  ],
  "classMethodsToCall": [
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "remove"},
    {"arguments": [992], "method": "insert"}
  ]
}
Test Case 8
{
  "array": [
    544,
    -578,
    556,
    713,
    -655,
    -359,
    -810,
    -731,
    194,
    -531,
    -685,
    689,
    -279,
    -738,
    886,
    -54,
    -320,
    -500,
    738,
    445,
    -401,
    993,
    -753,
    329,
    -396,
    -924,
    -975,
    376,
    748,
    -356,
    972,
    459,
    399,
    669,
    -488,
    568,
    -702,
    551,
    763,
    -90,
    -249,
    -45,
    452,
    -917,
    394,
    195,
    -877,
    153,
    153,
    788,
    844,
    867,
    266,
    -739,
    904,
    -154,
    -947,
    464,
    343,
    -312,
    150,
    -656,
    528,
    61,
    94,
    -581
  ],
  "classMethodsToCall": [{"arguments": [], "method": "peek"}]
}
Test Case 9
{
  "array": [
    -823,
    164,
    48,
    -987,
    323,
    399,
    -293,
    183,
    -908,
    -376,
    14,
    980,
    965,
    842,
    422,
    829,
    59,
    724,
    -415,
    -733,
    356,
    -855,
    -155,
    52,
    328,
    -544,
    -371,
    -160,
    -942,
    -51,
    700,
    -363,
    -353,
    -359,
    238,
    892,
    -730,
    -575,
    892,
    490,
    490,
    995,
    572,
    888,
    -935,
    919,
    -191,
    646,
    -120,
    125,
    -817,
    341,
    -575,
    372,
    -874,
    243,
    610,
    -36,
    -685,
    -337,
    -13,
    295,
    800,
    -950,
    -949,
    -257,
    631,
    -542,
    201,
    -796,
    157,
    950,
    540,
    -846,
    -265,
    746,
    355,
    -578,
    -441,
    -254,
    -941,
    -738,
    -469,
    -167,
    -420,
    -126,
    -410,
    59
  ],
  "classMethodsToCall": [
    {"arguments": [2], "method": "insert"},
    {"arguments": [22], "method": "insert"},
    {"arguments": [222], "method": "insert"},
    {"arguments": [2222], "method": "insert"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "remove"},
    {"arguments": [], "method": "remove"}
  ]
}

