# Three Number Sum

**Category:** Arrays

```
## Problem Statement

Three Number Sum
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should nd all triplets in the array that sum up to
the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should
be ordered in ascending order with respect to the numbers they hold.
If no three numbers sum up to the target sum, the function should return an empty array.
Sample Input
array = [12, 3, 1, 2, -6, 5, -8, 6]
targetSum = 0
Sample Output
[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
Hints
Hint 1
Using three for loops to calculate the sums of all possible triplets in the array would generate an algorithm that runs in O(n^3) time, where n is the length of the input
array. Can you come up with something faster using only two for loops?
Hint 2
Try sorting the array and traversing it once. At each number, place a left pointer on the number immediately to the right of your current number and a right pointer on
the nal number in the array. Check if the current number, the left number, and the right number sum up to the target sum. How can you proceed from there,
remembering the fact that you sorted the array?
Hint 3
Since the array is now sorted (see Hint #2), you know that moving the left pointer mentioned in Hint #2 one place to the right will lead to a greater left number and
thus a greater sum. Similarly, you know that moving the right pointer one place to the left will lead to a smaller right number and thus a smaller sum. This means that,
depending on the size of each triplet's (current number, left number, right number) sum relative to the target sum, you should either move the left pointer, the right
pointer, or both to obtain a potentially valid triplet.
Optimal Space & Time Complexity
O(n^2) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

Prompt Scratchpad Our Solution(s) Video Explanation Run Code
2
3 import java.util.*;
4
5 class Program {
6 // O(n^2) time | O(n) space
7 public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
8 Arrays.sort(array);
9 List<Integer[]> triplets = new ArrayList<Integer[]>();
10 for (int i = 0; i < array.length - 2; i++) {
11 int left = i + 1;
12 int right = array.length - 1;
13 while (left < right) {
14 int currentSum = array[i] + array[left] + array[right];
15 if (currentSum == targetSum) {
16 Integer[] newTriplet = {array[i], array[left], array[right]};
17 triplets.add(newTriplet);
18 left++;
19 right--;
20 } else if (currentSum < targetSum) {
21 left++;
22 } else if (currentSum > targetSum) {
23 right--;
24 }
25 }
26 }
27 return triplets;
28 }
29 }
30

```
---

## Test Cases

```
Video Solution

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
  // O(n^2) time | O(n) space
7
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
8
    Arrays.sort(array);
9
    List<Integer[]> triplets = new ArrayList<Integer[]>();
10
    for (int i = 0; i < array.length - 2; i++) {
11
      int left = i + 1;
12
      int right = array.length - 1;
13
      while (left < right) {
14
        int currentSum = array[i] + array[left] + array[right];
15
        if (currentSum == targetSum) {
16
          Integer[] newTriplet = {array[i], array[left], array[right]};
17
          triplets.add(newTriplet);
18
          left++;
19
          right--;
20
        } else if (currentSum < targetSum) {
21
          left++;
22
        } else if (currentSum > targetSum) {
23
          right--;
24
        }
25
      }
26
    }
27
    return triplets;
28
  }
29
}
30
​

```
Test Case 1
{"array": [12, 3, 1, 2, -6, 5, -8, 6], "targetSum": 0}
Test Case 2
{"array": [1, 2, 3], "targetSum": 6}
Test Case 3
{"array": [1, 2, 3], "targetSum": 7}
Test Case 4
{"array": [8, 10, -2, 49, 14], "targetSum": 57}
Test Case 5
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1], "targetSum": 0}
Test Case 6
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6], "targetSum": 0}
Test Case 7
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5], "targetSum": 0}
Test Case 8
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 18}
Test Case 9
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 32}
Test Case 10
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 33}
Test Case 11
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 5}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
Input(s)
{"array": [12, 3, 1, 2, -6, 5, -8, 6], "targetSum": 0}
Test Case 2 passed!
Our Code's Output
[[1, 2, 3]]
Input(s)
{"array": [1, 2, 3], "targetSum": 6}
Test Case 3 passed!
Our Code's Output
[]
Input(s)
{"array": [1, 2, 3], "targetSum": 7}
Test Case 4 passed!
Our Code's Output
[[-2, 10, 49]]
Input(s)
{"array": [8, 10, -2, 49, 14], "targetSum": 57}
Test Case 5 passed!
Our Code's Output
[[-8, 3, 5], [-6, 1, 5], [-1, 0, 1]]
Input(s)
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1], "targetSum": 0}
Test Case 6 passed!
Our Code's Output
[[-8, 2, 6], [-8, 3, 5], [-6, 0, 6], [-6, 1, 5], [-1, 0, 1]]
Input(s)
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6], "targetSum": 0}
Test Case 7 passed!
Our Code's Output
[
  [-8, 2, 6],
  [-8, 3, 5],
  [-6, 0, 6],
  [-6, 1, 5],
  [-5, -1, 6],
  [-5, 0, 5],
  [-5, 2, 3],
  [-1, 0, 1]
]
Input(s)
{"array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5], "targetSum": 0}
Test Case 8 passed!
Our Code's Output
[
  [1, 2, 15],
  [1, 8, 9],
  [2, 7, 9],
  [3, 6, 9],
  [3, 7, 8],
  [4, 5, 9],
  [4, 6, 8],
  [5, 6, 7]
]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 18}
Test Case 9 passed!
Our Code's Output
[[8, 9, 15]]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 32}
Test Case 10 passed!
Our Code's Output
[]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 33}
Test Case 11 passed!
Our Code's Output
[]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 5}

```
