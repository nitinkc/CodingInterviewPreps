# Longest Substring Without Duplication

**Category:** Strings

```
## Problem Statement

Longest Substring Without Duplication
Write a function that takes in a string and returns its longest substring without duplicate characters.
You can assume that there will only be one longest substring without duplication.
Sample Input
string = "clementisacap"
Sample Output
"mentisac"
Hints
Hint 1
Try traversing the input string and storing the last position at which you see each character in a hash table. How can this help you solve the given problem?
Hint 2
As you traverse the input string, keep track of a starting index variable. This variable, as its name suggests, should represent the most recent index from which you could start a substring
with no duplicate characters, ending at your current index. Use the hash table mentioned in Hint #1 to update this variable correctly, and update the longest substring as you go.
Optimal Space & Time Complexity
O(n) time | O(min(n, a)) space - where n is the length of the input string and a is the length of the character alphabet represented in the input string

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(min(n, a)) space
public static String longestSubstringWithoutDuplication(String str) {
Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
int[] longest = {0, 1};
int startIdx = 0;
for (int i = 0; i < str.length(); i++) {
char c = str.charAt(i);
if (lastSeen.containsKey(c)) {
startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
}
if (longest[1] - longest[0] < i + 1 - startIdx) {
longest = new int[] {startIdx, i + 1};
}
lastSeen.put(c, i);
}
String result = str.substring(longest[0], longest[1]);
return result;
}
}

```
---

## Test Cases

```
Test Case 1
{"string": "clementisacap"}
Test Case 2
{"string": "a"}
Test Case 3
{"string": "abc"}
Test Case 4
{"string": "abcb"}
Test Case 5
{"string": "abcdeabcdefc"}
Test Case 6
{"string": "abccdeaabbcddef"}
Test Case 7
{"string": "abacacacaaabacaaaeaaafa"}
Test Case 8
{"string": "abcdabcef"}
Test Case 9
{"string": "abcbde"}
Test Case 10
{"string": "clementisanarm"}

