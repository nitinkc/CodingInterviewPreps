# Water Area

**Category:** Dynamic Programming

```
## Problem Statement

Water Area
You're given an array of non-negative integers where each non-zero integer represents the height of a pillar of width 1 . Imagine water being poured over all of the pillars; write a function
that returns the surface area of the water trapped between the pillars viewed from the front. Note that spilled water should be ignored.
Refer to the rst minute of this question's video explanation for a visual example.
Sample Input
heights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
Sample Output
Hints
Hint 1
In order to calculate the amount of water above a single point in the input array, you must know the height of the tallest pillar to its left and the height of the tallest pillar to its right.
Hint 2
If a point can hold water above it, then the smallest of the two heights mentioned in Hint #1 minus the height at that respective point should lead you to the amount of water above it.
Hint 3
Try building an array of the left and right max heights for each point in the input array. You should be able to build this array and to compute the nal amount of water above each point
in just two loops over the input array.
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(n) space
public static int waterArea(int[] heights) {
int[] maxes = new int[heights.length];
int leftMax = 0;
for (int i = 0; i < heights.length; i++) {
int height = heights[i];
maxes[i] = leftMax;
leftMax = Math.max(leftMax, height);
}
int rightMax = 0;
for (int i = heights.length - 1; i >= 0; i--) {
int height = heights[i];
int minHeight = Math.min(rightMax, maxes[i]);
if (height < minHeight) {
maxes[i] = minHeight - height;
} else {
maxes[i] = 0;
}
rightMax = Math.max(rightMax, height);
}
int total = 0;
for (int i = 0; i < heights.length; i++) {
total += maxes[i];
}
return total;
}
}
bmCitu Cstoodme Ou
Ru
wh

```
---

## Test Cases

```
Hide

```
Test Case 1
{"heights": [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]}
Test Case 2
{"heights": []}
Test Case 3
{"heights": [0, 0, 0, 0, 0]}
Test Case 4
{"heights": [0, 1, 0, 0, 0]}
Test Case 5
{"heights": [0, 1, 1, 0, 0]}
Test Case 6
{"heights": [0, 1, 2, 1, 1]}
Test Case 7
{"heights": [0, 1, 0, 1, 0]}
Test Case 8
{"heights": [0, 1, 0, 1, 0, 2, 0, 3]}
Test Case 9
{"heights": [0, 8, 0, 0, 10, 0, 0, 10, 0, 0, 1, 1, 0, 3]}
Test Case 10
{"heights": [0, 100, 0, 0, 10, 1, 1, 10, 1, 0, 1, 1, 0, 100]}
Test Case 11
{"heights": [0, 100, 0, 0, 10, 1, 1, 10, 1, 0, 1, 1, 0, 0]}

