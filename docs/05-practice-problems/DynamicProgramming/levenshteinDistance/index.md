# Levenshtein Distance

**Category:** Dynamic Programming

```
## Problem Statement

 Test
Levenshtein Distance
Write a function that takes in two strings and returns the minimum number of edit operations that need to be performed on the rst string to obtain the second string. Tes
There are three edit operations: insertion of a character, deletion of a character, and substitution of a character for another.
Sample Input Tes
str1 = "abc"
str2 = "yabd"
Tes
Sample Output
// insert "y"; substitute "c" for "d"
Tes
Hints
Hint 1
Tes
Try building a two-dimensional array of the minimum numbers of edits for pairs of substrings of the input strings. Let the rows of the array represent substrings of the second
input string str2. Let the rst row represent the empty string. Let each row i thereafter represent the substrings of str2 from 0 to i, with i excluded. Let the columns similarly
Tes
represent the rst input string str1.
Hint 2 Tes
odCeust
Build up the array mentioned in Hint #1 one row at a time. In other words, nd the minimum numbers of edits between all the substrings of str1 represented by the columns and
the empty string represented by the rst row, then between all the substrings of str1 represented by the columns and the rst letter of str2 represented by the second row, etc.,
until you compare both full strings. Find a formula that relates the minimum number of edits at any given point to previous numbers.
Hint 3
At any position (i, j) in the two-dimensional array, if str2[i] is equal to str1[j], then the edit distance at position (i, j) is equal to the one at position (i - 1, j - 1), since adding str2[i] and
str1[j] to the substrings represented at position (i - 1, j - 1) does not require any additional edit operation. If str2[i] is not equal to str1[j] however, then the edit distance at position
(i, j) is equal to 1 + the minimum of the edit distances at positions (i - 1, j) and (i, j - 1). Why is that the case?
Hint 4
Do you really need to store the entire two-dimensional array mentioned in Hint #1? Identify what stored values you actually use throughout the process of building the array and
come up with a way of storing only what you need and nothing more.
Optimal Space & Time Complexity
O(nm) time | O(min(n, m)) space - where n and m are the lengths of the two input strings

```
---

## Approach & Solution

### Solution 1

 Test
Solution 1 Solution 2
Tes
2
3 class Program {
4 // O(nm) time | O(min(n, m)) space
5 public static int levenshteinDistance(String str1, String str2) { Tes
6 String small = str1.length() < str2.length() ? str1 : str2;
7 String big = str1.length() >= str2.length() ? str1 : str2;
8 int[] evenEdits = new int[small.length() + 1];
9 int[] oddEdits = new int[small.length() + 1];
10 for (int j = 0; j < small.length() + 1; j++) { Tes
11 evenEdits[j] = j;
12 }
13
14 int[] currentEdits;
15 int[] previousEdits; Tes
16 for (int i = 1; i < big.length() + 1; i++) {
17 if (i % 2 == 1) {
18 currentEdits = oddEdits;
19 previousEdits = evenEdits;
20 } else {
Tes
21 currentEdits = evenEdits;
22 previousEdits = oddEdits;
23 }
24 currentEdits[0] = i;
25 for (int j = 1; j < small.length() + 1; j++) {
26 if (big.charAt(i - 1) == small.charAt(j - 1)) { Tes
27 currentEdits[j] = previousEdits[j - 1];
28 } else {
29 currentEdits[j] =
30 1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
31 } Tes
32 }
33 }
34 return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
35 }
36 }
Tes
37
odCeust

### Solution 2

 Test
Solution 1 Solution 2
Tes
2
3 class Program {
4 // O(nm) time | O(nm) space
5 public static int levenshteinDistance(String str1, String str2) { Tes
6 int[][] edits = new int[str2.length() + 1][str1.length() + 1];
7 for (int i = 0; i < str2.length() + 1; i++) {
8 for (int j = 0; j < str1.length() + 1; j++) {
9 edits[i][j] = j;
10 } Tes
11 edits[i][0] = i;
12 }
13 for (int i = 1; i < str2.length() + 1; i++) {
14 for (int j = 1; j < str1.length() + 1; j++) {
15 if (str2.charAt(i - 1) == str1.charAt(j - 1)) { Tes
16 edits[i][j] = edits[i - 1][j - 1];
17 } else {
18 edits[i][j] =
19 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
20 }
Tes
21 }
22 }
23 return edits[str2.length()][str1.length()];
24 }
25 }
26 Tes
Tes
Tes
odCeust

```
---

## Test Cases

```
▲

```
Test Case 1
{"str1": "abc", "str2": "yabd"}
Test Case 2
{"str1": "", "str2": ""}
Test Case 3
{"str1": "", "str2": "abc"}
Test Case 4
{"str1": "abc", "str2": "abc"}
Test Case 5
{"str1": "abc", "str2": "abx"}
Test Case 6
{"str1": "abc", "str2": "abcx"}
Test Case 7
{"str1": "abc", "str2": "yabcx"}
Test Case 8
{"str1": "", "str2": "algozexpert"}
Test Case 9
{"str1": "abcdefghij", "str2": "1234567890"}
Test Case 10
{"str1": "abcdefghij", "str2": "a234567890"}
Test Case 11
{"str1": "biting", "str2": "mitten"}
Test Case 12
{"str1": "cereal", "str2": "saturday"}
Test Case 13
{"str1": "cereal", "str2": "saturdzz"}
Test Case 14
{"str1": "abbbbbbbbb", "str2": "bbbbbbbbba"}
Test Case 15
{"str1": "xabc", "str2": "abcx"}

