# Powerset

**Category:** Recursion

```
## Problem Statement

Powerset
Write a function that takes in an array of unique integers and returns its powerset.
The powerset P(X) of a set X is the set of all subsets of X . For example, the powerset of [1,2] is [[], [1], [2], [1,2]] .
Note that the sets in the powerset do not need to be in any particular order.
Sample Input
array = [1, 2, 3]
Sample Output
[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
Hints
Hint 1
Try thinking about the base cases. What is the powerset of the empty set? What is the powerset of sets of length 1?
Hint 2
If you were to take the input set X and add an element to it, how would the resulting powerset change?
Hint 3
Can you solve this problem recursively? Can you solve it iteratively? What are the advantages and disadvantages of using either approach?
Optimal Space & Time Complexity
O(n*2^n) time | O(n*2^n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.*;
class Program {
// O(n*2^n) time | O(n*2^n) space
public static List<List<Integer>> powerset(List<Integer> array) {
List<List<Integer>> subsets = new ArrayList<List<Integer>>();
subsets.add(new ArrayList<Integer>());
for (Integer ele : array) {
int length = subsets.size();
for (int i = 0; i < length; i++) {
List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
currentSubset.add(ele);
subsets.add(currentSubset);
}
}
return subsets;
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(n*2^n) time | O(n*2^n) space
7 public static List<List<Integer>> powerset(List<Integer> array) {
8 return powerset(array, array.size() - 1);
9 }
10
11 public static List<List<Integer>> powerset(List<Integer> array, int idx) {
12 if (idx < 0) {
13 List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
14 emptySet.add(new ArrayList<Integer>());
15 return emptySet;
16 }
17 int ele = array.get(idx);
18 List<List<Integer>> subsets = powerset(array, idx - 1);
19 int length = subsets.size();
20 for (int i = 0; i < length; i++) {
21 List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
22 currentSubset.add(ele);
23 subsets.add(currentSubset);
24 }
25 return subsets;
26 }
27 }
28

```
---

## Test Cases

```
Test Case 1
{"array": [1, 2, 3]}
Test Case 2
{"array": []}
Test Case 3
{"array": [1]}
Test Case 4
{"array": [1, 2]}
Test Case 5
{"array": [1, 2, 3, 4]}
Test Case 6
{"array": [1, 2, 3, 4, 5]}
Test Case 7
{"array": [1, 2, 3, 4, 5, 6]}

