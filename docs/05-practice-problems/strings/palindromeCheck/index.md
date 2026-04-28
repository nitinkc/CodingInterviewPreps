# Palindrome Check

**Category:** Strings

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3 Solution 4
class Program {
// O(n) time | O(1) space
public static boolean isPalindrome(String str) {
int leftIdx = 0;
int rightIdx = str.length() - 1;
while (leftIdx < rightIdx) {
if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
return false;
}
leftIdx++;
rightIdx--;
}
return true;
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3 Solution 4
2
3 class Program {
4 // O(n) time | O(n) space
5 public static boolean isPalindrome(String str) {
6 return isPalindrome(str, 0);
7 }
8
9 public static boolean isPalindrome(String str, int i) {
10 int j = str.length() - 1 - i;
11 return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1);
12 }
13 }
14

### Solution 3

```
Solution 1 Solution 2 Solution 3 Solution 4
class Program {
// O(n) time | O(n) space
public static boolean isPalindrome(String str) {
StringBuilder reversedString = new StringBuilder();
for (int i = str.length() - 1; i >= 0; i--) {
reversedString.append(str.charAt(i));
}
return str.equals(reversedString.toString());
}
}

### Solution 4

```
Solution 1 Solution 2 Solution 3 Solution 4
2
3 class Program {
4 // O(n^2) time | O(n) space
5 public static boolean isPalindrome(String str) {
6 String reversedString = "";
7 for (int i = str.length() - 1; i >= 0; i--) {
8 reversedString += str.charAt(i);
9 }
10 return str.equals(reversedString);
11 }
12 }
13

```
---

## Test Cases

```
Test Case 1
{"string": "abcdcba"}
Test Case 2
{"string": "a"}
Test Case 3
{"string": "ab"}
Test Case 4
{"string": "aba"}
Test Case 5
{"string": "abb"}
Test Case 6
{"string": "abba"}
Test Case 7
{"string": "abcdefghhgfedcba"}
Test Case 8
{"string": "abcdefghihgfedcba"}
Test Case 9
{"string": "abcdefghihgfeddcba"}

