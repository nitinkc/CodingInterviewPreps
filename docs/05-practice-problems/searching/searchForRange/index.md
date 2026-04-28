# Search For Range

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
public static int[] searchForRange(int[] array, int target) {
int[] finalRange = {-1, -1};
alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);
return finalRange;
}
public static void alteredBinarySearch(
int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
while (left <= right) {
int mid = (left + right) / 2;
if (array[mid] < target) {
left = mid + 1;
} else if (array[mid] > target) {
right = mid - 1;
} else {
if (goLeft) {
if (mid == 0 || array[mid - 1] != target) {
finalRange[0] = mid;
return;
} else {
right = mid - 1;
}
} else {
if (mid == array.length - 1 || array[mid + 1] != target) {
finalRange[1] = mid;
return;
} else {
left = mid + 1;
}
}
}
}
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(log(n)) time | O(log(n)) space
5 public static int[] searchForRange(int[] array, int target) {
6 int[] finalRange = {-1, -1};
7 alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
8 alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);
9 return finalRange;
10 }
11
12 public static void alteredBinarySearch(
13 int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
14 if (left > right) {
15 return;
16 }
17 int mid = (left + right) / 2;
18 if (array[mid] < target) {
19 alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
20 } else if (array[mid] > target) {
21 alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
22 } else {
23 if (goLeft) {
24 if (mid == 0 || array[mid - 1] != target) {
25 finalRange[0] = mid;
26 } else {
27 alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
28 }
29 } else {
30 if (mid == array.length - 1 || array[mid + 1] != target) {
31 finalRange[1] = mid;
32 } else {
33 alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
34 }
35 }
36 }
37 }
38 }
39

```
---

## Test Cases

```
Test Case 1
{"array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73], "target": 45}
Test Case 2
{"array": [5, 7, 7, 8, 8, 10], "target": 5}
Test Case 3
{"array": [5, 7, 7, 8, 8, 10], "target": 7}
Test Case 4
{"array": [5, 7, 7, 8, 8, 10], "target": 8}
Test Case 5
{"array": [5, 7, 7, 8, 8, 10], "target": 10}
Test Case 6
{"array": [5, 7, 7, 8, 8, 10], "target": 9}
Test Case 7
{"array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73], "target": 47}
Test Case 8
{"array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73], "target": -1}
Test Case 9
{"array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 45, 45, 45], "target": 45}

