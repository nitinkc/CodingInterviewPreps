# Longest Palindromic Substring

**Category:** Strings

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

Our Solution(s) Run Code Tests
Solution 1 Solution 2
Test Case 1
1 {"string": "abaxyzzyxf"}
2
3 class Program {
4 // O(n^2) time | O(1) space
Test Case 2
5 public static String longestPalindromicSubstring(String str) {
6 int[] currentLongest = {0, 1};
1 {"string": "a"}
7 for (int i = 1; i < str.length(); i++) {
8 int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
9 int[] even = getLongestPalindromeFrom(str, i - 1, i);
Test Case 3
10 int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
11 currentLongest =
1 {"string": "it's highnoon"}
12 currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
13 ? currentLongest
14 : longest;
Test Case 4
15 }
16 return str.substring(currentLongest[0], currentLongest[1]);
1 {"string": "noon high it is"}
17 }
18
19 public static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
20 while (leftIdx >= 0 && rightIdx < str.length()) { Test Case 5
21 if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
22 break; 1 {"string": "abccbait's highno
23 }
24 leftIdx--;
25 rightIdx++; Test Case 6
26 }
27 return new int[] {leftIdx + 1, rightIdx}; 1 {"string": "abcdefgfedcbazzzz
28 }
29 }
30
Test Case 7
1 {"string": "abcdefgfedcba"}
Test Case 8
Custom Output Submit Code
Run or submit code
when you're ready.

### Solution 2

Our Solution(s) Run Code Tests
Solution 1 Solution 2
Test Case 1
1 {"string": "abaxyzzyxf"}
2
3 class Program {
4 // O(n^3) time | O(1) space
Test Case 2
5 public static String longestPalindromicSubstring(String str) {
6 String longest = "";
1 {"string": "a"}
7 for (int i = 0; i < str.length(); i++) {
8 for (int j = i; j < str.length(); j++) {
9 String substring = str.substring(i, j + 1);
Test Case 3
10 if (substring.length() > longest.length() && isPalindrome(substring)) {
11 longest = substring;
1 {"string": "it's highnoon"}
12 }
13 }
14 }
Test Case 4
15 return longest;
16 }
1 {"string": "noon high it is"}
17
18 public static boolean isPalindrome(String str) {
19 int leftIdx = 0;
20 int rightIdx = str.length() - 1; Test Case 5
21 while (leftIdx < rightIdx) {
22 if (str.charAt(leftIdx) != str.charAt(rightIdx)) { 1 {"string": "abccbait's highno
23 return false;
24 }
25 leftIdx++; Test Case 6
26 rightIdx--;
27 } 1 {"string": "abcdefgfedcbazzzz
28 return true;
29 }
30 }
Test Case 7
31
1 {"string": "abcdefgfedcba"}
Test Case 8
Custom Output Submit Code
Run or submit code
when you're ready.

```
---

## Test Cases

```
Test Case 1
{"string": "abaxyzzyxf"}
Test Case 2
{"string": "a"}
Test Case 3
{"string": "it's highnoon"}
Test Case 4
{"string": "noon high it is"}
Test Case 5
{"string": "abccbait's highnoon"}
Test Case 6
{"string": "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz"}
Test Case 7
{"string": "abcdefgfedcba"}
Test Case 8
{"string": "abcdefghfedcbaa"}
Test Case 9
{"string": "abcdefggfedcba"}
Test Case 10
{"string": "zzzzzzz2345abbbba5432zzbbababa"}
Test Case 11
{"string": "z234a5abbbba54a32z"}
Test Case 12
{"string": "z234a5abbba54a32z"}

