# Longest String Chain

**Category:** Dynamic Programming

```
## Problem Statement

Longest String Chain
Given a list of strings, write a function that returns the longest string chain that can be built from those strings.
A string chain is dened as follows: let string A be a string in the initial array; if removing any single character from string A yields a new string B that's contained in the initial array of
strings, then strings A and B form a string chain of length 2. Similarly, if removing any single character from string B yields a new string C that's contained in the initial array of strings,
then strings A , B , and C form a string chain of length 3.
The function should return the string chain in descending order (i.e., from the longest string to the shortest one). Note that string chains of length 1 don't exist; if the list of strings doesn't
contain any string chain formed by two or more strings, the function should return an empty array.
You can assume that there will only be one longest string chain.
Sample Input
strings = ["abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"]
Sample Output
["abcdef", "abcde", "abde", "ade", "ae"]
Hints
Hint 1
For each string, you will have to remove every letter one at a time to see if the resulting strings are contained in the input list of strings. What data structure lends itself to quickly
checking if these strings are located in the list of input strings?
Hint 2
Realize that every string in the input list of strings potentially has a string chain (and therefore a longest string chain) that starts with itself. Compute all of these string chains and store
them so that you don't have to compute them more than once.
Hint 3
Sort the input list of strings (from shortest to longest string) in order to simplify the problem. Iterate through the list of sorted strings, and for each string, compute the longest string
chain that starts with itself. To do so, try removing every letter from each string and seeing if the resulting strings are in the input list of strings; you can do so in constant time by
dumping every string in a hash table. In the hash table, store the longest string chain of every string as you compute them. As you iterate through longer strings, whenever you nd a
shorter string for which you've already computed the longest string chain, you can very quickly append the longer string to that already-computed string chain. Do this for every string,
and you'll eventually nd the longest string chain that you're looking for.
Hint 4
Do you need to store every string's longest string chain mentioned in Hint #3, or can you store less information per string so as to take up less auxiliary space?
Optimal Space & Time Complexity
O(n * m^2 + nlog(n)) time | O(nm) space - where n is the number of strings and m is the length of the longest string

```
---

## Approach & Solution

### Solution 1

14 }
15 }
16
17 // O(n * m^2 + nlog(n)) time | O(nm) space - where n is the number of strings
18 // and m is the length of the longest string
19 public static List<String> longestStringChain(List<String> strings) {
20 // For every string, imagine the longest string chain that starts with it.
21 // Set up every string to point to the next string in its respective longest
22 // string chain. Also keep track of the lengths of these longest string
23 // chains.
24 Map<String, stringChain> stringChains = new HashMap<String, stringChain>();
25 for (String string : strings) {
26 stringChains.put(string, new stringChain("", 1));
27 }
28
29 // Sort the strings based on their length so that whenever we visit a
30 // string (as we iterate through them from left to right), we can
31 // already have computed the longest string chains of any smaller strings.
32 List<String> sortedStrings = new ArrayList<String>(strings);
33 sortedStrings.sort((a, b) -> a.length() - b.length());
34
35 for (String string : sortedStrings) {
36 findLongestStringChain(string, stringChains);
37 }
38
39 return buildLongestStringChain(strings, stringChains);
40 }
41
42 public static void findLongestStringChain(String string, Map<String, stringChain> stringChains) {
43 // Try removing every letter of the current string to see if the
44 // remaining strings form a string chain.
45 for (int i = 0; i < string.length(); i++) {
46 String smallerString = getSmallerString(string, i);
47 if (!stringChains.containsKey(smallerString)) continue;
48 tryUpdateLongestStringChain(string, smallerString, stringChains);
49 }
50 }
51
bmCiut sCtoomde Ou
52 public static String getSmallerString(String string, int index) {
53 return string.substring(0, index) + string.substring(index + 1);
54 }
55
56 public static void tryUpdateLongestStringChain(
57 String currentString, String smallerString, Map<String, stringChain> stringChains) {
58 int smallerStringChainLength = stringChains.get(smallerString).maxChainLength;
59 int currentStringChainLength = stringChains.get(currentString).maxChainLength;
60 // Update the string chain of the current string only if the smaller string
61 // leads to a longer string chain.
62 if (smallerStringChainLength + 1 > currentStringChainLength) {
63 stringChains.get(currentString).maxChainLength = smallerStringChainLength + 1;
i i i i i
64 stringChains.get(currentString).nextString = smallerString;
65 }
66 }
67
68 public static List<String> buildLongestStringChain(
69 List<String> strings, Map<String, stringChain> stringChains) {
70 // Find the string that starts the longest string chain.
Run
71 int maxChainLength = 0;
72 String chainStartingString = ""; wh
73 for (String string : strings) {
74 if (stringChains.get(string).maxChainLength > maxChainLength) {
75 maxChainLength = stringChains.get(string).maxChainLength;
76 chainStartingString = string;
77 }
78 }
79
80 // Starting at the string found above, build the longest string chain.
81 List<String> ourLongestStringChain = new ArrayList<String>();
82 String currentString = chainStartingString;
83 while (currentString != "") {
84 ourLongestStringChain.add(currentString);
85 currentString = stringChains.get(currentString).nextString;
86 }
87
88 return ourLongestStringChain.size() == 1 ? new ArrayList<String>() : ourLongestStringChain;
89 }
90 }
91

### Solution 2

```java
import java.util.*;
class Program {
public static class stringChain {
String nextString;
Integer maxChainLength;
public stringChain(String nextString, Integer maxChainLength) {
this.nextString = nextString;
this.maxChainLength = maxChainLength;
}
}
// O(n * m^2 + nlog(n)) time | O(nm) space - where n is the number of strings
// and m is the length of the longest string
public static List<String> longestStringChain(List<String> strings) {
// For every string, imagine the longest string chain that starts with it.
// Set up every string to point to the next string in its respective longest
// string chain. Also keep track of the lengths of these longest string
// chains.
Map<String, stringChain> stringChains = new HashMap<String, stringChain>();
for (String string : strings) {
stringChains.put(string, new stringChain("", 1));
}
// Sort the strings based on their length so that whenever we visit a
// string (as we iterate through them from left to right), we can
// already have computed the longest string chains of any smaller strings.
List<String> sortedStrings = new ArrayList<String>(strings);
sortedStrings.sort((a, b) -> a.length() - b.length());
for (String string : sortedStrings) {
findLongestStringChain(string, stringChains);
}
return buildLongestStringChain(strings, stringChains); bmCiut sCtoomde Ou
}
public static void findLongestStringChain(String string, Map<String, stringChain> stringChains) {
// Try removing every letter of the current string to see if the
// remaining strings form a string chain.
for (int i = 0; i < string.length(); i++) {
String smallerString = getSmallerString(string, i);
if (!stringChains.containsKey(smallerString)) continue;
tryUpdateLongestStringChain(string, smallerString, stringChains);
}
}
public static String getSmallerString(String string, int index) {
return string.substring(0, index) + string.substring(index + 1);
}
public static void tryUpdateLongestStringChain(
String currentString, String smallerString, Map<String, stringChain> stringChains) { Run
int smallerStringChainLength = stringChains.get(smallerString).maxChainLength;
wh
