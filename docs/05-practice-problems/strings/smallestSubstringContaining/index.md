# Smallest Substring Containing

**Category:** Strings

```
## Problem Statement

Smallest Substring Containing
You're given two non-empty strings: a big string and a small string. Write a function that returns the smallest substring in the big string that contains all of the small string's characters.
Note that:
- The substring can contain other characters not found in the small string.
- The characters in the substring don't have to be in the same order as they appear in the small string.
- If the small string has duplicate characters, the substring has to contain those duplicate characters (it can also contain more, but not fewer).
You can assume that there will only be one relevant smallest substring.
Sample Input
bigString = "abcd$ef$axb$c$"
smallString = "$$abf"
Sample Output
"f$axb$"
Hints
Hint 1
Try storing all of the small string's character counts in a hash table where each character maps to the number of times that it appears in the small string.
Hint 2
Try using two pointers (a left pointer and a right pointer) to traverse through the big string. How can this help you nd the relevant smallest substring?
Hint 3
With the two pointers mentioned in Hint #2, move the right pointer to the right in the big string, keeping track of all the characters you visit in a hash table identical to the one mentioned
in Hint #1, until you've found all of the characters contained in the small string. At that point, move the left pointer to the right in the big string, keeping track of all the characters you
"lose", and stop once you no longer have all of the small string's characters in between the left and right pointers. Then, repeat the process by moving the right pointer forward and
implementing the same logic described in this Hint.
Optimal Space & Time Complexity
O(b + s) time | O(b + s) space - where b is the length of the big input string and s is the length of the small input string

```
---

## Approach & Solution

### Solution 1

```
List<Integer> substringBounds = new ArrayList<Integer>(Arrays.asList(0, Integer.MAX_VALUE));
Map<Character, Integer> substringCharCounts = new HashMap<Character, Integer>();
int numUniqueChars = targetCharCounts.size();
int numUniqueCharsDone = 0;
int leftIdx = 0;
int rightIdx = 0;
// Move the rightIdx to the right in the string until you've counted
// all of the target characters enough times.
while (rightIdx < string.length()) {
char rightChar = string.charAt(rightIdx);
if (!targetCharCounts.containsKey(rightChar)) {
rightIdx++;
continue;
}
increaseCharCount(rightChar, substringCharCounts);
if (substringCharCounts.get(rightChar) == targetCharCounts.get(rightChar)) {
numUniqueCharsDone++;
}
// Move the leftIdx to the right in the string until you no longer
// have enough of the target characters in between the leftIdx and
// the rightIdx. Update the substringBounds accordingly.
while (numUniqueCharsDone == numUniqueChars && leftIdx <= rightIdx) {
substringBounds =
getCloserBounds(leftIdx, rightIdx, substringBounds.get(0), substringBounds.get(1));
char leftChar = string.charAt(leftIdx);
if (!targetCharCounts.containsKey(leftChar)) {
leftIdx++;
continue;
}
if (substringCharCounts.get(leftChar) == targetCharCounts.get(leftChar)) {
numUniqueCharsDone--;
}
decreaseCharCount(leftChar, substringCharCounts);
leftIdx++;
}
rightIdx++;
}
return substringBounds;
}
public static List<Integer> getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
return idx2 - idx1 < idx4 - idx3
? new ArrayList<Integer>(Arrays.asList(idx1, idx2))
: new ArrayList<Integer>(Arrays.asList(idx3, idx4));
}
public static String getStringFromBounds(String string, List<Integer> bounds) {
int start = bounds.get(0);
int end = bounds.get(1);
if (end == Integer.MAX_VALUE) return "";
return string.substring(start, end + 1);
}
public static void increaseCharCount(char c, Map<Character, Integer> charCounts) {
if (!charCounts.containsKey(c)) {
charCounts.put(c, 1);
} else {
charCounts.put(c, charCounts.get(c) + 1);
}
}
public static void decreaseCharCount(char c, Map<Character, Integer> charCounts) {
charCounts.put(c, charCounts.get(c) - 1);
}
}

### Solution 2

```
23 String string, Map<Character, Integer> targetCharCounts) {
24 List<Integer> substringBounds = new ArrayList<Integer>(Arrays.asList(0, Integer.MAX_VALUE));
25 Map<Character, Integer> substringCharCounts = new HashMap<Character, Integer>();
26 int numUniqueChars = targetCharCounts.size();
27 int numUniqueCharsDone = 0;
28 int leftIdx = 0;
29 int rightIdx = 0;
30 // Move the rightIdx to the right in the string until you've counted
31 // all of the target characters enough times.
32 while (rightIdx < string.length()) {
33 char rightChar = string.charAt(rightIdx);
34 if (!targetCharCounts.containsKey(rightChar)) {
35 rightIdx++;
36 continue;
37 }
38 increaseCharCount(rightChar, substringCharCounts);
39 if (substringCharCounts.get(rightChar) == targetCharCounts.get(rightChar)) {
40 numUniqueCharsDone++;
41 }
42 // Move the leftIdx to the right in the string until you no longer
43 // have enough of the target characters in between the leftIdx and
44 // the rightIdx. Update the substringBounds accordingly.
45 while (numUniqueCharsDone == numUniqueChars && leftIdx <= rightIdx) {
46 substringBounds =
47 getCloserBounds(leftIdx, rightIdx, substringBounds.get(0), substringBounds.get(1));
48 char leftChar = string.charAt(leftIdx);
49 if (!targetCharCounts.containsKey(leftChar)) {
50 leftIdx++;
51 continue;
52 }
53 if (substringCharCounts.get(leftChar) == targetCharCounts.get(leftChar)) {
54 numUniqueCharsDone--;
55 }
56 decreaseCharCount(leftChar, substringCharCounts);
57 leftIdx++;
58 }
59 rightIdx++;
60 }
61 return substringBounds;
62 }
63
64 public static List<Integer> getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
65 return idx2 - idx1 < idx4 - idx3
66 ? new ArrayList<Integer>(Arrays.asList(idx1, idx2))
67 : new ArrayList<Integer>(Arrays.asList(idx3, idx4));
68 }
69
70 public static String getStringFromBounds(String string, List<Integer> bounds) {
71 int start = bounds.get(0);
72 int end = bounds.get(1);
73 if (end == Integer.MAX_VALUE) return "";
74 return string.substring(start, end + 1);
75 }
76
77 public static void increaseCharCount(char c, Map<Character, Integer> charCounts) {
78 if (!charCounts.containsKey(c)) {
79 charCounts.put(c, 1);
80 } else {
81 charCounts.put(c, charCounts.get(c) + 1);
82 }
83 }
84
85 public static void decreaseCharCount(char c, Map<Character, Integer> charCounts) {
86 charCounts.put(c, charCounts.get(c) - 1);
87 }
88 }

