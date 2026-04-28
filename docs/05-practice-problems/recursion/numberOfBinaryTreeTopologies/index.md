# Number Of Binary Tree Topologies

**Category:** Recursion

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3
import java.util.*;
class Program {
// O(n^2) time | O(n) space
public static int numberOfBinaryTreeTopologies(int n) {
List<Integer> cache = new ArrayList<Integer>();
cache.add(1);
for (int m = 1; m < n + 1; m++) {
int numberOfTrees = 0;
for (int leftTreeSize = 0; leftTreeSize < m; leftTreeSize++) {
int rightTreeSize = m - 1 - leftTreeSize;
int numberOfLeftTrees = cache.get(leftTreeSize);
int numberOfRightTrees = cache.get(rightTreeSize);
numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
}
cache.add(numberOfTrees);
}
return cache.get(n);
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 // O(n^2) time | O(n) space
7 public static int numberOfBinaryTreeTopologies(int n) {
8 Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
9 cache.put(0, 1);
10 return numberOfBinaryTreeTopologies(n, cache);
11 }
12
13 public static int numberOfBinaryTreeTopologies(int n, Map<Integer, Integer> cache) {
14 if (cache.containsKey(n)) {
15 return cache.get(n);
16 }
17 int numberOfTrees = 0;
18 for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
19 int rightTreeSize = n - 1 - leftTreeSize;
20 int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize, cache);
21 int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize, cache);
22 numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
23 }
24 cache.put(n, numberOfTrees);
25 return numberOfTrees;
26 }
27 }
28

### Solution 3

```
Solution 1 Solution 2 Solution 3
class Program {
// Upper Bound: O((n*(2n)!)/(n!(n+1)!)) time | O(n) space
public static int numberOfBinaryTreeTopologies(int n) {
if (n == 0) {
return 1;
}
int numberOfTrees = 0;
for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
int rightTreeSize = n - 1 - leftTreeSize;
int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
}
return numberOfTrees;
}
}

```
---

## Test Cases

```
Test Case 1
{"n": 3}
Test Case 2
{"n": 0}
Test Case 3
{"n": 1}
Test Case 4
{"n": 2}
Test Case 5
{"n": 4}
Test Case 6
{"n": 5}
Test Case 7
{"n": 6}
Test Case 8
{"n": 7}
Test Case 9
{"n": 8}
Test Case 10
{"n": 9}
Test Case 11
{"n": 10}
Test Case 12
{"n": 11}
Test Case 13
{"n": 12}

