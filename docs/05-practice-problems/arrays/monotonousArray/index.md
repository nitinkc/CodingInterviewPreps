# Monotonous Array

**Category:** Arrays

```
## Problem Statement

Monotonic Array
Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic.
An array is said to be monotonic if its elements, from left to right, are entirely non-increasing or entirely non-decreasing.
Sample Input
array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
Sample Output
true
Hints
Hint 1
You can solve this question by iterating through the input array from left to right once.
Hint 2
Try iterating through the input array from left to right, in search of two adjacent integers that can indicate whether the array is trending upward or downward. Once
you've found the tentative trend of the array, at each element thereafter, compare the element to the previous one; if this comparison breaks the previously identied
trend, the array isn't monotonic.
Hint 3
Alternatively, you can start by assuming that the array is both entirely non-decreasing and entirely non-increasing. As you iterate through each element, perform a
check to see if you can invalidate one or both of your assumptions.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// O(n) time | O(1) space - where n is the length of the array
public static boolean isMonotonic(int[] array) {
var isNonDecreasing = true;
var isNonIncreasing = true;
for (int i = 1; i < array.length; i++) {
if (array[i] < array[i - 1]) {
isNonDecreasing = false;
}
if (array[i] > array[i - 1]) {
isNonIncreasing = false;
}
}
return isNonDecreasing || isNonIncreasing;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(n) time | O(1) space - where n is the length of the array
5 public static boolean isMonotonic(int[] array) {
6 if (array.length <= 2) return true;
7
8 var direction = array[1] - array[0];
9 for (int i = 2; i < array.length; i++) {
10 if (direction == 0) {
11 direction = array[i] - array[i - 1];
12 continue;
13 }
14
15 if (breaksDirection(direction, array[i - 1], array[i])) {
16 return false;
17 }
18 }
19 return true;
20 }
21
22 public static boolean breaksDirection(int direction, int previous, int current) {
23 var difference = current - previous;
24 if (direction > 0) return difference < 0;
25 return difference > 0;
26 }
27 }
28

```
---

## Test Cases

```
▲
1
2
​
3
class Program {
4
  // O(n) time | O(1) space - where n is the length of the array
5
  public static boolean isMonotonic(int[] array) {
6
    var isNonDecreasing = true;
7
    var isNonIncreasing = true;
8
    for (int i = 1; i < array.length; i++) {
9
      if (array[i] < array[i - 1]) {
10
        isNonDecreasing = false;
11
      }
12
      if (array[i] > array[i - 1]) {
13
        isNonIncreasing = false;
14
      }
15
    }
16
​
17
    return isNonDecreasing || isNonIncreasing;
18
  }
19
}
20
​

```
Test Case 1
{"array": [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]}
Test Case 2
{"array": []}
Test Case 3
{"array": [1]}
Test Case 4
{"array": [1, 2]}
Test Case 5
{"array": [2, 1]}
Test Case 6
{"array": [1, 5, 10, 1100, 1101, 1102, 9001]}
Test Case 7
{"array": [-1, -5, -10, -1100, -1101, -1102, -9001]}
Test Case 8
{"array": [-1, -5, -10, -1100, -900, -1101, -1102, -9001]}
Test Case 9
{"array": [1, 2, 0]}
Test Case 10
{"array": [1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11]}
Test Case 11
{"array": [1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11]}
Test Case 12
{"array": [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11]}
Test Case 13
{"array": [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11]}
Test Case 14
{"array": [-1, -1, -1, -1, -1, -1, -1, -1]}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
true
Input(s)
{"array": [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]}
Test Case 2 passed!
Our Code's Output
true
Input(s)
{"array": []}
Test Case 3 passed!
Our Code's Output
true
Input(s)
{"array": [1]}
Test Case 4 passed!
Our Code's Output
true
Input(s)
{"array": [1, 2]}
Test Case 5 passed!
Our Code's Output
true
Input(s)
{"array": [2, 1]}
Test Case 6 passed!
Our Code's Output
true
Input(s)
{"array": [1, 5, 10, 1100, 1101, 1102, 9001]}
Test Case 7 passed!
Our Code's Output
true
Input(s)
{"array": [-1, -5, -10, -1100, -1101, -1102, -9001]}
Test Case 8 passed!
Our Code's Output
false
Input(s)
{"array": [-1, -5, -10, -1100, -900, -1101, -1102, -9001]}
Test Case 9 passed!
Our Code's Output
false
Input(s)
{"array": [1, 2, 0]}
Test Case 10 passed!
Our Code's Output
false
Input(s)
{"array": [1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11]}
Test Case 11 passed!
Our Code's Output
true
Input(s)
{"array": [1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11]}
Test Case 12 passed!
Our Code's Output
false
Input(s)
{"array": [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11]}
Test Case 13 passed!
Our Code's Output
true
Input(s)
{"array": [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11]}
Test Case 14 passed!
Our Code's Output
true
Input(s)
{"array": [-1, -1, -1, -1, -1, -1, -1, -1]}

```
