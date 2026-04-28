# Binary Search

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
public static int binarySearch(int[] array, int target) {
return binarySearch(array, target, 0, array.length - 1);
}
public static int binarySearch(int[] array, int target, int left, int right) {
while (left <= right) {
int middle = (left + right) / 2;
int potentialMatch = array[middle];
if (target == potentialMatch) {
return middle;
} else if (target < potentialMatch) {
right = middle - 1;
} else {
left = middle + 1;
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
5 public static int binarySearch(int[] array, int target) {
6 return binarySearch(array, target, 0, array.length - 1);
7 }
8
9 public static int binarySearch(int[] array, int target, int left, int right) {
10 if (left > right) {
11 return -1;
12 }
13 int middle = (left + right) / 2;
14 int potentialMatch = array[middle];
15 if (target == potentialMatch) {
16 return middle;
17 } else if (target < potentialMatch) {
18 return binarySearch(array, target, left, middle - 1);
19 } else {
20 return binarySearch(array, target, middle + 1, right);
21 }
22 }
23 }
24

```
---

## Test Cases

```
Test Case 1
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73], "target": 33}
Test Case 2
{"array": [1, 5, 23, 111], "target": 111}
Test Case 3
{"array": [1, 5, 23, 111], "target": 5}
Test Case 4
{"array": [1, 5, 23, 111], "target": 35}
Test Case 5
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73], "target": 72}
Test Case 6
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73], "target": 73}
Test Case 7
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73], "target": 70}
Test Case 8
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355], "target": 355}
Test Case 9
{"array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355], "target": 354}

