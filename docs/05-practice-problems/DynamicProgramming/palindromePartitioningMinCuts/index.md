# Palindrome Partitioning Min Cuts

**Category:** Dynamic Programming

```
## Problem Statement

Palindrome Partitioning Min Cuts
Given a non-empty string, write a function that returns the minimum number of cuts needed to perform on the string such that each remaining substring is a palindrome.
A palindrome is dened as a string that's written the same forward as backward. Note that single-character strings are palindromes.
Sample Input
string = "noonabbad"
Sample Output
// noon | abba | d"
Hints
Hint 1
Try building a two-dimensional array of the palindromicities of all substrings of the input string. Let the value stored at row i and at column j represent the palindromicity of the substring
starting at index i and ending at index j.
Hint 2
Checking for palindromicity is typically an O(n) time operation. Can you eliminate this step and build the same two-dimensional array mentioned in Hint #1 a dierent way? Realize that
the substring whose starting and ending indices are (i, j) is only a palindrome if string[i] is equal to string[j] and if the substring denoted by (i + 1, j - 1) is also a palindrome.
Hint 3
Build a one-dimensional array of the same length as the input string. At each index i in this array compute and store the minimum number of cuts needed for the substring whose
starting and ending indices are (0, i). Use previously calculated values as well as the two-dimensional array mentioned in Hint #1 to nd each value in this array.
Optimal Space & Time Complexity
O(n^2) time | O(n^2) space - where n is the length of the input string

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.Arrays;
class Program {
// O(n^2) time | O(n^2) space
public static int palindromePartitioningMinCuts(String str) {
boolean[][] palindromes = new boolean[str.length()][str.length()];
for (int i = 0; i < str.length(); i++) {
for (int j = 0; j < str.length(); j++) {
if (i == j) {
palindromes[i][j] = true;
} else {
palindromes[i][j] = false;
}
}
}
for (int length = 2; length < str.length() + 1; length++) {
for (int i = 0; i < str.length() - length + 1; i++) {
int j = i + length - 1;
if (length == 2) {
palindromes[i][j] = (str.charAt(i) == str.charAt(j));
} else {
palindromes[i][j] = (str.charAt(i) == str.charAt(j) && palindromes[i + 1][j - 1]);
}
}
}
int[] cuts = new int[str.length()];
Arrays.fill(cuts, Integer.MAX_VALUE);
for (int i = 0; i < str.length(); i++) {
if (palindromes[0][i]) {
cuts[i] = 0;
} else {
cuts[i] = cuts[i - 1] + 1;
for (int j = 1; j < i; j++) {
if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
cuts[i] = cuts[j - 1] + 1;
}
}
}
}
return cuts[str.length() - 1];
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.Arrays;
4
5 class Program {
6 // O(n^3) time | O(n^2) space
7 public static int palindromePartitioningMinCuts(String str) {
8 boolean[][] palindromes = new boolean[str.length()][str.length()];
9 for (int i = 0; i < str.length(); i++) {
10 for (int j = i; j < str.length(); j++) {
11 palindromes[i][j] = isPalindrome(str.substring(i, j + 1));
12 }
13 }
14 int[] cuts = new int[str.length()];
15 Arrays.fill(cuts, Integer.MAX_VALUE);
16 for (int i = 0; i < str.length(); i++) {
17 if (palindromes[0][i]) {
18 cuts[i] = 0;
19 } else {
20 cuts[i] = cuts[i - 1] + 1;
21 for (int j = 1; j < i; j++) {
22 if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
23 cuts[i] = cuts[j - 1] + 1;
24 }
25 }
26 }
27 }
28 return cuts[str.length() - 1];
29 }
30
31 public static boolean isPalindrome(String str) {
32 int leftIdx = 0;
33 int rightIdx = str.length() - 1;
34 while (leftIdx < rightIdx) {
35 if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
36 return false;
37 }
38 leftIdx++;
39 rightIdx--;
40 }
41 return true;
42 }
43 }
44

```
---

## Test Cases

```
Test Case 1
{"string": "noonabbad"}
Test Case 2
{"string": "a"}
Test Case 3
{"string": "abba"}
Test Case 4
{"string": "abbba"}
Test Case 5
{"string": "abb"}
Test Case 6
{"string": "abbb"}
Test Case 7
{"string": "abcbm"}
Test Case 8
{"string": "ababbbabbababa"}
Test Case 9
{"string": "abbbacecffgbgffab"}
Test Case 10
{"string": "abcdefghijklmonpqrstuvwxyz"}
Test Case 11
{"string": "abcdefghijklmracecaronpqrstuvwxyz"}

