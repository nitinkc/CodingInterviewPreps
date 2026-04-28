# Zigzag Traverse

**Category:** Arrays

```
## Problem Statement

Zigzag Traverse
Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n === m) and returns a one-dimensional array of all the array's elements in
zigzag order.
Zigzag order starts at the top left corner of the two-dimensional array, goes down by one element, and proceeds in a zigzag pattern all the way to the bottom right corner.
Sample Input
array = [
[1, 3, 4, 10],
[2, 5, 9, 11],
[6, 8, 12, 15],
[7, 13, 14, 16],
]
Sample Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
Hints
Hint 1
Don't overthink this question by trying to come up with a clever way of getting the zigzag order. Think about the simplest checks that need to be made to decide when
and how to change direction throughout the zigzag traversal.
Hint 2
Starting at the top left corner, iterate through the two-dimensional array by keeping track of the direction that you're moving in (up or down). If you're moving up, you
know that you need to move in an up-right pattern and that you need to handle the case where you hit the top or the right borders of the array. If you're moving down,
you know that you need to move in a down-left pattern and that you need to handle the case where you hit the left or the bottom borders of the array.
Hint 3
When going up, if you hit the right border, you'll have to go down one element; if you hit the top border, you'll have to go right one element. Similarly, when going
down, if you hit the left border, you'll have to go down one element; if you hit the bottom border, you'll have to go right one element.
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the total number of elements in the two-dimensional array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
// O(n) time | O(n) space - where n is the total number of elements in the two-dimensional array
class Program {
public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
int height = array.size() - 1;
int width = array.get(0).size() - 1;
List<Integer> result = new ArrayList<Integer>();
int row = 0;
int col = 0;
boolean goingDown = true;
while (!isOutOfBounds(row, col, height, width)) {
result.add(array.get(row).get(col));
if (goingDown) {
if (col == 0 || row == height) {
goingDown = false;
if (row == height) {
col++;
} else {
row++;
}
} else {
row++;
col--;
}
} else {
if (row == 0 || col == width) {
goingDown = true;
if (col == width) {
row++;
} else {
col++;
}
} else {
row--;
col++;
}

```
---

## Test Cases

```
Video Solution
Video Solution

```
Test Case 1
{"array": [[1, 3, 4, 10], [2, 5, 9, 11], [6, 8, 12, 15], [7, 13, 14, 16]]}
Test Case 2
{"array": [[1]]}
Test Case 3
{"array": [[1, 2, 3, 4, 5]]}
Test Case 4
{"array": [[1], [2], [3], [4], [5]]}
Test Case 5
{"array": [[1, 3], [2, 4], [5, 7], [6, 8], [9, 10]]}
Test Case 6
{"array": [[1, 3, 4, 7, 8], [2, 5, 6, 9, 10]]}
Test Case 7
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 19],
    [6, 8, 13, 18, 20],
    [7, 14, 17, 21, 24],
    [15, 16, 22, 23, 25]
  ]
}
Test Case 8
{
  "array": [
    [1, 3, 4, 10, 11, 20],
    [2, 5, 9, 12, 19, 21],
    [6, 8, 13, 18, 22, 27],
    [7, 14, 17, 23, 26, 28],
    [15, 16, 24, 25, 29, 30]
  ]
}
Test Case 9
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 20],
    [6, 8, 13, 19, 21],
    [7, 14, 18, 22, 27],
    [15, 17, 23, 26, 28],
    [16, 24, 25, 29, 30]
  ]
}

