# Invert Binary Tree

**Category:** Binary Trees

```
## Problem Statement

Invert Binary Tree
Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left node in the tree for its corresponding right node.
Each BinaryTree node has an integer value , a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None / null .
Sample Input
tree = 1
/ \
3
/ \ / \
5 6 7
/ \
9
Sample Output
/ \
2
/ \ / \
6 5 4
/ \
8
Hints
Hint 1
Start by inverting the root node of the Binary Tree. Inverting this root node simply consists of swapping its left and right child nodes, which can be done the same way as swapping two
variables.
Hint 2
Once the rst swap mentioned in Hint #1 is done, you must invert the root node's left child node and its right child node. You can do so just as you did for the root node. Then, you will have
to continue inverting child nodes' nodes until you reach the bottom of the tree.
Hint 3
How can you accomplish the process described in Hint #2? While recursion seems appropriate, would an iterative approach work? What would be the time and space complexity implications
of both approaches?
Optimal Space & Time Complexity
O(n) time | O(d) space - where n is the number of nodes in the Binary Tree and d is the depth (height) of the Binary Tree

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// O(n) time | O(d) space
public static void invertBinaryTree(BinaryTree tree) {
if (tree == null) {
return;
}
swapLeftAndRight(tree);
invertBinaryTree(tree.left);
invertBinaryTree(tree.right);
}
private static void swapLeftAndRight(BinaryTree tree) {
BinaryTree left = tree.left;
tree.left = tree.right;
tree.right = left;
}
static class BinaryTree {
public int value;
public BinaryTree left;
public BinaryTree right;
public BinaryTree(int value) {
this.value = value;
}
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.ArrayDeque;
4
5 class Program {
6 // O(n) time | O(n) space
7 public static void invertBinaryTree(BinaryTree tree) {
8 ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
9 queue.addLast(tree);
10 while (queue.size() > 0) {
11 BinaryTree current = queue.pollFirst();
12 if (current == null) {
13 continue;
14 }
15 swapLeftAndRight(current);
16 if (current.left != null) {
17 queue.addLast(current.left);
18 }
19 if (current.right != null) {
20 queue.addLast(current.right);
21 }
22 }
23 }
24
25 private static void swapLeftAndRight(BinaryTree tree) {
26 BinaryTree left = tree.left;
27 tree.left = tree.right;
28 tree.right = left;
29 }
30
31 static class BinaryTree {
32 public int value;
33 public BinaryTree left;
34 public BinaryTree right;
35
36 public BinaryTree(int value) {
37 this.value = value;
38 }
39 }
40 }
41

```
---

## Test Cases

```
Test Case 1
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": "9", "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": null, "value": 8},
      {"id": "9", "left": null, "right": null, "value": 9}
    ],
    "root": "1"
  }
}
Test Case 2
{
  "tree": {
    "nodes": [{"id": "1", "left": null, "right": null, "value": 1}],
    "root": "1"
  }
}
Test Case 3
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": null, "value": 1},
      {"id": "2", "left": null, "right": null, "value": 2}
    ],
    "root": "1"
  }
}
Test Case 4
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "3", "left": null, "right": null, "value": 3}
    ],
    "root": "1"
  }
}
Test Case 5
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": null, "value": 2},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "4", "left": null, "right": null, "value": 4}
    ],
    "root": "1"
  }
}
Test Case 6
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "4", "left": null, "right": null, "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5}
    ],
    "root": "1"
  }
}
Test Case 7
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": null, "value": 3},
      {"id": "4", "left": null, "right": null, "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6}
    ],
    "root": "1"
  }
}
Test Case 8
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": null, "right": null, "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7}
    ],
    "root": "1"
  }
}
Test Case 9
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": null, "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": null, "value": 8}
    ],
    "root": "1"
  }
}
Test Case 10
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": "9", "value": 4},
      {"id": "5", "left": "10", "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": null, "value": 8},
      {"id": "9", "left": null, "right": null, "value": 9},
      {"id": "10", "left": null, "right": null, "value": 10}
    ],
    "root": "1"
  }
}
Test Case 11
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": "9", "value": 4},
      {"id": "5", "left": "10", "right": null, "value": 5},
      {"id": "6", "left": null, "right": "11", "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": "12", "value": 8},
      {"id": "9", "left": "13", "right": "14", "value": 9},
      {"id": "10", "left": null, "right": null, "value": 10},
      {"id": "11", "left": "15", "right": "16", "value": 11},
      {"id": "12", "left": null, "right": null, "value": 12},
      {"id": "13", "left": null, "right": null, "value": 13},
      {"id": "14", "left": null, "right": null, "value": 14},
      {"id": "15", "left": null, "right": "17", "value": 15},
      {"id": "16", "left": null, "right": null, "value": 16},
      {"id": "17", "left": null, "right": "18", "value": 17},
      {"id": "18", "left": null, "right": "19", "value": 18},
      {"id": "19", "left": "20", "right": null, "value": 19},
      {"id": "20", "left": "21", "right": null, "value": 20},
      {"id": "21", "left": null, "right": null, "value": 21}
    ],
    "root": "1"
  }
}

