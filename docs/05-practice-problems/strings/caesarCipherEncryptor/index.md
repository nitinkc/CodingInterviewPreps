# Caesar Cipher Encryptor

**Category:** Strings

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

Solution 1 Solution 2
2
3 class Program {
4 // O(n) time | O(n) space
5 public static String caesarCypherEncryptor(String str, int key) {
6 char[] newLetters = new char[str.length()];
7 int newKey = key % 26;
8 String alphabet = "abcdefghijklmnopqrstuvwxyz";
9 for (int i = 0; i < str.length(); i++) {
10 newLetters[i] = getNewLetter(str.charAt(i), newKey, alphabet);
11 }
12 return new String(newLetters);
13 }
14
15 public static char getNewLetter(char letter, int key, String alphabet) {
16 int newLetterCode = alphabet.indexOf(letter) + key;
17 return newLetterCode <= 25
18 ? alphabet.charAt(newLetterCode)
19 : alphabet.charAt(-1 + newLetterCode % 25);
20 }
21 }
22
SubCmusitto Cmo dOeutp
Run o
when

### Solution 2

Solution 1 Solution 2
2
3 class Program {
4 // O(n) time | O(n) space
5 public static String caesarCypherEncryptor(String str, int key) {
6 char[] newLetters = new char[str.length()];
7 int newKey = key % 26;
8 for (int i = 0; i < str.length(); i++) {
9 newLetters[i] = getNewLetter(str.charAt(i), newKey);
10 }
11 return new String(newLetters);
12 }
13
14 public static char getNewLetter(char letter, int key) {
15 int newLetterCode = letter + key;
16 return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
17 }
18 }
19
SubCmusitto Cmo dOeutp
Run o
when

```
---

## Test Cases

```
Test Case 1
{"string": "xyz", "key": 2}
Test Case 2
{"string": "abc", "key": 0}
Test Case 3
{"string": "abc", "key": 3}
Test Case 4
{"string": "xyz", "key": 5}
Test Case 5
{"string": "abc", "key": 26}
Test Case 6
{"string": "abc", "key": 52}
Test Case 7
{"string": "abc", "key": 57}

