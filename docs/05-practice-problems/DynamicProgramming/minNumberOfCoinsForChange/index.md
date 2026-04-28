# Min Number Of Coins For Change

**Category:** Dynamic Programming

```
## Problem Statement

Min Number Of Coins For Change
Given an array of positive integers representing coin denominations and a single non-negative integer n representing a target amount of money, write a function that returns the smallest
number of coins needed to make change for that target amount using the given coin denominations.
If it's impossible to make change for the target amount, return -1 .
Note that an unlimited amount of coins is at your disposal.
Sample Input
n = 7
denoms = [1, 5, 10]
Sample Output
// 2x1 + 1x5
Hints
Hint 1
Try building an array of the minimum number of coins needed to make change for all amounts between 0 and n inclusive. Note that no coins are needed to make change for 0: in order
to make change for 0, you do not need to use any coins.
Hint 2
Build up the array mentioned in Hint #1 one coin denomination at a time. In other words, nd the minimum number of coins needed to make change for all amounts between 0 and n
with only one denomination, then with two, etc., until you use all denominations.
Optimal Space & Time Complexity
O(nd) time | O(n) space - where n is the target amount and d is the number of coin denominations

```
---

## Approach & Solution

### Solution 1

```java
import java.util.Arrays;
class Program {
// O(nd) time | O(n) space
public static int minNumberOfCoinsForChange(int n, int[] denoms) {
int[] numOfCoins = new int[n + 1];
Arrays.fill(numOfCoins, Integer.MAX_VALUE);
numOfCoins[0] = 0;
int toCompare = 0;
for (int denom : denoms) {
for (int amount = 0; amount < numOfCoins.length; amount++) {
if (denom <= amount) {
if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
toCompare = numOfCoins[amount - denom];
} else {
toCompare = numOfCoins[amount - denom] + 1;
}
numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
}
}
}
return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
}
}

```
---

## Test Cases

```
Video Solution
Video Solution

```
Test Case 1
{"n": 7, "denoms": [1, 5, 10]}
Test Case 2
{"n": 0, "denoms": [1, 2, 3]}
Test Case 3
{"n": 3, "denoms": [2, 1]}
Test Case 4
{"n": 4, "denoms": [1, 5, 10]}
Test Case 5
{"n": 10, "denoms": [1, 5, 10]}
Test Case 6
{"n": 11, "denoms": [1, 5, 10]}
Test Case 7
{"n": 24, "denoms": [1, 5, 10]}
Test Case 8
{"n": 25, "denoms": [1, 5, 10]}
Test Case 9
{"n": 7, "denoms": [2, 4]}
Test Case 10
{"n": 7, "denoms": [3, 7]}
Test Case 11
{"n": 9, "denoms": [3, 5]}
Test Case 12
{"n": 9, "denoms": [3, 4, 5]}
Test Case 13
{"n": 135, "denoms": [39, 45, 130, 40, 4, 1]}
Test Case 14
{"n": 135, "denoms": [39, 45, 130, 40, 4, 1, 60, 75]}

