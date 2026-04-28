# Largest Range

**Category:** Arrays

```
## Problem Statement

Largest Range
Write a function that takes in an array of integers and returns an array of length 2 representing the largest range of integers contained in that array.
The rst number in the output array should be the rst number in the range, while the second number should be the last number in the range.
A range of numbers is dened as a set of numbers that come right after each other in the set of real integers. For instance, the output array [2, 6] represents the
range {2, 3, 4, 5, 6} , which is a range of length 5. Note that numbers don't need to be sorted or adjacent in the input array in order to form a range.
You can assume that there will only be one largest range.
Sample Input
array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
Sample Output
[0, 7]
Hints
Hint 1
How can you use a hash table to solve this problem with an algorithm that runs in linear time?
Hint 2
Iterate through the input array once, storing every unique number in a hash table and mapping every number to a falsy value. This hash table will not only provide
for fast access of the numbers in the input array, but it will also allow you to keep track of "visited" and "unvisited" numbers, so as not to unnecessarily repeat
work.
Hint 3
Iterate through the input array once more, this time stopping at every number to check if the number is marked as "visited" in the hash table. If it is, skip it; if it
isn't, start expanding outwards from that number with a left number and a right number, continuously checking if those left and right numbers are in the hash
table (and thus in the input array), and marking them as "visited" in the hash table if they are. This should allow you to quickly nd the largest range in which the
current number is contained, all the while setting you up not to perform unnecessary work later.
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(n) space
public static int[] largestRange(int[] array) {
int[] bestRange = new int[2];
int longestLength = 0;
Map<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
for (int num : array) {
nums.put(num, true);
}
for (int num : array) {
if (!nums.get(num)) {
continue;
}
nums.put(num, false);
int currentLength = 1;
int left = num - 1;
int right = num + 1;
while (nums.containsKey(left)) {
nums.put(left, false);
currentLength++;
left--;
}
while (nums.containsKey(right)) {
nums.put(right, false);
currentLength++;
right++;
}
if (currentLength > longestLength) {
longestLength = currentLength;
bestRange = new int[] {left + 1, right - 1};
}
}
return bestRange;
}
}

```
---

## Test Cases

```
Test Case 1
{"array": [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]}
Test Case 2
{"array": [1]}
Test Case 3
{"array": [1, 2]}
Test Case 4
{"array": [4, 2, 1, 3]}
Test Case 5
{"array": [4, 2, 1, 3, 6]}
Test Case 6
{"array": [8, 4, 2, 10, 3, 6, 7, 9, 1]}
Test Case 7
{
  "array": [
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
  ]
}
Test Case 8
{
  "array": [
    0,
    9,
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
  ]
}
Test Case 9
{
  "array": [
    0,
    -5,
    9,
    19,
    -1,
    18,
    17,
    2,
    -4,
    -3,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    7,
    -6,
    -7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
    14,
    -2
  ]
}
Test Case 10
{
  "array": [
    -7,
    -7,
    -7,
    -7,
    8,
    -8,
    0,
    9,
    19,
    -1,
    -3,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    -6,
    8,
    7,
    6,
    15,
    12,
    12,
    -5,
    2,
    1,
    6,
    13,
    14,
    -4,
    -2
  ]
}

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
  // O(n) time | O(n) space
7
  public static int[] largestRange(int[] array) {
8
    int[] bestRange = new int[2];
9
    int longestLength = 0;
10
    Map<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
11
    for (int num : array) {
12
      nums.put(num, true);
13
    }
14
    for (int num : array) {
15
      if (!nums.get(num)) {
16
        continue;
17
      }
18
      nums.put(num, false);
19
      int currentLength = 1;
20
      int left = num - 1;
21
      int right = num + 1;
22
      while (nums.containsKey(left)) {
23
        nums.put(left, false);
24
        currentLength++;
25
        left--;
26
      }
27
      while (nums.containsKey(right)) {
28
        nums.put(right, false);
29
        currentLength++;
30
        right++;
31
      }
32
      if (currentLength > longestLength) {
33
        longestLength = currentLength;
34
        bestRange = new int[] {left + 1, right - 1};
35
      }
36
    }
37
    return bestRange;
38
  }
39
}
40
​

```
Test Case 1
{"array": [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]}
Test Case 2
{"array": [1]}
Test Case 3
{"array": [1, 2]}
Test Case 4
{"array": [4, 2, 1, 3]}
Test Case 5
{"array": [4, 2, 1, 3, 6]}
Test Case 6
{"array": [8, 4, 2, 10, 3, 6, 7, 9, 1]}
Test Case 7
{
  "array": [
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
  ]
}
Test Case 8
{
  "array": [
    0,
    9,
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
  ]
}
Test Case 9
{
  "array": [
    0,
    -5,
    9,
    19,
    -1,
    18,
    17,
    2,
    -4,
    -3,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    7,
    -6,
    -7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
    14,
    -2
  ]
}
Test Case 10
{
  "array": [
    -7,
    -7,
    -7,
    -7,
    8,
    -8,
    0,
    9,
    19,
    -1,
    -3,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    -6,
    8,
    7,
    6,
    15,
    12,
    12,
    -5,
    2,
    1,
    6,
    13,
    14,
    -4,
    -2
  ]
}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[0, 7]
Input(s)
{"array": [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]}
Test Case 2 passed!
Our Code's Output
[1, 1]
Input(s)
{"array": [1]}
Test Case 3 passed!
Our Code's Output
[1, 2]
Input(s)
{"array": [1, 2]}
Test Case 4 passed!
Our Code's Output
[1, 4]
Input(s)
{"array": [4, 2, 1, 3]}
Test Case 5 passed!
Our Code's Output
[1, 4]
Input(s)
{"array": [4, 2, 1, 3, 6]}
Test Case 6 passed!
Our Code's Output
[6, 10]
Input(s)
{"array": [8, 4, 2, 10, 3, 6, 7, 9, 1]}
Test Case 7 passed!
Our Code's Output
[10, 19]
Input(s)
{
  "array": [
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
    14
  ]
}
Test Case 8 passed!
Our Code's Output
[-1, 19]
Input(s)
{
  "array": [
    0,
    9,
    19,
    -1,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    8,
    7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
    14
  ]
}
Test Case 9 passed!
Our Code's Output
[-7, 7]
Input(s)
{
  "array": [
    0,
    -5,
    9,
    19,
    -1,
    18,
    17,
    2,
    -4,
    -3,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    7,
    -6,
    -7,
    6,
    15,
    12,
    12,
    2,
    1,
    6,
    13,
    14,
    -2
  ]
}
Test Case 10 passed!
Our Code's Output
[-8, 19]
Input(s)
{
  "array": [
    -7,
    -7,
    -7,
    -7,
    8,
    -8,
    0,
    9,
    19,
    -1,
    -3,
    18,
    17,
    2,
    10,
    3,
    12,
    5,
    16,
    4,
    11,
    -6,
    8,
    7,
    6,
    15,
    12,
    12,
    -5,
    2,
    1,
    6,
    13,
    14,
    -4,
    -2
  ]
}

```
