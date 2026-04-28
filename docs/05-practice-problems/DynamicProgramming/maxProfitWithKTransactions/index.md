# Max Profit With K Transactions

**Category:** Dynamic Programming

```
## Problem Statement

Max Prot With K Transactions
You're given an array of positive integers representing the prices of a single stock on various days (each index in the array represents a dierent day). You're also given an integer k , which
represents the number of transactions you're allowed to make. One transaction consists of buying the stock on a given day and selling it on another, later day.
Write a function that returns the maximum prot that you can make by buying and selling the stock, given k transactions.
Note that you can only hold one share of the stock at a time; in other words, you can't buy more than one share of the stock on any given day, and you can't buy a share of the stock if you're
still holding another share. Also, you don't need to use all k transactions that you're allowed.
Sample Input
prices = [5, 11, 3, 50, 60, 90]
k = 2
Sample Output
// Buy: 5, Sell: 11; Buy: 3, Sell: 90
Hints
Hint 1
Try building a two-dimensional array of the maximum prots you can make on each day with zero, one, two, etc., k transactions. Let columns represent days and rows represent the
number of transactions.
Hint 2
Build up the array mentioned in Hint #1 one row at a time. In other words, nd the maximum prots that you can make on each day with zero transactions rst, then with one
transaction, etc., until you reach k transactions. Find a formula that relates the maximum prot at any given point to previous prots. Once you nd that formula, identify certain values
that you repeatedly need and that you can temporarily store to optimize your algorithm.
Hint 3
Do you really need to store the entire two-dimensional array mentioned in Hint #1? Identify what stored values you actually use throughout the process of building the array and come
up with a way of storing only what you need and nothing more.
Optimal Space & Time Complexity
O(nk) time | O(n) space - where n is the number of prices and k is the number of transactions

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// O(nk) time | O(n) space
public static int maxProfitWithKTransactions(int[] prices, int k) {
if (prices.length == 0) {
return 0;
}
int[] evenProfits = new int[prices.length];
int[] oddProfits = new int[prices.length];
for (int i = 0; i < prices.length; i++) {
evenProfits[i] = 0;
oddProfits[i] = 0;
}
for (int t = 1; t < k + 1; t++) {
int maxThusFar = Integer.MIN_VALUE;
int[] currentProfits = new int[prices.length];
int[] previousProfits = new int[prices.length];
if (t % 2 == 1) {
currentProfits = oddProfits;
previousProfits = evenProfits;
} else {
currentProfits = evenProfits;
previousProfits = oddProfits;
}
for (int d = 1; d < prices.length; d++) {
maxThusFar = Math.max(maxThusFar, previousProfits[d - 1] - prices[d - 1]);
currentProfits[d] = Math.max(currentProfits[d - 1], maxThusFar + prices[d]);
}
}
return k % 2 == 0 ? evenProfits[prices.length - 1] : oddProfits[prices.length - 1];
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(nk) time | O(nk) space
5 public static int maxProfitWithKTransactions(int[] prices, int k) {
6 if (prices.length == 0) {
7 return 0;
8 }
9 int[][] profits = new int[k + 1][prices.length];
10 for (int t = 1; t < k + 1; t++) {
11 int maxThusFar = Integer.MIN_VALUE;
12 for (int d = 1; d < prices.length; d++) {
13 maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]);
14 profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
15 }
16 }
17 return profits[k][prices.length - 1];
18 }
19 }
20
