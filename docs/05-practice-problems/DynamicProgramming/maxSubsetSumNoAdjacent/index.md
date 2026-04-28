# Max Subset Sum No Adjacent

**Category:** Dynamic Programming

```
## Problem Statement

Max Subset Sum No Adjacent
Write a function that takes in an array of positive integers and returns the maximum sum of non-adjacent elements in the array.
If a sum can't be generated, the function should return 0 .
Sample Input
array = [75, 105, 120, 75, 90, 135]
Sample Output
// 75, 120, 135
Hints
Hint 1
Try building an array of the same length as the input array. At each index in this new array, store the maximum sum that can be generated using no adjacent numbers located between
index 0 and the current index.
Hint 2
Can you come up with a formula that relates the max sum at index i to the max sums at indices i - 1 and i - 2?
Hint 3
Do you really need to store the entire array mentioned in Hint #1, or can you somehow store just the max sums that you need at any point in time?
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// O(n) time | O(1) space
public static int maxSubsetSumNoAdjacent(int[] array) {
if (array.length == 0) {
return 0;
} else if (array.length == 1) {
return array[0];
}
int second = array[0];
int first = Math.max(array[0], array[1]);
for (int i = 2; i < array.length; i++) {
int current = Math.max(first, second + array[i]);
second = first;
first = current;
}
return first;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(n) time | O(n) space
5 public static int maxSubsetSumNoAdjacent(int[] array) {
6 if (array.length == 0) {
7 return 0;
8 } else if (array.length == 1) {
9 return array[0];
10 }
11 int[] maxSums = array.clone();
12 maxSums[1] = Math.max(array[0], array[1]);
13 for (int i = 2; i < array.length; i++) {
14 maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
15 }
16 return maxSums[array.length - 1];
17 }
18 }
19

```
---

## Test Cases

```
Hide

```
Test Case 1
{"array": [75, 105, 120, 75, 90, 135]}
Test Case 2
{"array": []}
Test Case 3
{"array": [1]}
Test Case 4
{"array": [1, 2]}
Test Case 5
{"array": [1, 2, 3]}
Test Case 6
{"array": [1, 15, 3]}
Test Case 7
{"array": [7, 10, 12, 7, 9, 14]}
Test Case 8
{"array": [4, 3, 5, 200, 5, 3]}
Test Case 9
{"array": [10, 5, 20, 25, 15, 5, 5, 15]}
Test Case 10
{"array": [10, 5, 20, 25, 15, 5, 5, 15, 3, 15, 5, 5, 15]}
Test Case 11
{"array": [125, 210, 250, 120, 150, 300]}
Test Case 12
{"array": [30, 25, 50, 55, 100]}
Test Case 13
{"array": [30, 25, 50, 55, 100, 120]}
Test Case 14
{"array": [7, 10, 12, 7, 9, 14, 15, 16, 25, 20, 4]}

