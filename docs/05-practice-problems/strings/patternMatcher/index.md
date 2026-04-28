# Pattern Matcher

**Category:** Strings

```
## Problem Statement

Pattern Matcher
You're given two non-empty strings. The rst one is a pattern consisting of only "x" s and / or "y" s; the other one is a normal string of alphanumeric characters. Write a function that
checks whether the normal string matches the pattern.
A string S0 is said to match a pattern if replacing all "x" s in the pattern with some substring S1 of S0 and replacing all "y" s in the pattern with some substring S2 of S0 yields the
same string S0 .
If the input string doesn't match the input pattern, the function should return an empty array; otherwise, it should return an array holding the strings S0 and S1 that represent "x" and
"y" in the normal string, in that order. If the pattern doesn't contain any "x" s or "y" s, the respective letter should be represented by an empty string in the nal array that you return.
You can assume that there will never be more than one pair of strings S1 and S2 that appropriately represent "x" and "y" in the normal string.
Sample Input
pattern = "xxyxxy"
string = "gogopowerrangergogopowerranger"
Sample Output
["go", "powerranger"]
Hints
Hint 1
Start by checking if the pattern starts with an "x". If it doesn't, consider generating a new pattern that swaps all "x"s for "y"s and vice-versa; this might greatly simplify the rest of your
algorithm. Make sure to keep track of whether or not you do this swap, as your nal answer will be aected by it.
Hint 2
Use a hash table to store the number of "x"s and "y"s that appear in the pattern, and keep track of the position of the rst "y". Knowing how many "x"s and "y"s appear in the pattern,
paired with the length of the main string which you have access to, will allow you to quickly test out various possible lengths for "x" and "y". Knowing where the rst "y" appears in the
pattern will allow you to actually generate potential substrings.
Hint 3
Traverse the main string and try dierent combinations of substrings that could represent "x" and "y". For each potential combination, map the new pattern mentioned in Hint #1 and
see if it matches the main string.
Optimal Space & Time Complexity
O(n^2 + m) time | O(n + m) space - where n is the length of the main string and m is the length of the pattern

```
---

## Approach & Solution

### Solution 1

```
String y = str.substring(yIdx, yIdx + (int) lenOfY);
String potentialMatch = buildPotentialMatch(newPattern, x, y);
if (str.equals(potentialMatch)) {
return didSwitch ? new String[] {y, x} : new String[] {x, y};
}
}
} else {
double lenOfX = str.length() / counts.get('x');
if (lenOfX % 1 == 0) {
String x = str.substring(0, (int) lenOfX);
String potentialMatch = buildPotentialMatch(newPattern, x, "");
if (str.equals(potentialMatch)) {
return didSwitch ? new String[] {"", x} : new String[] {x, ""};
}
}
}
return new String[] {};
}
public static char[] getNewPattern(String pattern) {
char[] patternLetters = pattern.toCharArray();
if (pattern.charAt(0) == 'x') {
return patternLetters;
}
for (int i = 0; i < patternLetters.length; i++) {
if (patternLetters[i] == 'x') {
patternLetters[i] = 'y';
} else {
patternLetters[i] = 'x';
}
}
return patternLetters;
}
public static int getCountsAndFirstYPos(char[] pattern, Map<Character, Integer> counts) {
int firstYPos = -1;
for (int i = 0; i < pattern.length; i++) {
char c = pattern[i];
counts.put(c, counts.get(c) + 1);
if (c == 'y' && firstYPos == -1) {
firstYPos = i;
}
}
return firstYPos;
}
public static String buildPotentialMatch(char[] pattern, String x, String y) {
StringBuilder potentialMatch = new StringBuilder();
for (char c : pattern) {
if (c == 'x') {
potentialMatch.append(x);
} else {
potentialMatch.append(y);
}
}
return potentialMatch.toString();
}
}

### Solution 2

```java
import java.util.*;
4
class Program {
// O(n^2 + m) time | O(n + m) space
public static String[] patternMatcher(String pattern, String str) {
if (pattern.length() > str.length()) {
return new String[] {};
}
char[] newPattern = getNewPattern(pattern);
boolean didSwitch = newPattern[0] != pattern.charAt(0);
Map<Character, Integer> counts = new HashMap<Character, Integer>();
counts.put('x', 0);
counts.put('y', 0);
int firstYPos = getCountsAndFirstYPos(newPattern, counts);
if (counts.get('y') != 0) {
for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
double lenOfY =
((double) str.length() - (double) lenOfX * (double) counts.get('x'))
/ (double) counts.get('y');
if (lenOfY <= 0 || lenOfY % 1 != 0) {
continue;
}
int yIdx = firstYPos * lenOfX;
String x = str.substring(0, lenOfX);
String y = str.substring(yIdx, yIdx + (int) lenOfY);
String potentialMatch = buildPotentialMatch(newPattern, x, y);
if (str.equals(potentialMatch)) {
return didSwitch ? new String[] {y, x} : new String[] {x, y};
}
}
} else {
double lenOfX = str.length() / counts.get('x');
if (lenOfX % 1 == 0) {
String x = str.substring(0, (int) lenOfX);
String potentialMatch = buildPotentialMatch(newPattern, x, "");
if (str.equals(potentialMatch)) {
return didSwitch ? new String[] {"", x} : new String[] {x, ""};
}
}
}
return new String[] {};
}
45
public static char[] getNewPattern(String pattern) {
char[] patternLetters = pattern.toCharArray();
if (pattern.charAt(0) == 'x') {
return patternLetters;
}

```
---

## Test Cases

```
Test Case 1
{"pattern": "xxyxxy", "string": "gogopowerrangergogopowerranger"}
Test Case 2
{"pattern": "xyxy", "string": "abab"}
Test Case 3
{"pattern": "yxyx", "string": "abab"}
Test Case 4
{"pattern": "yxx", "string": "yomama"}
Test Case 5
{"pattern": "yyxyyx", "string": "gogopowerrangergogopowerranger"}
Test Case 6
{"pattern": "xyx", "string": "thisshouldobviouslybewrong"}
Test Case 7
{"pattern": "xxxx", "string": "testtesttesttest"}
Test Case 8
{"pattern": "yyyy", "string": "testtesttesttest"}
Test Case 9
{"pattern": "xxyxyy", "string": "testtestwrongtestwrongtest"}
Test Case 10
{
  "pattern": "xyxxxyyx",
  "string": "baddaddoombaddadoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom"
}
Test Case 11
{
  "pattern": "yxyyyxxy",
  "string": "baddaddoombaddaddoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom"
}
Test Case 12
{
  "pattern": "xyxxxyyx",
  "string": "baddaddoombaddaddoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom"
}

