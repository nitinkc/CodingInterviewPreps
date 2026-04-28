# Bst Traversal

**Category:** Binary Search Trees

```
## Problem Statement

BST Traversal
Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse the BST, add its nodes' values to the input array, and return that array. The three functions should
traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
If you're unfamiliar with tree-traversal techniques, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.
Each BST node has an integer value , a left child node, and a right child node. A node is said to be a valid BST node if and only if it satises the BST property: its value is strictly
greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves or None /
null .
Sample Input
tree = 10
/ \
15
/ \ \
5 22
/
array = []
Sample Output
inOrderTraverse: [1, 2, 5, 5, 10, 15, 22] // where the array is the input array
preOrderTraverse: [10, 5, 2, 1, 5, 15, 22] // where the array is the input array
postOrderTraverse: [1, 2, 5, 5, 22, 15, 10] // where the array is the input array
Hints
Hint 1
Realize that in-order traversal simply means traversing left nodes before traversing current nodes before traversing right nodes. Try implementing this algorithm recursively by calling the
inOrderTraverse method on a left node, then appending the current node's value to the input array, and then calling the inOrderTraverse method on a right node.
Hint 2
Apply the same logic described in Hint #1 for the two other traversal methods, but change the order in which you do things.
Optimal Space & Time Complexity
All three methods: O(n) time | O(n) space - where n is the number of nodes in the BST

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(n) space
public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
if (tree.left != null) {
inOrderTraverse(tree.left, array);
}
array.add(tree.value);
if (tree.right != null) {
inOrderTraverse(tree.right, array);
}
return array;
}
// O(n) time | O(n) space
public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
array.add(tree.value);
if (tree.left != null) {
preOrderTraverse(tree.left, array);
}
if (tree.right != null) {
preOrderTraverse(tree.right, array);
}
return array;
}
// O(n) time | O(n) space
public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
if (tree.left != null) {
postOrderTraverse(tree.left, array);
}
if (tree.right != null) {
postOrderTraverse(tree.right, array);
}
array.add(tree.value);
return array;
}
static class BST {
public int value;
public BST left;
public BST right;
public BST(int value) {
this.value = value;
}
}
}

```
---

## Test Cases

```
Test Case 1
{
  "tree": {
    "nodes": [
      {"id": "10", "left": "5", "right": "15", "value": 10},
      {"id": "15", "left": null, "right": "22", "value": 15},
      {"id": "22", "left": null, "right": null, "value": 22},
      {"id": "5", "left": "2", "right": "5-2", "value": 5},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "2", "left": "1", "right": null, "value": 2},
      {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "10"
  }
}
Test Case 2
{
  "tree": {
    "nodes": [
      {"id": "100", "left": "5", "right": "502", "value": 100},
      {"id": "502", "left": "204", "right": "55000", "value": 502},
      {"id": "55000", "left": "1001", "right": null, "value": 55000},
      {"id": "1001", "left": null, "right": "4500", "value": 1001},
      {"id": "4500", "left": null, "right": null, "value": 4500},
      {"id": "204", "left": "203", "right": "205", "value": 204},
      {"id": "205", "left": null, "right": "207", "value": 205},
      {"id": "207", "left": "206", "right": "208", "value": 207},
      {"id": "208", "left": null, "right": null, "value": 208},
      {"id": "206", "left": null, "right": null, "value": 206},
      {"id": "203", "left": null, "right": null, "value": 203},
      {"id": "5", "left": "2", "right": "15", "value": 5},
      {"id": "15", "left": "5-2", "right": "22", "value": 15},
      {"id": "22", "left": null, "right": "57", "value": 22},
      {"id": "57", "left": null, "right": "60", "value": 57},
      {"id": "60", "left": null, "right": null, "value": 60},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "2", "left": "1", "right": "3", "value": 2},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "1", "left": "-51", "right": "1-2", "value": 1},
      {"id": "1-2", "left": null, "right": "1-3", "value": 1},
      {"id": "1-3", "left": null, "right": "1-4", "value": 1},
      {"id": "1-4", "left": null, "right": "1-5", "value": 1},
      {"id": "1-5", "left": null, "right": null, "value": 1},
      {"id": "-51", "left": "-403", "right": null, "value": -51},
      {"id": "-403", "left": null, "right": null, "value": -403}
    ],
    "root": "100"
  }
}
Test Case 3
{
  "tree": {
    "nodes": [
      {"id": "10", "left": "5", "right": "15", "value": 10},
      {"id": "15", "left": null, "right": "22", "value": 15},
      {"id": "22", "left": null, "right": null, "value": 22},
      {"id": "5", "left": "2", "right": "5-2", "value": 5},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "2", "left": "1", "right": null, "value": 2},
      {"id": "1", "left": "-5", "right": null, "value": 1},
      {"id": "-5", "left": "-15", "right": "-5-2", "value": -5},
      {"id": "-5-2", "left": null, "right": "-2", "value": -5},
      {"id": "-2", "left": null, "right": "-1", "value": -2},
      {"id": "-1", "left": null, "right": null, "value": -1},
      {"id": "-15", "left": "-22", "right": null, "value": -15},
      {"id": "-22", "left": null, "right": null, "value": -22}
    ],
    "root": "10"
  }
}
Test Case 4
{
  "tree": {
    "nodes": [{"id": "10", "left": null, "right": null, "value": 10}],
    "root": "10"
  }
}
Test Case 5
{
  "tree": {
    "nodes": [
      {"id": "10", "left": "5", "right": "15", "value": 10},
      {"id": "15", "left": null, "right": "22", "value": 15},
      {"id": "22", "left": null, "right": "500", "value": 22},
      {"id": "500", "left": "50", "right": "1500", "value": 500},
      {"id": "1500", "left": null, "right": "10000", "value": 1500},
      {"id": "10000", "left": "2200", "right": null, "value": 10000},
      {"id": "2200", "left": null, "right": null, "value": 2200},
      {"id": "50", "left": null, "right": "200", "value": 50},
      {"id": "200", "left": null, "right": null, "value": 200},
      {"id": "5", "left": "2", "right": "5-2", "value": 5},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "2", "left": "1", "right": null, "value": 2},
      {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "10"
  }
}
Test Case 6
{
  "tree": {
    "nodes": [
      {"id": "5000", "left": "5", "right": "55000", "value": 5000},
      {"id": "55000", "left": null, "right": null, "value": 55000},
      {"id": "5", "left": "2", "right": "15", "value": 5},
      {"id": "15", "left": "5-2", "right": "22", "value": 15},
      {"id": "22", "left": null, "right": "502", "value": 22},
      {"id": "502", "left": "204", "right": null, "value": 502},
      {"id": "204", "left": "203", "right": "205", "value": 204},
      {"id": "205", "left": null, "right": "207", "value": 205},
      {"id": "207", "left": "206", "right": "208", "value": 207},
      {"id": "208", "left": null, "right": null, "value": 208},
      {"id": "206", "left": null, "right": null, "value": 206},
      {"id": "203", "left": null, "right": null, "value": 203},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "2", "left": "1", "right": "3", "value": 2},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "1", "left": null, "right": "1-2", "value": 1},
      {"id": "1-2", "left": null, "right": "1-3", "value": 1},
      {"id": "1-3", "left": null, "right": "1-4", "value": 1},
      {"id": "1-4", "left": null, "right": "1-5", "value": 1},
      {"id": "1-5", "left": null, "right": null, "value": 1}
    ],
    "root": "5000"
  }
}

