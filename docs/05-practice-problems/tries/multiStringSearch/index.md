# Multi String Search

**Category:** Tries

```
## Problem Statement

Multi String Search
Write a function that takes in a big string and an array of small strings, all of which are smaller in length than the big string. The function should return an array of booleans, where each
boolean represents whether the small string at that index in the array of small strings is contained in the big string.
Note that you can't use language-built-in string-matching methods.
Sample Input
bigString = "this is a big string"
smallStrings = ["this", "yo", "is", "a", "bigger", "string", "kappa"]
Sample Output
[true, false, true, true, false, true, false]
Hints
Hint 1
A simple way to solve this problem is to iterate through all of the small strings, checking if each of them is contained in the big string by iterating through the big string's characters and
comparing them to the given small string's characters with a couple of loops. Is this approach ecient from a time-complexity point of view?
Hint 2
Try building a sux-trie-like data structure containing all of the big string's suxes. Then, iterate through all of the small strings and check if each of them is contained in the data
structure you've created. What are the time-complexity ramications of this approach?
Hint 3
Try building a trie containing all of the small strings. Then, iterate through the big string's characters and check if any part of the big string is a string contained in the trie you've created.
Is this approach better than the one described in Hint #2 from a time-complexity point of view?
Optimal Space & Time Complexity
O(ns + bs) time | O(ns) space - where n is the number of small strings, s is the length of longest small string, and b is the length of the big string

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3
import java.util.*;
class Program {
// O(b^2 + ns) time | O(b^2 + n) space
public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
List<Boolean> solution = new ArrayList<Boolean>();
for (String smallString : smallStrings) {
solution.add(modifiedSuffixTrie.contains(smallString));
}
return solution;
}
static class TrieNode {
Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
}
static class ModifiedSuffixTrie {
TrieNode root = new TrieNode();
public ModifiedSuffixTrie(String str) {
populateModifiedSuffixTrieFrom(str);
}
public void populateModifiedSuffixTrieFrom(String str) {
for (int i = 0; i < str.length(); i++) {
insertSubstringStartingAt(i, str);
}
}
public void insertSubstringStartingAt(int i, String str) {
TrieNode node = root;
for (int j = i; j < str.length(); j++) {
char letter = str.charAt(j);
if (!node.children.containsKey(letter)) {
TrieNode newNode = new TrieNode();
node.children.put(letter, newNode);
}
node = node.children.get(letter);
}
}
public boolean contains(String str) {
TrieNode node = root;
for (int i = 0; i < str.length(); i++) {
char letter = str.charAt(i);
if (!node.children.containsKey(letter)) {
return false;
}
node = node.children.get(letter);
}
return true;
}
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 // O(b^2 + ns) time | O(b^2 + n) space
7 public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
8 ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
9 List<Boolean> solution = new ArrayList<Boolean>();
10 for (String smallString : smallStrings) {
11 solution.add(modifiedSuffixTrie.contains(smallString));
12 }
13 return solution;
14 }
15
16 static class TrieNode {
17 Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
18 }
19
20 static class ModifiedSuffixTrie {
21 TrieNode root = new TrieNode();
22
23 public ModifiedSuffixTrie(String str) {
24 populateModifiedSuffixTrieFrom(str);
25 }
26
27 public void populateModifiedSuffixTrieFrom(String str) {
28 for (int i = 0; i < str.length(); i++) {
29 insertSubstringStartingAt(i, str);
30 }
31 }
32
33 public void insertSubstringStartingAt(int i, String str) {
34 TrieNode node = root;
35 for (int j = i; j < str.length(); j++) {
36 char letter = str.charAt(j);
37 if (!node.children.containsKey(letter)) {
38 TrieNode newNode = new TrieNode();
39 node.children.put(letter, newNode);
40 }
41 node = node.children.get(letter);
42 }
43 }
44
45 public boolean contains(String str) {

### Solution 3

```
Solution 1 Solution 2 Solution 3
import java.util.*;
class Program {
// O(ns + bs) time | O(ns) space
public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
Trie trie = new Trie();
for (String smallString : smallStrings) {
trie.insert(smallString);
}
Set<String> containedStrings = new HashSet<String>();
for (int i = 0; i < bigString.length(); i++) {
findSmallStringsIn(bigString, i, trie, containedStrings);
}
List<Boolean> solution = new ArrayList<Boolean>();
for (String str : smallStrings) {
solution.add(containedStrings.contains(str));
}
return solution;
}
public static void findSmallStringsIn(
String str, int startIdx, Trie trie, Set<String> containedStrings) {
TrieNode currentNode = trie.root;
for (int i = startIdx; i < str.length(); i++) {
char currentChar = str.charAt(i);
if (!currentNode.children.containsKey(currentChar)) {
break;
}
currentNode = currentNode.children.get(currentChar);
if (currentNode.children.containsKey(trie.endSymbol)) {
containedStrings.add(currentNode.word);
}
}
}
static class TrieNode {
Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
String word;
}
static class Trie {
TrieNode root = new TrieNode();
char endSymbol = '*';
public void insert(String str) {
TrieNode node = root;
for (int i = 0; i < str.length(); i++) {
char letter = str.charAt(i);
if (!node.children.containsKey(letter)) {
TrieNode newNode = new TrieNode();
node.children.put(letter, newNode);
}
node = node.children.get(letter);
}
node.children.put(endSymbol, null);
node.word = str;
}
}
}

### Solution 4

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 // O(bns) time | O(n) space
7 public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
8 List<Boolean> solution = new ArrayList<Boolean>();
9 for (String smallString : smallStrings) {
10 solution.add(isInBigString(bigString, smallString));
11 }
12 return solution;
13 }
14
15 public static boolean isInBigString(String bigString, String smallString) {
16 for (int i = 0; i < bigString.length(); i++) {
17 if (i + smallString.length() > bigString.length()) {
18 break;
19 }
20 if (isInBigString(bigString, smallString, i)) {
21 return true;
22 }
23 }
24 return false;
25 }
26
27 public static boolean isInBigString(String bigString, String smallString, int startIdx) {
28 int leftBigIdx = startIdx;
29 int rightBigIdx = startIdx + smallString.length() - 1;
30 int leftSmallIdx = 0;
31 int rightSmallIdx = smallString.length() - 1;
32 while (leftBigIdx <= rightBigIdx) {
33 if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx)
34 || bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
35 return false;
36 }
37 leftBigIdx++;
38 rightBigIdx--;
39 leftSmallIdx++;
40 rightSmallIdx--;
41 }
42 return true;
43 }
44 }
45
