# Permutations

**Category:** Recursion

```
## Problem Statement

Permutations
Write a function that takes in an array of unique integers and returns an array of all permutations of those integers in no particular order.
If the input array is empty, the function should return an empty array.
Sample Input
array = [1, 2, 3]
Sample Output
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
Hints
Hint 1
A permutation is dened as a way in which a set of things can be ordered. Thus, for the list [1, 2, 3], there exist some permutations starting with 1, some starting with 2, and some
starting with 3. For the permutations starting with 1, there will be a permutation where 2 is the second number and one where 3 is the second number. For permutations starting with 3,
there will be a permutation where 1 is the second number and one where 2 is the second number. The is that, in order to construct a permutation, we can pick a random number
from our list to be the rst number, then we can pick a random number from the remaining list (without the rst number) to be the second number, then we can pick a random number
from the remaining list (without the rst and second numbers) to be the third number, and we can repeat the process until we exhaust all of our list of numbers. At that point, we will
have constructed a valid permutation. How can we implement this construction algorithmically, without picking numbers at random?
Hint 2
Iterate through the list of numbers, and begin constructing new permutations starting with each number. For each permutation that you've begun constructing, remove the number
already used (the rst number of each permutation) from the list of numbers - you'll likely have to make copies of the original list. Repeat this process by recursively iterating through the
mutated lists of numbers, appending numbers to the corresponding permutations you've already begun constructing and then removing those numbers from the respective mutated
lists; repeat this until your mutated lists are empty, at which point your constructed permutations will be as big as the original list and will be valid permutations.
Hint 3
Do you have to create so many mutated lists of numbers? Can you come up with an alternative approach that would allow you to only rely on the original list of numbers, without ever
copying it and without removing numbers from it?
Optimal Space & Time Complexity
O(n*n!) time | O(n*n!) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
import java.util.*;
class Program {
// O(n*n!) time | O(n*n!) space
public static List<List<Integer>> getPermutations(List<Integer> array) {
List<List<Integer>> permutations = new ArrayList<List<Integer>>();
getPermutations(0, array, permutations);
return permutations;
}
public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
if (i == array.size() - 1) {
permutations.add(new ArrayList<Integer>(array));
} else {
for (int j = i; j < array.size(); j++) {
swap(array, i, j);
getPermutations(i + 1, array, permutations);
swap(array, i, j);
}
}
}
public static void swap(List<Integer> array, int i, int j) {
Integer tmp = array.get(i);
array.set(i, array.get(j));
array.set(j, tmp);
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // Upper Bound: O(n^2*n!) time | O(n*n!) space
7 // Roughly: O(n*n!) time | O(n*n!) space
8 public static List<List<Integer>> getPermutations(List<Integer> array) {
9 List<List<Integer>> permutations = new ArrayList<List<Integer>>();
10 getPermutations(array, new ArrayList<Integer>(), permutations);
11 return permutations;
12 }
13
14 public static void getPermutations(
15 List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {
16 if (array.size() == 0 && currentPermutation.size() > 0) {
17 permutations.add(currentPermutation);
18 } else {
19 for (int i = 0; i < array.size(); i++) {
20 List<Integer> newArray = new ArrayList<Integer>(array);
21 newArray.remove(i);
22 List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
23 newPermutation.add(array.get(i));
24 getPermutations(newArray, newPermutation, permutations);
25 }
26 }
27 }
28 }
29

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