### Solution 3

```java
import java.util.*;
class Program {
// O(b + s) time | O(b + s) space - where b is the length of the big
// input string and s is the length of the small input string
public static String smallestSubstringContaining(String bigString, String smallString) {
Map<Character, Integer> targetCharCounts = getCharCounts(smallString);
List<Integer> substringBounds = getSubstringBounds(bigString, targetCharCounts);
return getStringFromBounds(bigString, substringBounds);
}
public static Map<Character, Integer> getCharCounts(String string) {
Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
for (int i = 0; i < string.length(); i++) {
increaseCharCount(string.charAt(i), charCounts);
}
return charCounts;
}
public static List<Integer> getSubstringBounds(
String string, Map<Character, Integer> targetCharCounts) {
List<Integer> substringBounds = new ArrayList<Integer>(Arrays.asList(0, Integer.MAX_VALUE));
Map<Character, Integer> substringCharCounts = new HashMap<Character, Integer>();
int numUniqueChars = targetCharCounts.size();
int numUniqueCharsDone = 0;
int leftIdx = 0;
int rightIdx = 0;
// Move the rightIdx to the right in the string until you've counted
// all of the target characters enough times.
while (rightIdx < string.length()) {
char rightChar = string.charAt(rightIdx);
if (!targetCharCounts.containsKey(rightChar)) {
rightIdx++;
continue;
}
increaseCharCount(rightChar, substringCharCounts);
if (substringCharCounts.get(rightChar) == targetCharCounts.get(rightChar)) {
numUniqueCharsDone++;
}
// Move the leftIdx to the right in the string until you no longer
// have enough of the target characters in between the leftIdx and
// the rightIdx. Update the substringBounds accordingly.
while (numUniqueCharsDone == numUniqueChars && leftIdx <= rightIdx) {

```
---

## Test Cases

```
Test Case 1
{"bigString": "abcd$ef$axb$c$", "smallString": "$$abf"}
Test Case 2
{"bigString": "abcdef", "smallString": "fa"}
Test Case 3
{"bigString": "abcdef", "smallString": "d"}
Test Case 4
{"bigString": "abcdefghijklmnopqrstuvwxyz", "smallString": "aajjttwwxxzz"}
Test Case 5
{
  "bigString": "abzacdwejxjftghiwjtklmnopqrstuvwxyz",
  "smallString": "aajjttwwxxzz"
}
Test Case 6
{
  "bigString": "abzacdwejxjfxztghiwjtklmnopqrstuvwxyz",
  "smallString": "aajjttwwxxzz"
}
Test Case 7
{"bigString": "aaaa+a$+aaa++$+++++++aaa", "smallString": "a+$aaAaaaa$++"}
Test Case 8
{
  "bigString": "a$fuu+afff+affaffa+a$Affab+a+a+$a$",
  "smallString": "a+$aaAaaaa$++"
}
Test Case 9
{
  "bigString": "a$fuu+afff+affaffa+a$Affab+a+a+$a$bccgtt+aaaacA+++aaa$",
  "smallString": "a+$aaAaaaa$++"
}
Test Case 10
{"bigString": "145624356128828193236336541277356789901", "smallString": "123"}
Test Case 11
{"bigString": "1456243561288281932363365412356789901!", "smallString": "123!"}
Test Case 12
{"bigString": "14562435612!88281932363365$412356789901", "smallString": "$123!"}
Test Case 13
{
  "bigString": "14562435612!88281932363365$412356789901",
  "smallString": "#!123!"
}
Test Case 14
{
  "bigString": "14562435612!88281932363365$412356789901",
  "smallString": "#!333333123!"
}
Test Case 15
{
  "bigString": "14562435612z!8828!193236!336!5$41!23!5!6789901#",
  "smallString": "#!2z"
}
Test Case 16
{
  "bigString": "14562435612z!8828!193236!336!5$41!23!5!6789901#z2!",
  "smallString": "#!2z"
}

