# Numbers In Pi

**Category:** Dynamic Programming

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.*;
class Program {
// O(n^3 + m) time | O(n + m) space - where n is the number of digits in Pi and m is the number of
// favorite numbers
public static int numbersInPi(String pi, String[] numbers) {
Set<String> numbersTable = new HashSet<String>();
for (String number : numbers) {
numbersTable.add(number);
}
Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
for (int i = pi.length() - 1; i >= 0; i--) {
getMinSpaces(pi, numbersTable, cache, i);
}
return cache.get(0) == Integer.MAX_VALUE ? -1 : cache.get(0);
}
public static int getMinSpaces(
String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx) {
if (idx == pi.length()) return -1;
if (cache.containsKey(idx)) return cache.get(idx);
int minSpaces = Integer.MAX_VALUE;
for (int i = idx; i < pi.length(); i++) {
String prefix = pi.substring(idx, i + 1);
if (numbersTable.contains(prefix)) {
int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
// Handle int overflow.
if (minSpacesInSuffix == Integer.MAX_VALUE) {
minSpaces = Math.min(minSpaces, minSpacesInSuffix);
} else {
minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
}
}
}
cache.put(idx, minSpaces);
return cache.get(idx);
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(n^3 + m) time | O(n + m) space - where n is the number of digits in Pi and m is the number of
7 // favorite numbers
8 public static int numbersInPi(String pi, String[] numbers) {
9 Set<String> numbersTable = new HashSet<String>();
10 for (String number : numbers) {
11 numbersTable.add(number);
12 }
13 Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
14 int minSpaces = getMinSpaces(pi, numbersTable, cache, 0);
15 return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
16 }
17
18 public static int getMinSpaces(
19 String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx) {
20 if (idx == pi.length()) return -1;
21 if (cache.containsKey(idx)) return cache.get(idx);
22 int minSpaces = Integer.MAX_VALUE;
23 for (int i = idx; i < pi.length(); i++) {
24 String prefix = pi.substring(idx, i + 1);
25 if (numbersTable.contains(prefix)) {
26 int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
27 // Handle int overflow.
28 if (minSpacesInSuffix == Integer.MAX_VALUE) {
29 minSpaces = Math.min(minSpaces, minSpacesInSuffix);
30 } else {
31 minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
32 }
33 }
34 }
35 cache.put(idx, minSpaces);
36 return cache.get(idx);
37 }
38 }
39

```
---

## Test Cases

```
Video Solution
Video Solution

```
Test Case 1
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "314159265358979323846",
    "26433",
    "8",
    "3279",
    "314159265",
    "35897932384626433832",
    "79"
  ]
}
Test Case 2
{
  "pi": "3141592653589793238462643383279",
  "numbers": ["314159265358979323846264338327", "9"]
}
Test Case 3
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "314",
    "49",
    "9001",
    "15926535897",
    "14",
    "9323",
    "8462643383279",
    "4",
    "793"
  ]
}
Test Case 4
{
  "pi": "3141592653589793238462643383279",
  "numbers": ["3141592653589793238462643383279"]
}
Test Case 5
{
  "pi": "3141592653589793238462643383279",
  "numbers": ["3141", "1512", "159", "793", "12412451", "8462643383279"]
}
Test Case 6
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "314159265358979323846",
    "327",
    "26433",
    "8",
    "3279",
    "9",
    "314159265",
    "35897932384626433832",
    "79"
  ]
}
Test Case 7
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "141592653589793238462643383279",
    "314159265358979323846",
    "327",
    "26433",
    "8",
    "3279",
    "9",
    "314159265",
    "35897932384626433832",
    "79",
    "3"
  ]
}
Test Case 8
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "1",
    "4",
    "592",
    "65",
    "55",
    "35",
    "8",
    "9793",
    "2384626",
    "83279"
  ]
}
Test Case 9
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "1",
    "4",
    "592",
    "65",
    "55",
    "35",
    "8",
    "9793",
    "2384626",
    "383279"
  ]
}
Test Case 10
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "141",
    "592",
    "65",
    "55",
    "35",
    "8",
    "9793",
    "2384626",
    "383279"
  ]
}
Test Case 11
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "141",
    "592",
    "65",
    "55",
    "35",
    "8",
    "9793",
    "23846264",
    "383279"
  ]
}
Test Case 12
{
  "pi": "3141592653589793238462643383279",
  "numbers": [
    "3",
    "141",
    "592",
    "65",
    "55",
    "35",
    "8",
    "9793",
    "23846264",
    "3832798"
  ]
}

