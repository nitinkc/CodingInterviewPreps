# Subarray Sort

**Category:** Arrays

```
## Problem Statement

Subarray Sort
Write a function that takes in an array of at least two integers and that returns an array of the starting and ending indices of the smallest subarray in the input array that
needs to be sorted in place in order for the entire input array to be sorted.
If the input array is already sorted, the function should return [-1, -1] .
Sample Input
array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
Sample Output
[3, 9]
Hints
Hint 1
Realize that even a single out-of-order number in the input array can call for a large subarray to have to be sorted. This is because, depending on how out-of-place
the number is, it might need to be moved very far away from its original position in order to be in its sorted position.
Hint 2
Find the smallest and largest numbers that are out of order in the input array. You should be able to do this in a single pass through the array.
Hint 3
Once you've found the smallest and largest out-of-order numbers mentioned in Hint #2, nd their nal sorted positions in the array. This should give you the
extremities of the smallest subarray that needs to be sorted.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space
public static int[] subarraySort(int[] array) {
int minOutOfOrder = Integer.MAX_VALUE;
int maxOutOfOrder = Integer.MIN_VALUE;
for (int i = 0; i < array.length; i++) {
int num = array[i];
if (isOutOfOrder(i, num, array)) {
minOutOfOrder = Math.min(minOutOfOrder, num);
maxOutOfOrder = Math.max(maxOutOfOrder, num);
}
}
if (minOutOfOrder == Integer.MAX_VALUE) {
return new int[] {-1, -1};
}
int subarrayLeftIdx = 0;
while (minOutOfOrder >= array[subarrayLeftIdx]) {
subarrayLeftIdx++;
}
int subarrayRightIdx = array.length - 1;
while (maxOutOfOrder <= array[subarrayRightIdx]) {
subarrayRightIdx--;
}
return new int[] {subarrayLeftIdx, subarrayRightIdx};
}
public static boolean isOutOfOrder(int i, int num, int[] array) {
if (i == 0) {
return num > array[i + 1];
}
if (i == array.length - 1) {
return num < array[i - 1];
}
return num > array[i + 1] || num < array[i - 1];
}
}

```
---

## Test Cases

```
Test Case 1
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]}
Test Case 2
{"array": [1, 2]}
Test Case 3
{"array": [2, 1]}
Test Case 4
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]}
Test Case 5
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]}
Test Case 6
{"array": [1, 2, 8, 4, 5]}
Test Case 7
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 8
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 9
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 10
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 11
{"array": [1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11]}
Test Case 12
{"array": [1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]}
Test Case 13
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    18,
    21,
    22,
    7,
    14,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    19,
    4,
    14,
    11,
    6,
    33,
    35,
    41,
  ]
}
Test Case 14
{
  "array": [
    1,
    2,
    20,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
  ]
}
Test Case 15
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
  ]
}
Test Case 16
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
  ]
}
Test Case 17
{"array": [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]}

```
Video Solution

1
2
​
3
class Program {
4
  // O(n) time | O(1) space
5
  public static int[] subarraySort(int[] array) {
6
    int minOutOfOrder = Integer.MAX_VALUE;
7
    int maxOutOfOrder = Integer.MIN_VALUE;
8
    for (int i = 0; i < array.length; i++) {
9
      int num = array[i];
10
      if (isOutOfOrder(i, num, array)) {
11
        minOutOfOrder = Math.min(minOutOfOrder, num);
12
        maxOutOfOrder = Math.max(maxOutOfOrder, num);
13
      }
14
    }
15
    if (minOutOfOrder == Integer.MAX_VALUE) {
16
      return new int[] {-1, -1};
17
    }
18
    int subarrayLeftIdx = 0;
19
    while (minOutOfOrder >= array[subarrayLeftIdx]) {
20
      subarrayLeftIdx++;
21
    }
22
    int subarrayRightIdx = array.length - 1;
23
    while (maxOutOfOrder <= array[subarrayRightIdx]) {
24
      subarrayRightIdx--;
25
    }
26
    return new int[] {subarrayLeftIdx, subarrayRightIdx};
27
  }
28
​
29
  public static boolean isOutOfOrder(int i, int num, int[] array) {
30
    if (i == 0) {
31
      return num > array[i + 1];
32
    }
33
    if (i == array.length - 1) {
34
      return num < array[i - 1];
35
    }
36
    return num > array[i + 1] || num < array[i - 1];
37
  }
38
}
39
​

```
Test Case 1
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]}
Test Case 2
{"array": [1, 2]}
Test Case 3
{"array": [2, 1]}
Test Case 4
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]}
Test Case 5
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]}
Test Case 6
{"array": [1, 2, 8, 4, 5]}
Test Case 7
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 8
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 9
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 10
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 11
{"array": [1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11]}
Test Case 12
{"array": [1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]}
Test Case 13
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    18,
    21,
    22,
    7,
    14,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    19,
    4,
    14,
    11,
    6,
    33,
    35,
    41,
  ]
}
Test Case 14
{
  "array": [
    1,
    2,
    20,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
  ]
}
Test Case 15
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
  ]
}
Test Case 16
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
  ]
}
Test Case 17
{"array": [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[3, 9]
Input(s)
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]}
Test Case 2 passed!
Our Code's Output
[-1, -1]
Input(s)
{"array": [1, 2]}
Test Case 3 passed!
Our Code's Output
[0, 1]
Input(s)
{"array": [2, 1]}
Test Case 4 passed!
Our Code's Output
[4, 9]
Input(s)
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]}
Test Case 5 passed!
Our Code's Output
[4, 6]
Input(s)
{"array": [1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]}
Test Case 6 passed!
Our Code's Output
[2, 4]
Input(s)
{"array": [1, 2, 8, 4, 5]}
Test Case 7 passed!
Our Code's Output
[0, 12]
Input(s)
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 8 passed!
Our Code's Output
[0, 11]
Input(s)
{"array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 9 passed!
Our Code's Output
[1, 11]
Input(s)
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]}
Test Case 10 passed!
Our Code's Output
[1, 12]
Input(s)
{"array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]}
Test Case 11 passed!
Our Code's Output
[6, 7]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11]}
Test Case 12 passed!
Our Code's Output
[6, 16]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]}
Test Case 13 passed!
Our Code's Output
[4, 24]
Input(s)
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    18,
    21,
    22,
    7,
    14,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    19,
    4,
    14,
    11,
    6,
    33,
    35,
    41,
    55
  ]
}
Test Case 14 passed!
Our Code's Output
[2, 19]
Input(s)
{
  "array": [
    1,
    2,
    20,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19
  ]
}
Test Case 15 passed!
Our Code's Output
[2, 19]
Input(s)
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
    2
  ]
}
Test Case 16 passed!
Our Code's Output
[-1, -1]
Input(s)
{
  "array": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
    20
  ]
}
Test Case 17 passed!
Our Code's Output
[-1, -1]
Input(s)
{"array": [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]}

```
