# Longest Increasing Subsequence

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
// O(nlogn) time | O(n) space
public static List<Integer> longestIncreasingSubsequence(int[] array) {
int[] sequences = new int[array.length];
int[] indices = new int[array.length + 1];
Arrays.fill(indices, Integer.MIN_VALUE);
int length = 0;
for (int i = 0; i < array.length; i++) {
int num = array[i];
int newLength = binarySearch(1, length, indices, array, num);
sequences[i] = indices[newLength - 1];
indices[newLength] = i;
length = Math.max(length, newLength);
}
return buildSequence(array, sequences, indices[length]);
}
public static int binarySearch(int startIdx, int endIdx, int[] indices, int[] array, int num) {
if (startIdx > endIdx) {
return startIdx;
}
int middleIdx = (startIdx + endIdx) / 2;
if (array[indices[middleIdx]] < num) {
startIdx = middleIdx + 1;
} else {
endIdx = middleIdx - 1;
}
return binarySearch(startIdx, endIdx, indices, array, num);
}
public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
List<Integer> sequence = new ArrayList<Integer>();
while (currentIdx != Integer.MIN_VALUE) {
sequence.add(0, array[currentIdx]);
currentIdx = sequences[currentIdx];
}
return sequence;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(n^2) time | O(n) space
7 public static List<Integer> longestIncreasingSubsequence(int[] array) {
8 int[] sequences = new int[array.length];
9 Arrays.fill(sequences, Integer.MIN_VALUE);
10 int[] lengths = new int[array.length];
11 Arrays.fill(lengths, 1);
12 int maxLengthIdx = 0;
13 for (int i = 0; i < array.length; i++) {
14 int currentNum = array[i];
15 for (int j = 0; j < i; j++) {
16 int otherNum = array[j];
17 if (otherNum < currentNum && lengths[j] + 1 >= lengths[i]) {
18 lengths[i] = lengths[j] + 1;
19 sequences[i] = j;
20 }
21 }
22 if (lengths[i] >= lengths[maxLengthIdx]) {
23 maxLengthIdx = i;
24 }
25 }
26 return buildSequence(array, sequences, maxLengthIdx);
27 }
28
29 public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
30 List<Integer> sequence = new ArrayList<Integer>();
31 while (currentIdx != Integer.MIN_VALUE) {
32 sequence.add(0, array[currentIdx]);
33 currentIdx = sequences[currentIdx];
34 }
35 return sequence;
36 }
37 }
38

```
---

## Test Cases

```
Test Case 1
{"array": [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]}
Test Case 2
{"array": [-1]}
Test Case 3
{"array": [-1, 2]}
Test Case 4
{"array": [-1, 2, 1, 2]}
Test Case 5
{"array": [1, 5, -1, 10]}
Test Case 6
{"array": [1, 5, -1, 0, 6, 2, 4]}
Test Case 7
{"array": [3, 4, -1]}
Test Case 8
{"array": [29, 2, 32, 12, 30, 31]}
Test Case 9
{"array": [10, 22, 9, 33, 21, 61, 41, 60, 80]}
Test Case 10
{"array": [100, 1, 2, 3, 4, 101]}

