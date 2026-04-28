# Two Number Sum

**Category:** Arrays

```
## Problem Statement

Two Number Sum
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should
return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty array.
You can assume that there will be at most one pair of numbers summing up to the target sum.
Sample Input
array = [3, 5, -4, 8, 11, 1, -1, 6]
targetSum = 10
Sample Output
[-1, 11] // the numbers could be in reverse order
Hints
Hint 1
Try using two for loops to sum all possible pairs of numbers in the input array. What are the time and space implications of this approach?
Hint 2
Realize that for every number X in the input array, you are essentially trying to nd a corresponding number Y such that X + Y = targetSum. With two variables in this equation known to you,
it shouldn't be hard to solve for Y.
Hint 3
Try storing every number in a hash table, solving the equation mentioned in Hint #2 for every number, and checking if the Y that you nd is stored in the hash table. What are the time and
space implications of this approach?
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3
import java.util.Arrays;
class Program {
// O(nlog(n)) | O(1) space
public static int[] twoNumberSum(int[] array, int targetSum) {
Arrays.sort(array);
int left = 0;
int right = array.length - 1;
while (left < right) {
int currentSum = array[left] + array[right];
if (currentSum == targetSum) {
return new int[] {array[left], array[right]};
} else if (currentSum < targetSum) {
left++;
} else if (currentSum > targetSum) {
right--;
}
}
return new int[0];
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 // O(n) time | O(n) space
7 public static int[] twoNumberSum(int[] array, int targetSum) {
8 Map<Integer, Boolean> nums = new HashMap<>();
9 for (int num : array) {
10 int potentialMatch = targetSum - num;
11 if (nums.containsKey(potentialMatch)) {
12 return new int[] {potentialMatch, num};
13 } else {
14 nums.put(num, true);
15 }
16 }
17 return new int[0];
18 }
19 }
20

### Solution 3

```
Solution 1 Solution 2 Solution 3
class Program {
// O(n^2) time | O(1) space
public static int[] twoNumberSum(int[] array, int targetSum) {
for (int i = 0; i < array.length - 1; i++) {
int firstNum = array[i];
for (int j = i + 1; j < array.length; j++) {
int secondNum = array[j];
if (firstNum + secondNum == targetSum) {
return new int[] {firstNum, secondNum};
}
}
}
return new int[0];
}
}

```
---

## Test Cases

```
Yay, your code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[11, -1]
Your Code's Output
[-1, 11]
Input(s)
{"array": [3, 5, -4, 8, 11, 1, -1, 6], "targetSum": 10}
Test Case 2 passed!
Our Code's Output
[4, 6]
Your Code's Output
[4, 6]
Input(s)
{"array": [4, 6], "targetSum": 10}
Test Case 3 passed!
Our Code's Output
[4, 1]
Your Code's Output
[1, 4]
Input(s)
{"array": [4, 6, 1], "targetSum": 5}
Test Case 4 passed!
Our Code's Output
[6, -3]
Your Code's Output
[-3, 6]
Input(s)
{"array": [4, 6, 1, -3], "targetSum": 3}
Test Case 5 passed!
Our Code's Output
[8, 9]
Your Code's Output
[8, 9]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9], "targetSum": 17}
Test Case 6 passed!
Our Code's Output
[3, 15]
Your Code's Output
[3, 15]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 18}
Test Case 7 passed!
Our Code's Output
[-5, 0]
Your Code's Output
[-5, 0]
Input(s)
{"array": [-7, -5, -3, -1, 0, 1, 3, 5, 7], "targetSum": -5}
Test Case 8 passed!
Our Code's Output
[210, -47]
Your Code's Output
[-47, 210]
Input(s)
{"array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 163}
Test Case 9 passed!
Our Code's Output
[]
Your Code's Output
[]
Input(s)
{"array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 164}
Test Case 10 passed!
Our Code's Output
[]
Your Code's Output
[]
Input(s)
{"array": [3, 5, -4, 8, 11, 1, -1, 6], "targetSum": 15}
```
