# Quickselect

**Category:** Searching

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
class Program {
// Best: O(n) time | O(1) space
// Average: O(n) time | O(1) space
// Worst: O(n^2) time | O(1) space
public static int quickselect(int[] array, int k) {
int position = k - 1;
return quickselect(array, 0, array.length - 1, position);
}
public static int quickselect(int[] array, int startIdx, int endIdx, int position) {
while (true) {
if (startIdx > endIdx) {
throw new RuntimeException("Your Algorithm should never arrive here!");
}
int pivotIdx = startIdx;
int leftIdx = startIdx + 1;
int rightIdx = endIdx;
while (leftIdx <= rightIdx) {
if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
swap(leftIdx, rightIdx, array);
}
if (array[leftIdx] <= array[pivotIdx]) {
leftIdx++;
}
if (array[rightIdx] >= array[pivotIdx]) {
rightIdx--;
}
}
swap(pivotIdx, rightIdx, array);
if (rightIdx == position) {
return array[rightIdx];
} else if (rightIdx < position) {
startIdx = rightIdx + 1;
} else {
endIdx = rightIdx - 1;
}
}
}
public static void swap(int i, int j, int[] array) {
int temp = array[j];
array[j] = array[i];
array[i] = temp;
}
}

```
---

## Test Cases

```
Test Case 1
{"array": [8, 5, 2, 9, 7, 6, 3], "k": 3}
Test Case 2
{"array": [1], "k": 1}
Test Case 3
{"array": [43, 24, 37], "k": 1}
Test Case 4
{"array": [43, 24, 37], "k": 2}
Test Case 5
{"array": [43, 24, 37], "k": 3}
Test Case 6
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 1}
Test Case 7
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 2}
Test Case 8
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 3}
Test Case 9
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 4}
Test Case 10
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 5}
Test Case 11
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 6}
Test Case 12
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 7}
Test Case 13
{"array": [8, 3, 2, 5, 1, 7, 4, 6], "k": 8}
Test Case 14
{"array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15], "k": 5}
Test Case 15
{"array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15], "k": 4}
Test Case 16
{"array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15], "k": 9}
Test Case 17
{
  "array": [
    1,
    3,
    71,
    123,
    124,
    156,
    814,
    1294,
    10024,
    110000,
    985181,
  ],
  "k": 12
}
Test Case 18
{
  "array": [
    1,
    3,
    71,
    123,
    124,
    156,
    814,
    1294,
    10024,
    110000,
    985181,
  ],
  "k": 4
}

