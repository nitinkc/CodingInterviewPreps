# Find Three Largest Numbers

**Category:** Searching

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space
public static int[] findThreeLargestNumbers(int[] array) {
int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
for (int num : array) {
updateLargest(threeLargest, num);
}
return threeLargest;
}
public static void updateLargest(int[] threeLargest, int num) {
if (num > threeLargest[2]) {
shiftAndUpdate(threeLargest, num, 2);
} else if (num > threeLargest[1]) {
shiftAndUpdate(threeLargest, num, 1);
} else if (num > threeLargest[0]) {
shiftAndUpdate(threeLargest, num, 0);
}
}
public static void shiftAndUpdate(int[] array, int num, int idx) {
for (int i = 0; i <= idx; i++) {
if (i == idx) {
array[i] = num;
} else {
array[i] = array[i + 1];
}
}
}
}

```
---

## Test Cases

```
Test Case 1
{"array": [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]}
Test Case 2
{"array": [55, 7, 8]}
Test Case 3
{"array": [55, 43, 11, 3, -3, 10]}
Test Case 4
{"array": [7, 8, 3, 11, 43, 55]}
Test Case 5
{"array": [55, 7, 8, 3, 43, 11]}
Test Case 6
{"array": [7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7]}
Test Case 7
{"array": [7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7]}
Test Case 8
{"array": [-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7]}

