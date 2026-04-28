# Spiral Traverse

**Category:** Arrays

```
## Problem Statement

Spiral Traverse
Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n === m) and returns a one-dimensional array of all the array's elements in
spiral order.
Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.
Sample Input
array = [
[1, 2, 3, 4],
[12, 13, 14, 5],
[11, 16, 15, 6],
[10, 9, 8, 7],
]
Sample Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
Hints
Hint 1
You can think of the spiral that you have to traverse as a set of rectangle perimeters that progressively get smaller (i.e., that progressively move inwards in the two-
dimensional array).
Hint 2
Going o of Hint #1, declare four variables: a starting row, a starting column, an ending row, and an ending column. These four variables represent the bounds of the
rst rectangle perimeter in the spiral that you have to traverse. Traverse that perimeter using those bounds, and then move the bounds inwards. End your algorithm
once the starting row passes the ending row or the starting column passes the ending column.
Hint 3
You can solve this problem both iteratively and recursively following very similar logic.
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the total number of elements in the array

```
---

## Approach & Solution

### Solution 1

Our Solution(s) Run Code Tests
Solution 1 Solution 2
Test Case 1
1 {"array": [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]}
2
3 import java.util.*;
4
Test Case 2
5 class Program {
6 // O(n) time | O(n) space - where n is the total number of elements in the array
1 {"array": [[1]]}
7 public static List<Integer> spiralTraverse(int[][] array) {
8 if (array.length == 0) return new ArrayList<Integer>();
9
Test Case 3
10 var result = new ArrayList<Integer>();
11 spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
1 {"array": [[1, 2], [4, 3]]}
12 return result;
13 }
14
Test Case 4
15 public static void spiralFill(
16 int[][] array,
1 {"array": [[1, 2, 3], [8, 9, 4], [7, 6, 5]]}
17 int startRow,
18 int endRow,
19 int startCol,
Test Case 5
20 int endCol,
21 ArrayList<Integer> result) {
1 {
22 if (startRow > endRow || startCol > endCol) {
2 "array": [
23 return;
3 [1, 2, 3, 4, 5, 6],
24 }
4 [20, 21, 22, 23, 24, 7],
25
5 [19, 32, 33, 34, 25, 8],
26 for (int col = startCol; col <= endCol; col++) {
6 [18, 31, 36, 35, 26, 9],
27 result.add(array[startRow][col]);
7 [17, 30, 29, 28, 27, 10],
28 }
8 [16, 15, 14, 13, 12, 11]
29
9 ]
30 for (int row = startRow + 1; row <= endRow; row++) {
10 }
31 result.add(array[row][endCol]);
32 }
33
Test Case 6
34 for (int col = endCol - 1; col >= startCol; col--) {
35 // Handle the edge case when there's a single row
1 {
36 // in the middle of the matrix. In this case, we don't
2 "array": [
37 // want to double-count the values in this row, which
38 // we've already counted in the first for loop above.
39 // See Test Case 8 for an example of this edge case. Custom Output Submit Code
40 if (startRow == endRow) break;
41 result.add(array[endRow][col]);
42 }
43
44 for (int row = endRow - 1; row >= startRow + 1; row--) {
45 // Handle the edge case when there's a single column
46 // in the middle of the matrix. In this case, we don't
47 // want to double-count the values in this column, which
48 // we've already counted in the second for loop above.
49 // See Test Case 9 for an example of this edge case.
50 if (startCol == endCol) break;
51 result.add(array[row][startCol]);
52 }
53 spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
54 }
55 }
56

### Solution 2

```
Solution 1 Solution 2
import java.util.*;
class Program {
// O(n) time | O(n) space - where n is the total number of elements in the array
public static List<Integer> spiralTraverse(int[][] array) {
if (array.length == 0) return new ArrayList<Integer>();
var result = new ArrayList<Integer>();
spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
return result;
}
public static void spiralFill(
int[][] array,
int startRow,
int endRow,
int startCol,
int endCol,
ArrayList<Integer> result) {
if (startRow > endRow || startCol > endCol) {
return;
}
for (int col = startCol; col <= endCol; col++) {
result.add(array[startRow][col]);
}
for (int row = startRow + 1; row <= endRow; row++) {
result.add(array[row][endCol]);
}
for (int col = endCol - 1; col >= startCol; col--) {
// Handle the edge case when there's a single row
// in the middle of the matrix. In this case, we don't
// want to double-count the values in this row, which
// we've already counted in the first for loop above.
// See Test Case 8 for an example of this edge case.

### Solution 3

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(n) time | O(n) space - where n is the total number of elements in the array
7 public static List<Integer> spiralTraverse(int[][] array) {
8 if (array.length == 0) return new ArrayList<Integer>();
9
10 var result = new ArrayList<Integer>();
11 var startRow = 0;
12 var endRow = array.length - 1;
13 var startCol = 0;
14 var endCol = array[0].length - 1;
15
16 while (startRow <= endRow && startCol <= endCol) {
17 for (int col = startCol; col <= endCol; col++) {
18 result.add(array[startRow][col]);
19 }
20
21 for (int row = startRow + 1; row <= endRow; row++) {
22 result.add(array[row][endCol]);
23 }
24
25 for (int col = endCol - 1; col >= startCol; col--) {
26 // Handle the edge case when there's a single row
27 // in the middle of the matrix. In this case, we don't
28 // want to double-count the values in this row, which
29 // we've already counted in the first for loop above.
30 // See Test Case 8 for an example of this edge case.
31 if (startRow == endRow) break;
32 result.add(array[endRow][col]);
33 }
34
35 for (int row = endRow - 1; row > startRow; row--) {
36 // Handle the edge case when there's a single column
37 // in the middle of the matrix. In this case, we don't
38 // want to double-count the values in this column, which
39 // we've already counted in the second for loop above.
40 // See Test Case 9 for an example of this edge case.
41 if (startCol == endCol) break;
42 result.add(array[row][startCol]);
43 }
44
45 startRow++;
46 endRow--;
47 startCol++;
48 endCol--;
49 }
50 return result;
51 }
52 }
53

```
---

## Test Cases

```
1
2
​
3
import java.util.*;
4
​
5
class Program {
6
  // O(n) time | O(n) space - where n is the total number of elements in the array
7
  public static List<Integer> spiralTraverse(int[][] array) {
8
    if (array.length == 0) return new ArrayList<Integer>();
9
​
10
    var result = new ArrayList<Integer>();
11
    spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
12
    return result;
13
  }
14
​
15
  public static void spiralFill(
16
      int[][] array,
17
      int startRow,
18
      int endRow,
19
      int startCol,
20
      int endCol,
21
      ArrayList<Integer> result) {
22
    if (startRow > endRow || startCol > endCol) {
23
      return;
24
    }
25
​
26
    for (int col = startCol; col <= endCol; col++) {
27
      result.add(array[startRow][col]);
28
    }
29
​
30
    for (int row = startRow + 1; row <= endRow; row++) {
31
      result.add(array[row][endCol]);
32
    }
33
​
34
    for (int col = endCol - 1; col >= startCol; col--) {
35
      // Handle the edge case when there's a single row
36
      // in the middle of the matrix. In this case, we don't
37
      // want to double-count the values in this row, which
38
      // we've already counted in the first for loop above.
39
      // See Test Case 8 for an example of this edge case.
40
      if (startRow == endRow) break;
41
      result.add(array[endRow][col]);
42
    }
43
​
44
    for (int row = endRow - 1; row >= startRow + 1; row--) {
45
      // Handle the edge case when there's a single column
46
      // in the middle of the matrix. In this case, we don't
47
      // want to double-count the values in this column, which
48
      // we've already counted in the second for loop above.
49
      // See Test Case 9 for an example of this edge case.
50
      if (startCol == endCol) break;
51
      result.add(array[row][startCol]);
52
    }
53
    spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
54
  }
55
}
56
​

```
Test Case 1
{"array": [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]}
Test Case 2
{"array": [[1]]}
Test Case 3
{"array": [[1, 2], [4, 3]]}
Test Case 4
{"array": [[1, 2, 3], [8, 9, 4], [7, 6, 5]]}
Test Case 5
{
  "array": [
    [1, 2, 3, 4, 5, 6],
    [20, 21, 22, 23, 24, 7],
    [19, 32, 33, 34, 25, 8],
    [18, 31, 36, 35, 26, 9],
    [17, 30, 29, 28, 27, 10],
    [16, 15, 14, 13, 12, 11]
  ]
}
Test Case 6
{
  "array": [
    [1, 2, 3, 4, 5, 6, 7, 8, 9],
    [22, 23, 24, 25, 26, 27, 28, 29, 10],
    [21, 36, 35, 34, 33, 32, 31, 30, 11],
    [20, 19, 18, 17, 16, 15, 14, 13, 12]
  ]
}
Test Case 7
{
  "array": [
    [1, 2, 3, 4],
    [22, 23, 24, 5],
    [21, 36, 25, 6],
    [20, 35, 26, 7],
    [19, 34, 27, 8],
    [18, 33, 28, 9],
    [17, 32, 29, 10],
    [16, 31, 30, 11],
    [15, 14, 13, 12]
  ]
}
Test Case 8
{"array": [[1, 2, 3, 4], [10, 11, 12, 5], [9, 8, 7, 6]]}
Test Case 9
{"array": [[1, 2, 3], [12, 13, 4], [11, 14, 5], [10, 15, 6], [9, 8, 7]]}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
Input(s)
{"array": [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]}
Test Case 2 passed!
Our Code's Output
[1]
Input(s)
{"array": [[1]]}
Test Case 3 passed!
Our Code's Output
[1, 2, 3, 4]
Input(s)
{"array": [[1, 2], [4, 3]]}
Test Case 4 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9]
Input(s)
{"array": [[1, 2, 3], [8, 9, 4], [7, 6, 5]]}
Test Case 5 passed!
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
  30,
  31,
  32,
  33,
  34,
  35,
  36
]
Input(s)
{
  "array": [
    [1, 2, 3, 4, 5, 6],
    [20, 21, 22, 23, 24, 7],
    [19, 32, 33, 34, 25, 8],
    [18, 31, 36, 35, 26, 9],
    [17, 30, 29, 28, 27, 10],
    [16, 15, 14, 13, 12, 11]
  ]
}
Test Case 6 passed!
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
  30,
  31,
  32,
  33,
  34,
  35,
  36
]
Input(s)
{
  "array": [
    [1, 2, 3, 4, 5, 6, 7, 8, 9],
    [22, 23, 24, 25, 26, 27, 28, 29, 10],
    [21, 36, 35, 34, 33, 32, 31, 30, 11],
    [20, 19, 18, 17, 16, 15, 14, 13, 12]
  ]
}
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
  25,
  26,
  27,
  28,
  29,
  30,
  31,
  32,
  33,
  34,
  35,
  36
]
Input(s)
{
  "array": [
    [1, 2, 3, 4],
    [22, 23, 24, 5],
    [21, 36, 25, 6],
    [20, 35, 26, 7],
    [19, 34, 27, 8],
    [18, 33, 28, 9],
    [17, 32, 29, 10],
    [16, 31, 30, 11],
    [15, 14, 13, 12]
  ]
}
Test Case 8 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
Input(s)
{"array": [[1, 2, 3, 4], [10, 11, 12, 5], [9, 8, 7, 6]]}
Test Case 9 passed!
Our Code's Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
Input(s)
{"array": [[1, 2, 3], [12, 13, 4], [11, 14, 5], [10, 15, 6], [9, 8, 7]]}

```
