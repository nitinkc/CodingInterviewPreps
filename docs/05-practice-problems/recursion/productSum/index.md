# Product Sum

**Category:** Recursion

```
## Problem Statement

Product Sum
Write a function that takes in a "special" array and returns its product sum. A "special" array is a non-empty array that contains either integers or other "special" arrays. The product sum of a
"special" array is the sum of its elements, where "special" arrays inside it are summed themselves and then multiplied by their level of depth.
For example, the product sum of [x, y] is x + y ; the product sum of [x, [y, z]] is x + 2y + 2z .
Sample Input
array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
Sample Output
// calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)
Hints
Hint 1
Try using recursion to solve this problem.
Hint 2
Initialize the product sum of the "special" array to 0. Then, iterate through all of the array's elements; if you come across a number, add it to the product sum; if you come across another
"special" array, recursively call the productSum function on it and add the returned value to the product sum. How will you handle multiplying the product sums at a given level of depth?
Hint 3
Have the productSum function take in a second parameter: the multiplier, initialized to 1. Whenever you recursively call the productSum function, pass in the multiplier incremented by
1.
Optimal Space & Time Complexity
O(n) time | O(d) space - where n is the total number of elements in the array, including sub-elements, and d is the greatest depth of "special" arrays in the array

```
---

## Approach & Solution

### Solution 1

Our Solution(s) Run Code Tests
2
3 import java.util.*;
4
5 class Program {
6 // O(n) time | O(d) space - where n is the total number of elements in the array,
7 // including sub-elements, and d is the greatest depth of "special" arrays in the array
8 public static int productSum(List<Object> array) {
9 return productSumHelper(array, 1);
10 }
11
12 public static int productSumHelper(List<Object> array, int multiplier) {
13 int sum = 0;
14 for (Object el : array) {
15 if (el instanceof ArrayList) {
16 @SuppressWarnings("unchecked")
17 ArrayList<Object> ls = (ArrayList<Object>) el;
18 sum += productSumHelper(ls, multiplier + 1);
19 } else {
20 sum += (int) el;
21 }
22 }
23 return sum * multiplier;
24 }
25 }
26
Custom Output Submit Code
Run or submit code when you're
ready.

```
---

## Test Cases

```
Test Case 1
{"array": [5, 2, [7, -1], 3, [6, [-13, 8], 4]]}
Test Case 2
{"array": [1, 2, 3, 4, 5]}
Test Case 3
{"array": [1, 2, [3], 4, 5]}
Test Case 4
{"array": [[1, 2], 3, [4, 5]]}
Test Case 5
{"array": [[[[[5]]]]]}
Test Case 6
{
  "array": [
    9,
    [2, -3, 4],
    1,
    [1, 1, [1, 1, 1]],
    [[[[3, 4, 1]]], 8],
    [1, 2, 3, 4, 5, [6, 7], -7],
    [1, [2, 3, [4, 5]], [6, 0, [7, 0, -8]], -7],
    [1, -3, 2, [1, -3, 2, [1, -3, 2], [1, -3, 2, [1, -3, 2]], [1, -3, 2]]],
    -3
  ]
}

