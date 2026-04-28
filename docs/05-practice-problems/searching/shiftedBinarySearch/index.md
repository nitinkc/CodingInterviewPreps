# Shifted Binary Search

**Category:** Searching

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// O(log(n)) time | O(1) space
public static int shiftedBinarySearch(int[] array, int target) {
return shiftedBinarySearch(array, target, 0, array.length - 1);
}
public static int shiftedBinarySearch(int[] array, int target, int left, int right) {
while (left <= right) {
int middle = (left + right) / 2;
int potentialMatch = array[middle];
int leftNum = array[left];
int rightNum = array[right];
if (target == potentialMatch) {
return middle;
} else if (leftNum <= potentialMatch) {
if (target < potentialMatch && target >= leftNum) {
right = middle - 1;
} else {
left = middle + 1;
}
} else {
if (target > potentialMatch && target <= rightNum) {
left = middle + 1;
} else {
right = middle - 1;
}
}
}
return -1;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(log(n)) time | O(log(n)) space
5 public static int shiftedBinarySearch(int[] array, int target) {
6 return shiftedBinarySearch(array, target, 0, array.length - 1);
7 }
8
9 public static int shiftedBinarySearch(int[] array, int target, int left, int right) {
10 if (left > right) {
11 return -1;
12 }
13 int middle = (left + right) / 2;
14 int potentialMatch = array[middle];
15 int leftNum = array[left];
16 int rightNum = array[right];
17 if (target == potentialMatch) {
18 return middle;
19 } else if (leftNum <= potentialMatch) {
20 if (target < potentialMatch && target >= leftNum) {
21 return shiftedBinarySearch(array, target, left, middle - 1);
22 } else {
23 return shiftedBinarySearch(array, target, middle + 1, right);
24 }
25 } else {
26 if (target > potentialMatch && target <= rightNum) {
27 return shiftedBinarySearch(array, target, middle + 1, right);
28 } else {
29 return shiftedBinarySearch(array, target, left, middle - 1);
30 }
31 }
32 }
33 }
34

```
---

## Test Cases

```
Test Case 1
{"array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 45], "target": 33}
Test Case 2
{"array": [5, 23, 111, 1], "target": 111}
Test Case 3
{"array": [111, 1, 5, 23], "target": 5}
Test Case 4
{"array": [23, 111, 1, 5], "target": 35}
Test Case 5
{"array": [61, 71, 72, 73, 0, 1, 21, 33, 45, 45], "target": 33}
Test Case 6
{"array": [72, 73, 0, 1, 21, 33, 45, 45, 61, 71], "target": 72}
Test Case 7
{"array": [71, 72, 73, 0, 1, 21, 33, 45, 45, 61], "target": 73}
Test Case 8
{"array": [73, 0, 1, 21, 33, 45, 45, 61, 71, 72], "target": 70}
Test Case 9
{"array": [33, 45, 45, 61, 71, 72, 73, 355, 0, 1, 21], "target": 355}
Test Case 10
{"array": [33, 45, 45, 61, 71, 72, 73, 355, 0, 1, 21], "target": 354}

