# Kadanes Algorithm

**Category:** Famous Algorithms

```
## Problem Statement

Kadane's Algorithm
Write a function that takes in a non-empty array of integers and returns the maximum sum that can be obtained by summing up all of the integers in a non-empty subarray of the input array.
A subarray must only contain adjacent numbers.
Sample Input
array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
Sample Output
// [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]
Hints
Hint 1
This problem seems fairly simple until you run into negative numbers, some of which are so big in absolute value that they essentially break an otherwise good subarray into two
subarrays, and some of which are small enough that there exists a subarray containing them whose numbers sum to maximum sum that you're looking for. How can you determine
which group a negative number belongs to?
Hint 2
Realize that at any given index in the input array, the maximum sum for a subarray ending at that index is either the maximum sum for a subarray ending at the previous index plus the
number at that index, or just the number at that index. Thus, for each index in the array, you can calculate the maximum sum of a subarray ending at that index, and this can be done in
one simple pass through the input array.
Hint 3
How can you alter the pass through the input array mentioned in Hint #2 so as to obtain the actual answer to the problem, that is the maximum sum of any subarray in the input array?
You should be able to accomplish everything in one loop through the input array.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space
public static int kadanesAlgorithm(int[] array) {
int maxEndingHere = array[0];
int maxSoFar = array[0];
for (int i = 1; i < array.length; i++) {
int num = array[i];
maxEndingHere = Math.max(num, maxEndingHere + num);
maxSoFar = Math.max(maxSoFar, maxEndingHere);
}
return maxSoFar;
}
}
Custom Output Submit Code
Run or submit code
when you're ready.

```
---

## Test Cases

```
Test Case 1
{"array": [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]}
Test Case 2
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
Test Case 3
{"array": [-1, -2, -3, -4, -5, -6, -7, -8, -9, -10]}
Test Case 4
{"array": [-10, -2, -9, -4, -8, -6, -7, -1, -3, -5]}
Test Case 5
{"array": [1, 2, 3, 4, 5, 6, -20, 7, 8, 9, 10]}
Test Case 6
{"array": [1, 2, 3, 4, 5, 6, -22, 7, 8, 9, 10]}
Test Case 7
{"array": [1, 2, -4, 3, 5, -9, 8, 1, 2]}
Test Case 8
{"array": [3, 4, -6, 7, 8]}
Test Case 9
{"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]}
Test Case 10
{"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 6]}
Test Case 11
{"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6]}
Test Case 12
{
  "array": [
    8,
    5,
    -9,
    1,
    3,
    -2,
    3,
    4,
    7,
    2,
    -18,
    6,
    3,
    1,
    -5,
    6,
    20,
    -23,
    15,
    1,
    -3,
  ]
}
Test Case 13
{
  "array": [
    100,
    8,
    5,
    -9,
    1,
    3,
    -2,
    3,
    4,
    7,
    2,
    -18,
    6,
    3,
    1,
    -5,
    6,
    20,
    -23,
    15,
    1,
    -3,
  ]
}
Test Case 14
{"array": [-1000, -1000, 2, 4, -5, -6, -7, -8, -2, -100]}

