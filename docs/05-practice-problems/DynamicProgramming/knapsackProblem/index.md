# Knapsack Problem

**Category:** Dynamic Programming

```
## Problem Statement

Knapsack Problem
You're given an array of arrays where each subarray holds two integer values and represents an item; the rst integer is the item's value, and the second integer is the item's weight. You're
also given an integer representing the maximum capacity of a knapsack that you have. Your goal is to t items in your knapsack without having the sum of their weights exceed the knapsack's
capacity, all the while maximizing their combined value.
Write a function that returns the maximized combined value of the items that you should pick as well as an array of the indices of each item picked.
You can assume that there will only be one combination of items that maximizes the total value in the knapsack.
Sample Input
items = [[1, 2], [4, 3], [5, 6], [6, 7]]
capacity = 10
Sample Output
[10, [1, 3]]
Hints
Hint 1
Try building a two-dimensional array of the maximum values that knapsacks of all capacities between 0 and c inclusive could hold, given one, two, three, etc., items. Let columns
represent capacities and rows represent items.
Hint 2
Build up the array mentioned in Hint #1 one row at a time. In other words, nd the maximum values that knapsacks of all capacities between 0 and c can hold with only one item, then
with two, etc., until you use all items. Find a formula that relates the maximum value at any given point to previous values.
Hint 3
Backtrack your way through the two-dimensional array mentioned in Hint #1 to nd which items are in your knapsack. Start at the nal index in the array and check whether or not the
value stored at that index is equal to the value located one row above. If it isn't, then the item represented by the current row is in the knapsack.
Optimal Space & Time Complexity
O(nc) time | O(nc) space - where n is the number of items and c is the capacity

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(nc) time | O(nc) space
public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
int[][] knapsackValues = new int[items.length + 1][capacity + 1];
for (int i = 1; i < items.length + 1; i++) {
int currentWeight = items[i - 1][1];
int currentValue = items[i - 1][0];
for (int c = 0; c < capacity + 1; c++) {
if (currentWeight > c) {
knapsackValues[i][c] = knapsackValues[i - 1][c];
} else {
knapsackValues[i][c] =
Math.max(
knapsackValues[i - 1][c],
knapsackValues[i - 1][c - currentWeight] + currentValue);
}
}
}
return getKnapsackItems(knapsackValues, items, knapsackValues[items.length][capacity]);
}
public static List<List<Integer>> getKnapsackItems(
int[][] knapsackValues, int[][] items, int weight) {
List<List<Integer>> sequence = new ArrayList<List<Integer>>();
List<Integer> totalWeight = new ArrayList<Integer>();
totalWeight.add(weight);
sequence.add(totalWeight);
sequence.add(new ArrayList<Integer>());
int i = knapsackValues.length - 1;
int c = knapsackValues[0].length - 1;
while (i > 0) {
if (knapsackValues[i][c] == knapsackValues[i - 1][c]) {
i--;
} else {
sequence.get(1).add(0, i - 1);
c -= items[i - 1][1];
i--;
}
if (c == 0) {
break;
}
}
return sequence;
}
}

```
---

## Test Cases

```
Test Case 1
{"items": [[1, 2], [4, 3], [5, 6], [6, 7]], "capacity": 10}
Test Case 2
{
  "items": [
    [465, 100],
    [400, 85],
    [255, 55],
    [350, 45],
    [650, 130],
    [1000, 190],
    [455, 100],
    [100, 25],
    [1200, 190],
    [320, 65],
    [750, 100],
    [50, 45],
    [550, 65],
    [100, 50],
    [600, 70],
    [240, 40]
  ],
  "capacity": 200
}
Test Case 3
{
  "items": [
    [465, 100],
    [400, 85],
    [255, 55],
    [350, 45],
    [650, 130],
    [1000, 190],
    [455, 100],
    [100, 25],
    [1200, 190],
    [320, 65],
    [750, 100],
    [50, 45],
    [550, 65],
    [100, 50],
    [600, 70],
    [255, 40]
  ],
  "capacity": 200
}
Test Case 4
{"items": [[2, 1], [70, 70], [30, 30], [69, 69], [100, 100]], "capacity": 100}
Test Case 5
{"items": [[1, 2], [70, 70], [30, 30], [69, 69], [99, 100]], "capacity": 100}
Test Case 6
{"items": [[1, 2], [70, 70], [30, 30], [69, 69], [100, 100]], "capacity": 0}