```
Video Solution

​
import java.util.*;
​
// O(n) time | O(n) space - where n is the total number of elements in the two-dimensional array
class Program {
  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    int height = array.size() - 1;
    int width = array.get(0).size() - 1;
    List<Integer> result = new ArrayList<Integer>();
    int row = 0;
    int col = 0;
    boolean goingDown = true;
    while (!isOutOfBounds(row, col, height, width)) {
      result.add(array.get(row).get(col));
      if (goingDown) {
        if (col == 0 || row == height) {
          goingDown = false;
          if (row == height) {
            col++;
          } else {
            row++;
          }
        } else {
          row++;
          col--;
        }
      } else {
        if (row == 0 || col == width) {
          goingDown = true;
          if (col == width) {
            row++;
          } else {
            col++;
          }
        } else {
          row--;
          col++;
        }
      }
    }
    return result;
  }
​
  public static boolean isOutOfBounds(int row, int col, int height, int width) {
    return row < 0 || row > height || col < 0 || col > width;
  }
}
​

```
Test Case 1
{"array": [[1, 3, 4, 10], [2, 5, 9, 11], [6, 8, 12, 15], [7, 13, 14, 16]]}
Test Case 2
{"array": [[1]]}
Test Case 3
{"array": [[1, 2, 3, 4, 5]]}
Test Case 4
{"array": [[1], [2], [3], [4], [5]]}
Test Case 5
{"array": [[1, 3], [2, 4], [5, 7], [6, 8], [9, 10]]}
Test Case 6
{"array": [[1, 3, 4, 7, 8], [2, 5, 6, 9, 10]]}
Test Case 7
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 19],
    [6, 8, 13, 18, 20],
    [7, 14, 17, 21, 24],
    [15, 16, 22, 23, 25]
  ]
}
Test Case 8
{
  "array": [
    [1, 3, 4, 10, 11, 20],
    [2, 5, 9, 12, 19, 21],
    [6, 8, 13, 18, 22, 27],
    [7, 14, 17, 23, 26, 28],
    [15, 16, 24, 25, 29, 30]
  ]
}
Test Case 9
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 20],
    [6, 8, 13, 19, 21],
    [7, 14, 18, 22, 27],
    [15, 17, 23, 26, 28],
    [16, 24, 25, 29, 30]
  ]
}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
Input(s)
{"array": [[1, 3, 4, 10], [2, 5, 9, 11], [6, 8, 12, 15], [7, 13, 14, 16]]}
Test Case 2 passed!
Our Code's Output
[1]
Input(s)
{"array": [[1]]}
Test Case 3 passed!
Our Code's Output
[1, 2, 3, 4, 5]
Input(s)
{"array": [[1, 2, 3, 4, 5]]}
Test Case 4 passed!
Our Code's Output
[1, 2, 3, 4, 5]
Input(s)
{"array": [[1], [2], [3], [4], [5]]}
Test Case 5 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Input(s)
{"array": [[1, 3], [2, 4], [5, 7], [6, 8], [9, 10]]}
Test Case 6 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Input(s)
{"array": [[1, 3, 4, 7, 8], [2, 5, 6, 9, 10]]}
Test Case 7 passed!
Our Code's Output
[
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
  20,
  21,
  22,
  23,
  24,
]
Input(s)
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 19],
    [6, 8, 13, 18, 20],
    [7, 14, 17, 21, 24],
    [15, 16, 22, 23, 25]
  ]
}
Test Case 8 passed!
Our Code's Output
[
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
  20,
  21,
  22,
  23,
  24,
  25,
  26,
  27,
  28,
  29,
]
Input(s)
{
  "array": [
    [1, 3, 4, 10, 11, 20],
    [2, 5, 9, 12, 19, 21],
    [6, 8, 13, 18, 22, 27],
    [7, 14, 17, 23, 26, 28],
    [15, 16, 24, 25, 29, 30]
  ]
}
Test Case 9 passed!
Our Code's Output
[
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
  20,
  21,
  22,
  23,
  24,
  25,
  26,
  27,
  28,
  29,
]
Input(s)
{
  "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 20],
    [6, 8, 13, 19, 21],
    [7, 14, 18, 22, 27],
    [15, 17, 23, 26, 28],
    [16, 24, 25, 29, 30]
  ]
}

```
