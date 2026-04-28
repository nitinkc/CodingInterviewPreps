# Longest Common Subsequence

**Category:** Dynamic Programming

```
## Problem Statement

Longest Common Subsequence
Write a function that takes in two strings and returns their longest common subsequence.
A subsequence of a string is a set of characters that aren't necessarily adjacent in the string but that are in the same order as they appear in the string. For instance, the characters
["a", "c", "d"] form a subsequence of the string "abcd" , and so do the characters ["b", "d"] . Note that a single character in a string and the string itself are both valid
subsequences of the string.
You can assume that there will only be one longest common subsequence.
Sample Input
str1 = "ZXVVYZW"
str2 = "XKYKZPW"
Sample Output
["X", "Y", "Z", "W"]
Hints
Hint 1
Try building a two-dimensional array of the longest common subsequences of substring pairs of the input strings. Let the rows of the array represent substrings of the second input
string str2. Let the rst row represent the empty string. Let each row i thereafter represent the substrings of str2 from 0 to i, with i excluded. Let the columns similarly represent the rst
input string str1.
Hint 2
Build up the array mentioned in Hint #1 one row at a time. In other words, nd the longest common subsequences for all the substrings of str1 represented by the columns and the
empty string represented by the rst row, then for all the substrings of str1 represented by the columns and the rst letter of str2 represented by the second row, etc., until you compare
both full strings. Find a formula that relates the longest common subsequence at any given point to previous subsequences.
Hint 3
Do you really need to build and store subsequences at each point in the two-dimensional array mentioned in Hint #1? Try storing booleans to determine whether or not a letter at a
given point in the two-dimensional array is part of the longest common subsequence as well as pointers to determine what should come before this letter in the nal subsequence. Use
these pointers to backtrack your way through the array and to build up the longest common subsequence at the end of your algorithm.
Optimal Space & Time Complexity
O(nm) time | O(nm) space - where n and m are the lengths of the two input strings

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3 Solution 4
import java.util.*;
class Program {
// O(nm) time | O(nm) space
public static List<Character> longestCommonSubsequence(String str1, String str2) {
int[][][] lcs = new int[str2.length() + 1][str1.length() + 1][];
for (int i = 0; i < str2.length() + 1; i++) {
for (int j = 0; j < str1.length() + 1; j++) {
lcs[i][j] = new int[] {0, 0, 0, 0};
}
}
for (int i = 1; i < str2.length() + 1; i++) {
for (int j = 1; j < str1.length() + 1; j++) {
if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
int[] newEntry = {(int) str2.charAt(i - 1), lcs[i - 1][j - 1][1] + 1, i - 1, j - 1};
lcs[i][j] = newEntry;
} else {
if (lcs[i - 1][j][1] > lcs[i][j - 1][1]) {
int[] newEntry = {-1, lcs[i - 1][j][1], i - 1, j};
lcs[i][j] = newEntry;
} else {
int[] newEntry = {-1, lcs[i][j - 1][1], i, j - 1};
lcs[i][j] = newEntry;
}
}
}
}
return buildSequence(lcs);
}
public static List<Character> buildSequence(int[][][] lcs) {
List<Character> sequence = new ArrayList<Character>();
int i = lcs.length - 1;
int j = lcs[0].length - 1;
while (i != 0 && j != 0) {
int[] currentEntry = lcs[i][j];
if (currentEntry[0] != -1) {
sequence.add(0, (char) currentEntry[0]);
}
i = currentEntry[2];
j = currentEntry[3];
}
return sequence;

### Solution 2

```
Solution 1 Solution 2 Solution 3 Solution 4
2
3 import java.util.*;
4
5 class Program {
6 // O(nm) time | O(nm) space
7 public static List<Character> longestCommonSubsequence(String str1, String str2) {
8 int[][][] lcs = new int[str2.length() + 1][str1.length() + 1][];
9 for (int i = 0; i < str2.length() + 1; i++) {
10 for (int j = 0; j < str1.length() + 1; j++) {
11 lcs[i][j] = new int[] {0, 0, 0, 0};
12 }
13 }
14 for (int i = 1; i < str2.length() + 1; i++) {
15 for (int j = 1; j < str1.length() + 1; j++) {
16 if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
17 int[] newEntry = {(int) str2.charAt(i - 1), lcs[i - 1][j - 1][1] + 1, i - 1, j - 1};
18 lcs[i][j] = newEntry;
19 } else {
20 if (lcs[i - 1][j][1] > lcs[i][j - 1][1]) {
21 int[] newEntry = {-1, lcs[i - 1][j][1], i - 1, j};
22 lcs[i][j] = newEntry;
23 } else {
24 int[] newEntry = {-1, lcs[i][j - 1][1], i, j - 1};
25 lcs[i][j] = newEntry;
26 }
27 }
28 }
29 }
30 return buildSequence(lcs);
31 }
32
33 public static List<Character> buildSequence(int[][][] lcs) {
34 List<Character> sequence = new ArrayList<Character>();
35 int i = lcs.length - 1;
36 int j = lcs[0].length - 1;
37 while (i != 0 && j != 0) {
38 int[] currentEntry = lcs[i][j];
39 if (currentEntry[0] != -1) {
40 sequence.add(0, (char) currentEntry[0]);
41 }
42 i = currentEntry[2];
43 j = currentEntry[3];
44 }
45 return sequence;
46 }
47 }
48

