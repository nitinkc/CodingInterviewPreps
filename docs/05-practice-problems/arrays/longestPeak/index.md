# Longest Peak

**Category:** Arrays

```
## Problem Statement

Longest Peak
Write a function that takes in an array of integers and returns the length of the longest peak in the array.
A peak is dened as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak), at which point they become strictly
decreasing. At least three integers are required to form a peak.
For example, the integers 1, 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0 . Similarly, the integers 1, 2, 3 don't
form a peak because there aren't any strictly decreasing integers after the 3 .
Sample Input
array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
Sample Output
// 0, 10, 6, 5, -1, -3
Hints
Hint 1
You can solve this question by iterating through the array from left to right once.
Hint 2
Iterate through the array from left to right, and treat every integer as the potential tip of a peak. To be the tip of a peak, an integer has to be strictly greater than its
adjacent integers. What can you do when you nd an actual tip?
Hint 3
As you iterate through the array from left to right, whenever you nd a tip of a peak, expand outwards from the tip until you no longer have a peak. Given what peaks
look like and how many peaks can therefore t in an array, realize that this process results in a linear-time algorithm. Make sure to keep track of the longest peak you
nd as you iterate through the array.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space - where n is the length of the input array
public static int longestPeak(int[] array) {
int longestPeakLength = 0;
int i = 1;
while (i < array.length - 1) {
boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
if (!isPeak) {
i += 1;
continue;
}
int leftIdx = i - 2;
while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
leftIdx -= 1;
}
int rightIdx = i + 2;
while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
rightIdx += 1;
}
int currentPeakLength = rightIdx - leftIdx - 1;
if (currentPeakLength > longestPeakLength) {
longestPeakLength = currentPeakLength;
}
i = rightIdx;
}
return longestPeakLength;
}
}

```
---

## Test Cases

```
​
class Program {
  // O(n) time | O(1) space - where n is the length of the input array
  public static int longestPeak(int[] array) {
    int longestPeakLength = 0;
    int i = 1;
    while (i < array.length - 1) {
      boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
      if (!isPeak) {
        i += 1;
        continue;
      }
​
      int leftIdx = i - 2;
      while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx -= 1;
      }
​
      int rightIdx = i + 2;
      while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx += 1;
      }
      int currentPeakLength = rightIdx - leftIdx - 1;
      if (currentPeakLength > longestPeakLength) {
        longestPeakLength = currentPeakLength;
      }
      i = rightIdx;
    }
    return longestPeakLength;
  }
}
​

```
Test Case 1
{"array": [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]}
Test Case 2
{"array": []}
Test Case 3
{"array": [1, 3, 2]}
Test Case 4
{"array": [1, 2, 3, 4, 5, 1]}
Test Case 5
{"array": [5, 4, 3, 2, 1, 2, 1]}
Test Case 6
{"array": [5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10]}
Test Case 7
{"array": [5, 4, 3, 2, 1, 2, 10, 12]}
Test Case 8
{"array": [1, 2, 3, 4, 5, 6, 10, 100, 1000]}
Test Case 9
{"array": [1, 2, 3, 3, 2, 1]}
Test Case 10
{"array": [1, 1, 3, 2, 1]}
Test Case 11
{"array": [1, 2, 3, 2, 1, 1]}
Test Case 12
{
  "array": [
    1,
    1,
    1,
    2,
    3,
    10,
    12,
    -3,
    -3,
    2,
    3,
    45,
    800,
    99,
    98,
    0,
    -1,
    -1,
    2,
    3,
    4,
    5,
    0,
    -1,
    -1
  ]
}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
Input(s)
{"array": [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]}
Test Case 2 passed!
Our Code's Output
Input(s)
{"array": []}
Test Case 3 passed!
Our Code's Output
Input(s)
{"array": [1, 3, 2]}
Test Case 4 passed!
Our Code's Output
Input(s)
{"array": [1, 2, 3, 4, 5, 1]}
Test Case 5 passed!
Our Code's Output
Input(s)
{"array": [5, 4, 3, 2, 1, 2, 1]}
Test Case 6 passed!
Our Code's Output
Input(s)
{"array": [5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10]}
Test Case 7 passed!
Our Code's Output
Input(s)
{"array": [5, 4, 3, 2, 1, 2, 10, 12]}
Test Case 8 passed!
Our Code's Output
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 10, 100, 1000]}
Test Case 9 passed!
Our Code's Output
Input(s)
{"array": [1, 2, 3, 3, 2, 1]}
Test Case 10 passed!
Our Code's Output
Input(s)
{"array": [1, 1, 3, 2, 1]}
Test Case 11 passed!
Our Code's Output
Input(s)
{"array": [1, 2, 3, 2, 1, 1]}
Test Case 12 passed!
Our Code's Output
Input(s)
{
  "array": [
    1,
    1,
    1,
    2,
    3,
    10,
    12,
    -3,
    -3,
    2,
    3,
    45,
    800,
    99,
    98,
    0,
    -1,
    -1,
    2,
    3,
    4,
    5,
    0,
    -1,
    -1
  ]
}

```
