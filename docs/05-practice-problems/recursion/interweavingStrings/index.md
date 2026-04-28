# Interweaving Strings

**Category:** Recursion

```
## Problem Statement

Interweaving Strings
Write a function that takes in three strings and returns a boolean representing whether the third string can be formed by interweaving the rst two strings.
To interweave strings means to merge them by alternating their letters without any specic pattern. For instance, the strings "abc" and "123" can be interwoven as "a1b2c3" , as
"abc123" , and as "ab1c23" (this list is nonexhaustive).
Sample Input
one = ""
two = "your-dream-job"
three = "your-algodream-expertjob"
Sample Output
true
Hints
Hint 1
Try traversing the three strings with three dierent pointers to solve this problem.
Hint 2
Declare three variables (i, j, and k, for instance) pointing to indices in the three strings, respectively, and starting at 0. At any given combination of indices, if neither the character at i in
the rst string nor the character at j in the second string is equal to the character at k in the third string, then the rst two strings can't interweave to form the third one (at least not in
whatever way led to the values of i, j, and k in question).
Hint 3
If at any given combination of the indices i, j, and k mentioned in Hint #2, the character at i in the rst string or the character at j in the second string is equal to the character at k in the
third string, then you can potentially interweave the rst two strings to get the third one. In such a case, try incrementing the two relevant indices (i and k or j and k) and repeating this
process until you conrm whether or not the rst two strings can be interwoven to form the third one. Try using recursion to implement this algorithm.
Hint 4
By following Hint #3, you'll perform, in some cases, many computations multiple times. How can you use caching to improve the time complexity of this algorithm?
Optimal Space & Time Complexity
O(nm) time | O(nm) space - where n is the length of the rst string and m is the length of the second string

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.*;
class Program {
// O(nm) time | O(nm) space - where n is the length of the
// first string and m is the length of the second string
public static boolean interweavingStrings(String one, String two, String three) {
if (three.length() != one.length() + two.length()) {
return false;
}
Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
return areInterwoven(one, two, three, 0, 0, cache);
}
public static boolean areInterwoven(
String one, String two, String three, int i, int j, Boolean[][] cache) {
if (cache[i][j] != null) return cache[i][j];
int k = i + j;
if (k == three.length()) {
return true;
}
if (i < one.length() && one.charAt(i) == three.charAt(k)) {
cache[i][j] = areInterwoven(one, two, three, i + 1, j, cache);
if (cache[i][j]) return true;
}
if (j < two.length() && two.charAt(j) == three.charAt(k)) {
var result = areInterwoven(one, two, three, i, j + 1, cache);
cache[i][j] = result;
return result;
}
cache[i][j] = false;
return false;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 // O(2^(n + m)) time | O(n + m) space - where n is the length
5 // of the first string and m is the length of the second string
6 public static boolean interweavingStrings(String one, String two, String three) {
7 if (three.length() != one.length() + two.length()) {
8 return false;
9 }
10
11 return areInterwoven(one, two, three, 0, 0);
12 }
13
14 public static boolean areInterwoven(String one, String two, String three, int i, int j) {
15 int k = i + j;
16 if (k == three.length()) return true;
17
18 if (i < one.length() && one.charAt(i) == three.charAt(k)) {
19 if (areInterwoven(one, two, three, i + 1, j)) return true;
20 }
21
22 if (j < two.length() && two.charAt(j) == three.charAt(k)) {
23 return areInterwoven(one, two, three, i, j + 1);
24 }
25
26 return false;
27 }
28 }
29

```
---

## Test Cases

```
Test Case 1
{
  "one": "",
  "two": "your-dream-job",
  "three": "your-algodream-expertjob"
}
Test Case 2
{"one": "a", "two": "b", "three": "ab"}
Test Case 3
{"one": "a", "two": "b", "three": "ba"}
Test Case 4
{"one": "a", "two": "b", "three": "ac"}
Test Case 5
{"one": "abc", "two": "def", "three": "abcdef"}
Test Case 6
{"one": "abc", "two": "def", "three": "adbecf"}
Test Case 7
{"one": "abc", "two": "def", "three": "deabcf"}
Test Case 8
{"one": "aabcc", "two": "dbbca", "three": "aadbbcbcac"}
Test Case 9
{"one": "aabcc", "two": "dbbca", "three": "aadbbbaccc"}
Test Case 10
{
  "one": "",
  "two": "your-dream-job",
  "three": "ayloguore-xdpreeratm-job"
}
Test Case 11
{"one": "aaaaaaa", "two": "aaaabaaa", "three": "aaaaaaaaaaaaaab"}
Test Case 12
{"one": "aaaaaaa", "two": "aaaaaaa", "three": "aaaaaaaaaaaaaa"}
Test Case 13
{"one": "aacaaaa", "two": "aaabaaa", "three": "aaaabacaaaaaaa"}
Test Case 14
{"one": "aacaaaa", "two": "aaabaaa", "three": "aaaacabaaaaaaa"}
Test Case 15
{"one": "aacaaaa", "two": "aaabaaa", "three": "aaaaaacbaaaaaa"}
Test Case 16
{
  "one": "",
  "two": "your-dream-job",
  "three": "1your-algodream-expertjob"
}
Test Case 17
{
  "one": "",
  "two": "your-dream-job",
  "three": "your-algodream-expertjob1"
}
Test Case 18
{
  "one": "",
  "two": "your-dream-job",
  "three": "your-algodream-expertjo"
}