### Solution 3

```
Solution 1 Solution 2 Solution 3 Solution 4
import java.util.*;
class Program {
// O(nm) time | O(nm) space
public static List<Character> longestCommonSubsequence(String str1, String str2) {
int[][] lengths = new int[str2.length() + 1][str1.length() + 1];
for (int i = 1; i < str2.length() + 1; i++) {
for (int j = 1; j < str1.length() + 1; j++) {
if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
lengths[i][j] = lengths[i - 1][j - 1] + 1;
} else {
lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
}
}
}
return buildSequence(lengths, str1);
}
public static List<Character> buildSequence(int[][] lengths, String str) {
List<Character> sequence = new ArrayList<Character>();
int i = lengths.length - 1;
int j = lengths[0].length - 1;
while (i != 0 && j != 0) {
if (lengths[i][j] == lengths[i - 1][j]) {
i--;
} else if (lengths[i][j] == lengths[i][j - 1]) {
j--;
} else {
sequence.add(0, str.charAt(j - 1));
i--;
j--;
}
}
return sequence;
}
}

### Solution 4

```
Solution 1 Solution 2 Solution 3 Solution 4
2
3 import java.util.*;
4
5 class Program {
6 // O(nm*min(n, m)) time | O((min(n, m))^2) space
7 public static List<Character> longestCommonSubsequence(String str1, String str2) {
8 String small = str1.length() < str2.length() ? str1 : str2;
9 String big = str1.length() >= str2.length() ? str1 : str2;
10 List<List<Character>> evenLcs = new ArrayList<List<Character>>();
11 List<List<Character>> oddLcs = new ArrayList<List<Character>>();
12 for (int i = 0; i < small.length() + 1; i++) {
13 evenLcs.add(new ArrayList<Character>());
14 }
15 for (int i = 0; i < small.length() + 1; i++) {
16 oddLcs.add(new ArrayList<Character>());
17 }
18 for (int i = 1; i < big.length() + 1; i++) {
19 List<List<Character>> currentLcs;
20 List<List<Character>> previousLcs;
21 if (i % 2 == 1) {
22 currentLcs = oddLcs;
23 previousLcs = evenLcs;
24 } else {
25 currentLcs = evenLcs;
26 previousLcs = oddLcs;
27 }
28 for (int j = 1; j < small.length() + 1; j++) {
29 if (big.charAt(i - 1) == small.charAt(j - 1)) {
30 List<Character> copy = new ArrayList<Character>(previousLcs.get(j - 1));
31 currentLcs.set(j, copy);
32 currentLcs.get(j).add(big.charAt(i - 1));
33 } else {
34 if (previousLcs.get(j).size() > currentLcs.get(j - 1).size()) {
35 currentLcs.set(j, previousLcs.get(j));
36 } else {
37 currentLcs.set(j, currentLcs.get(j - 1));
38 }
39 }
40 }
41 }
42 return big.length() % 2 == 0 ? evenLcs.get(small.length()) : oddLcs.get(small.length());
43 }
44 }
45

### Solution 5

```
Solution 1 Solution 2 Solution 3 Solution 4
import java.util.*;
class Program {
// O(nm*min(n, m)) time | O(nm*min(n, m)) space
public static List<Character> longestCommonSubsequence(String str1, String str2) {
List<List<List<Character>>> lcs = new ArrayList<List<List<Character>>>();
for (int i = 0; i < str2.length() + 1; i++) {
lcs.add(new ArrayList<List<Character>>());
for (int j = 0; j < str1.length() + 1; j++) {
lcs.get(i).add(new ArrayList<Character>());
}
}
for (int i = 1; i < str2.length() + 1; i++) {
for (int j = 1; j < str1.length() + 1; j++) {
if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
List<Character> copy = new ArrayList<Character>(lcs.get(i - 1).get(j - 1));
lcs.get(i).set(j, copy);
lcs.get(i).get(j).add(str2.charAt(i - 1));
} else {
if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size()) {
lcs.get(i).set(j, lcs.get(i - 1).get(j));
} else {
lcs.get(i).set(j, lcs.get(i).get(j - 1));
}
}
}
}
return lcs.get(str2.length()).get(str1.length());
}
}

```
---

## Test Cases

```
Test Case 1
{"str1": "ZXVVYZW", "str2": "XKYKZPW"}
Test Case 2
{"str1": "", "str2": ""}
Test Case 3
{"str1": "", "str2": "ABCDEFG"}
Test Case 4
{"str1": "ABCDEFG", "str2": ""}
Test Case 5
{"str1": "ABCDEFG", "str2": "ABCDEFG"}
Test Case 6
{"str1": "ABCDEFG", "str2": "APPLES"}
Test Case 7
{"str1": "clement", "str2": "antoine"}
Test Case 8
{
  "str1": "8111111111111111142",
  "str2": "222222222822222222222222222222433333333332"
}
Test Case 9
{
  "str1": "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
  "str2": "CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAG"
}
Test Case 10
{
  "str1": "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
  "str2": "CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAGTUV"
}

