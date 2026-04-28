# Group Anagrams

**Category:** Strings

```
## Problem Statement

Group Anagrams
Write a function that takes in an array of strings and groups anagrams together.
Anagrams are strings made up of exactly the same letters, where order doesn't matter. For example, "cinema" and "iceman" are anagrams; similarly, "foo" and "ofo" are
anagrams.
Your function should return a list of anagram groups in no particular order.
Sample Input
words = ["yo", "act", "flop", "tac", "cat", "oy", "olfp"]
Sample Output
[["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"]]
Hints
Hint 1
Try rearranging every input string such that each string's letters are ordered in alphabetical order. What can you do with the resulting strings?
Hint 2
For any two of the resulting strings mentioned in Hint #1 that are equal to each other, their original strings (with their letters in normal order) must be anagrams. Realizing this, you could
bucket all of these resulting strings together, all the while keeping track of their original strings, to nd the groups of anagrams.
Hint 3
Can you simply store the resulting strings mentioned in Hint #1 in a hash table and nd the groups of anagrams using this hash table?
Optimal Space & Time Complexity
O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.*;
import java.util.stream.*;
class Program {
// O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of
// the longest word
public static List<List<String>> groupAnagrams(List<String> words) {
Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
for (String word : words) {
char[] charArray = word.toCharArray();
Arrays.sort(charArray);
String sortedWord = new String(charArray);
if (anagrams.containsKey(sortedWord)) {
anagrams.get(sortedWord).add(word);
} else {
anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
}
}
List<List<String>> output = new ArrayList<List<String>>();
for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
output.add(entry.getValue());
}
return output;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4 import java.util.stream.*;
5
6 class Program {
7 // O(w * n * log(n) + n * w * log(w)) time | O(wn) space - where w is the number of words and
8 // n is the length of the longest word
9 public static List<List<String>> groupAnagrams(List<String> words) {
10 if (words.size() == 0) return new ArrayList<List<String>>();
11
12 List<String> sortedWords = new ArrayList<String>();
13 for (String word : words) {
14 char[] charArray = word.toCharArray();
15 Arrays.sort(charArray);
16 String sortedWord = new String(charArray);
17 sortedWords.add(sortedWord);
18 }
19
20 List<Integer> indices = IntStream.range(0, words.size()).boxed().collect(Collectors.toList());
21 indices.sort((a, b) -> sortedWords.get(a).compareTo(sortedWords.get(b)));
22
23 List<List<String>> result = new ArrayList<List<String>>();
24 List<String> currentAnagramGroup = new ArrayList<String>();
25 String currentAnagram = sortedWords.get(indices.get(0));
26 for (Integer index : indices) {
27 String word = words.get(index);
28 String sortedWord = sortedWords.get(index);
29
30 if (sortedWord.equals(currentAnagram)) {
31 currentAnagramGroup.add(word);
32 continue;
33 }
34
35 result.add(currentAnagramGroup);
36 currentAnagramGroup = new ArrayList<String>(Arrays.asList(word));
37 currentAnagram = sortedWord;
38 }
39
40 result.add(currentAnagramGroup);
41
42 return result;
43 }
44 }
45

```
---

## Test Cases

```
Test Case 1
{"words": ["yo", "act", "flop", "tac", "cat", "oy", "olfp"]}
Test Case 2
{"words": []}
Test Case 3
{"words": ["test"]}
Test Case 4
{"words": ["abc", "dabd", "bca", "cab", "ddba"]}
Test Case 5
{"words": ["abc", "cba", "bca"]}
Test Case 6
{"words": ["zxc", "asd", "weq", "sda", "qwe", "xcz"]}
Test Case 7
{"words": ["cinema", "a", "flop", "iceman", "meacyne", "lofp", "olfp"]}
Test Case 8
{"words": ["abc", "abe", "abf", "abg"]}

