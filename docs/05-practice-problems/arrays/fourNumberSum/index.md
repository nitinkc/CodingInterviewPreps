# Four Number Sum

**Category:** Arrays

```
## Problem Statement

Four Number Sum
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should nd all quadruplets in the array that
sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.
If no four numbers sum up to the target sum, the function should return an empty array.
Sample Input
array = [7, 6, 4, -1, 1, 2]
targetSum = 16
Sample Output
[[7, 6, 4, -1], [7, 6, 1, 2]] // the quadruplets could be ordered differently
Hints
Hint 1
Using four for loops to calculate the sums of all possible quadruplets in the array would generate an algorithm that runs in O(n^4) time, where n is the length of
the input array. Can you come up with something faster using fewer for loops?
Hint 2
You can calculate the sums of every pair of numbers in the array in O(n^2) time using just two for loops. Then, assuming that you've stored all of these sums in a
hash table, you can fairly easily nd which two sums can be paired to add up to the target sum: the numbers summing up to these two sums constitute candidates
for valid quadruplets; you just have to make sure that no number was used to generate both of the two sums.
Hint 3
You can do everything described in Hint #2 with just two sibling for loops nested inside a third for loop. Your goal is to create a hash table mapping the sums of
every pair of numbers in the array to an array of arrays, with each subarray representing the indices of each pair summing up to that number. Loop through the
input array with a simple for loop. Inside this loop, loop through the input array again, starting at the index of the rst loop. At each iteration, calculate the
dierence between the target sum and the sum of the two numbers represented by the indices of the for loops. If that dierence is in the hash table that you're
building, then valid quadruplets can be formed by combining the current pair of numbers with each pair stored in the hash table at the dierence just calculated.
Following this nested for loop, loop through the array again, this time starting at index zero all the way to the index of the rst for loop. At each iteration, calculate
the sum of the two numbers represented by the indices of the for loops and add it to the hash table if it isn't already there; then add the pair of indices to the array
that the sum in the hash table maps to.
Optimal Space & Time Complexity
Average: O(n^2) time | O(n^2) space - where n is the length of the input array
Worst: O(n^3) time | O(n^2) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
// Average: O(n^2) time | O(n^2) space
// Worst: O(n^3) time | O(n^2) space
class Program {
public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
List<Integer[]> quadruplets = new ArrayList<Integer[]>();
for (int i = 1; i < array.length - 1; i++) {
for (int j = i + 1; j < array.length; j++) {
int currentSum = array[i] + array[j];
int difference = targetSum - currentSum;
if (allPairSums.containsKey(difference)) {
for (Integer[] pair : allPairSums.get(difference)) {
Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
quadruplets.add(newQuadruplet);
}
}
}
for (int k = 0; k < i; k++) {
int currentSum = array[i] + array[k];
Integer[] pair = {array[k], array[i]};
if (!allPairSums.containsKey(currentSum)) {
List<Integer[]> pairGroup = new ArrayList<Integer[]>();
pairGroup.add(pair);
allPairSums.put(currentSum, pairGroup);
} else {
allPairSums.get(currentSum).add(pair);
}
}
}
return quadruplets;
}
}

```
---

## Test Cases

```
​
import java.util.*;
​
// Average: O(n^2) time | O(n^2) space
// Worst: O(n^3) time | O(n^2) space
class Program {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
    List<Integer[]> quadruplets = new ArrayList<Integer[]>();
    for (int i = 1; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int currentSum = array[i] + array[j];
        int difference = targetSum - currentSum;
        if (allPairSums.containsKey(difference)) {
          for (Integer[] pair : allPairSums.get(difference)) {
            Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
            quadruplets.add(newQuadruplet);
          }
        }
      }
      for (int k = 0; k < i; k++) {
        int currentSum = array[i] + array[k];
        Integer[] pair = {array[k], array[i]};
        if (!allPairSums.containsKey(currentSum)) {
          List<Integer[]> pairGroup = new ArrayList<Integer[]>();
          pairGroup.add(pair);
          allPairSums.put(currentSum, pairGroup);
        } else {
          allPairSums.get(currentSum).add(pair);
        }
      }
    }
    return quadruplets;
  }
}
​

```
Test Case 1
{"array": [7, 6, 4, -1, 1, 2], "targetSum": 16}
Test Case 2
{"array": [1, 2, 3, 4, 5, 6, 7], "targetSum": 10}
Test Case 3
{"array": [5, -5, -2, 2, 3, -3], "targetSum": 0}
Test Case 4
{"array": [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9], "targetSum": 4}
Test Case 5
{"array": [-1, 22, 18, 4, 7, 11, 2, -5, -3], "targetSum": 30}
Test Case 6
{"array": [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5], "targetSum": 20}
Test Case 7
{"array": [1, 2, 3, 4, 5], "targetSum": 100}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[[7, 6, 4, -1], [7, 6, 1, 2]]
Input(s)
{"array": [7, 6, 4, -1, 1, 2], "targetSum": 16}
Test Case 2 passed!
Our Code's Output
[[1, 2, 3, 4]]
Input(s)
{"array": [1, 2, 3, 4, 5, 6, 7], "targetSum": 10}
Test Case 3 passed!
Our Code's Output
[[5, -5, -2, 2], [5, -5, 3, -3], [-2, 2, 3, -3]]
Input(s)
{"array": [5, -5, -2, 2, 3, -3], "targetSum": 0}
Test Case 4 passed!
Our Code's Output
[[-2, -1, 1, 6], [-2, 1, 2, 3], [-2, -1, 2, 5], [-2, -1, 3, 4]]
Input(s)
{"array": [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9], "targetSum": 4}
Test Case 5 passed!
Our Code's Output
[
  [-1, 22, 7, 2],
  [22, 4, 7, -3],
  [-1, 18, 11, 2],
  [18, 4, 11, -3],
  [22, 11, 2, -5]
]
Input(s)
{"array": [-1, 22, 18, 4, 7, 11, 2, -5, -3], "targetSum": 30}
Test Case 6 passed!
Our Code's Output
[
  [-5, 2, 15, 8],
  [-3, 2, -7, 28],
  [-10, -3, 28, 5],
  [-10, 28, -6, 8],
  [-7, 28, -6, 5],
  [-5, 2, 12, 11],
  [-5, 12, 8, 5]
]
Input(s)
{"array": [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5], "targetSum": 20}
Test Case 7 passed!
Our Code's Output
[]
Input(s)
{"array": [1, 2, 3, 4, 5], "targetSum": 100}

```
