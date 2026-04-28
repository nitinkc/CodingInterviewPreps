# Max Path Sum In Binary Tree

**Category:** Binary Trees

```
## Problem Statement

Max Path Sum In Binary Tree
Write a function that takes in a Binary Tree and returns its max path sum.
A path is a collection of connected nodes in a tree where no node is connected to more than two other nodes; a path sum is the sum of the values of the nodes in a particular path.
Each BinaryTree node has an integer value , a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None / null .
Sample Input
tree = 1
/ \
3
/ \ / \
5 6 7
Sample Output
// 5 + 2 + 1 + 3 + 7
Hints
Hint 1
If you were to imagine each node in a Binary Tree as the root of the Binary Tree, temporarily eliminating all of the nodes that come above it, how would you nd the max path sum for each
of these newly imagined Binary Trees? In simpler terms, how can you nd the max path sum for each subtree in the Binary Tree?
Hint 2
For every node in a Binary Tree, there are four options for the max path sum that includes its value: the node's value alone, the node's value plus the max path sum of its left subtree, the
node's value plus the max path sum of its right subtree, or the node's value plus the max path sum of both its subtrees.
Hint 3
A recursive algorithm that computes each node's max path sum and uses it to compute its parents' nodes' max path sums seems appropriate, but realize that you cannot have a path going
through a node and both its subtrees as well as that node's parent node. In other words, the fourth option mentioned in Hint #2 poses a challenge to implementing a recursive algorithm
that solves this problem. How can you get around it?
Optimal Space & Time Complexity
O(n) time | O(log(n)) space - where n is the number of nodes in the Binary Tree

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(log(n)) space
public static int maxPathSum(BinaryTree tree) {
List<Integer> maxSumArray = findMaxSum(tree);
return maxSumArray.get(1);
}
public static List<Integer> findMaxSum(BinaryTree tree) {
if (tree == null) {
return new ArrayList<Integer>(Arrays.asList(0, 0));
}
List<Integer> leftMaxSumArray = findMaxSum(tree.left);
Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
Integer leftMaxPathSum = leftMaxSumArray.get(1);
List<Integer> rightMaxSumArray = findMaxSum(tree.right);
Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
Integer rightMaxPathSum = rightMaxSumArray.get(1);
Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
Integer maxSumAsRootNode =
Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);
int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
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

```
---

## Test Cases

```
Hide

```
Video Solution
Video Solution

```
Test Case 1
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "4", "left": null, "right": null, "value": 4}
    ],
    "root": "1"
  }
}
Test Case 2
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "2", "left": null, "right": null, "value": 2}
    ],
    "root": "1"
  }
}
Test Case 3
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "-1", "value": 1},
      {"id": "-1", "left": null, "right": null, "value": -1},
      {"id": "2", "left": null, "right": null, "value": 2}
    ],
    "root": "1"
  }
}
Test Case 4
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-5", "right": "3", "value": 1},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "-5", "left": "6", "right": null, "value": -5},
      {"id": "6", "left": null, "right": null, "value": 6}
    ],
    "root": "1"
  }
}
Test Case 5
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-10", "right": "-5", "value": 1},
      {"id": "-5", "left": "-20", "right": "-21", "value": -5},
      {"id": "-21", "left": "100-2", "right": "1-3", "value": -21},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "100-2", "left": null, "right": null, "value": 100},
      {"id": "-20", "left": "100", "right": "2", "value": -20},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "100", "left": null, "right": null, "value": 100},
      {"id": "-10", "left": "30", "right": "45", "value": -10},
      {"id": "45", "left": "3", "right": "-3", "value": 45},
      {"id": "-3", "left": null, "right": null, "value": -3},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "30", "left": "5", "right": "1-2", "value": 30},
      {"id": "1-2", "left": null, "right": null, "value": 1},
      {"id": "5", "left": null, "right": null, "value": 5}
    ],
    "root": "1"
  }
}
Test Case 6
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-10", "right": "-5", "value": 1},
      {"id": "-5", "left": "-20", "right": "-21", "value": -5},
      {"id": "-21", "left": "100-3", "right": "1-3", "value": -21},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "100-3", "left": null, "right": null, "value": 100},
      {"id": "-20", "left": "100-2", "right": "2", "value": -20},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "100-2", "left": null, "right": null, "value": 100},
      {"id": "-10", "left": "30", "right": "45", "value": -10},
      {"id": "45", "left": "3", "right": "-3", "value": 45},
      {"id": "-3", "left": null, "right": null, "value": -3},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "30", "left": "5", "right": "1-2", "value": 30},
      {"id": "1-2", "left": null, "right": null, "value": 1},
      {"id": "5", "left": "100", "right": null, "value": 5},
      {"id": "100", "left": null, "right": null, "value": 100}
    ],
    "root": "1"
  }
}
Test Case 7
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-10", "right": "-5", "value": 1},
      {"id": "-5", "left": "-20", "right": "-21", "value": -5},
      {"id": "-21", "left": "100-3", "right": "1-3", "value": -21},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "100-3", "left": null, "right": null, "value": 100},
      {"id": "-20", "left": "100-2", "right": "2", "value": -20},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "100-2", "left": null, "right": null, "value": 100},
      {"id": "-10", "left": "30", "right": "75", "value": -10},
      {"id": "75", "left": "3", "right": "-3", "value": 75},
      {"id": "-3", "left": null, "right": null, "value": -3},
      {"id": "3", "left": null, "right": null, "value": 3},
      {"id": "30", "left": "5", "right": "1-2", "value": 30},
      {"id": "1-2", "left": null, "right": null, "value": 1},
      {"id": "5", "left": "100", "right": null, "value": 5},
      {"id": "100", "left": null, "right": null, "value": 100}
    ],
    "root": "1"
  }
}
Test Case 8
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-150", "right": "-5", "value": 1},
      {"id": "-5", "left": "-20", "right": "-21", "value": -5},
      {"id": "-21", "left": "100-4", "right": "1-3", "value": -21},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "100-4", "left": null, "right": null, "value": 100},
      {"id": "-20", "left": "100-3", "right": "2", "value": -20},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "100-3", "left": null, "right": null, "value": 100},
      {"id": "-150", "left": "30", "right": "75", "value": -150},
      {"id": "75", "left": "3", "right": "-3", "value": 75},
      {"id": "-3", "left": null, "right": null, "value": -3},
      {"id": "3", "left": "150", "right": "-8", "value": 3},
      {"id": "-8", "left": null, "right": null, "value": -8},
      {"id": "150", "left": null, "right": null, "value": 150},
      {"id": "30", "left": "5", "right": "1-2", "value": 30},
      {"id": "1-2", "left": "5-2", "right": "10", "value": 1},
      {"id": "10", "left": null, "right": null, "value": 10},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "5", "left": "100", "right": "100-2", "value": 5},
      {"id": "100-2", "left": null, "right": null, "value": 100},
      {"id": "100", "left": null, "right": null, "value": 100}
    ],
    "root": "1"
  }
}
Test Case 9
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-150", "right": "-5", "value": 1},
      {"id": "-5", "left": "-20", "right": "-21", "value": -5},
      {"id": "-21", "left": "100-4", "right": "1-3", "value": -21},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "100-4", "left": null, "right": null, "value": 100},
      {"id": "-20", "left": "100-3", "right": "2", "value": -20},
      {"id": "2", "left": null, "right": null, "value": 2},
      {"id": "100-3", "left": null, "right": null, "value": 100},
      {"id": "-150", "left": "30", "right": "75", "value": -150},
      {"id": "75", "left": "3", "right": "-3", "value": 75},
      {"id": "-3", "left": null, "right": null, "value": -3},
      {"id": "3", "left": "150", "right": "151", "value": 3},
      {"id": "151", "left": null, "right": null, "value": 151},
      {"id": "150", "left": null, "right": null, "value": 150},
      {"id": "30", "left": "5", "right": "1-2", "value": 30},
      {"id": "1-2", "left": "5-2", "right": "10", "value": 1},
      {"id": "10", "left": null, "right": null, "value": 10},
      {"id": "5-2", "left": null, "right": null, "value": 5},
      {"id": "5", "left": "100", "right": "100-2", "value": 5},
      {"id": "100-2", "left": null, "right": null, "value": 100},
      {"id": "100", "left": null, "right": null, "value": 100}
    ],
    "root": "1"
  }
}
Test Case 10
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-5", "right": "-3-2", "value": 1},
      {"id": "-3-2", "left": "2-2", "right": "1-7", "value": -3},
      {"id": "1-7", "left": "1-8", "right": "1-10", "value": 1},
      {"id": "1-10", "left": "-5-2", "right": "0-5", "value": 1},
      {"id": "0-5", "left": null, "right": null, "value": 0},
      {"id": "-5-2", "left": null, "right": null, "value": -5},
      {"id": "1-8", "left": "0-4", "right": "1-9", "value": 1},
      {"id": "1-9", "left": null, "right": null, "value": 1},
      {"id": "0-4", "left": null, "right": null, "value": 0},
      {"id": "2-2", "left": "0-3", "right": "5", "value": 2},
      {"id": "5", "left": "2-3", "right": "1-6", "value": 5},
      {"id": "1-6", "left": null, "right": null, "value": 1},
      {"id": "2-3", "left": null, "right": null, "value": 2},
      {"id": "0-3", "left": "-9", "right": "-91", "value": 0},
      {"id": "-91", "left": null, "right": null, "value": -91},
      {"id": "-9", "left": null, "right": null, "value": -9},
      {"id": "-5", "left": "0", "right": "2", "value": -5},
      {"id": "2", "left": "1-4", "right": "1-5", "value": 2},
      {"id": "1-5", "left": "-1-3", "right": "-100", "value": 1},
      {"id": "-100", "left": null, "right": null, "value": -100},
      {"id": "-1-3", "left": null, "right": null, "value": -1},
      {"id": "1-4", "left": "-1-2", "right": "-6", "value": 1},
      {"id": "-6", "left": null, "right": null, "value": -6},
      {"id": "-1-2", "left": null, "right": null, "value": -1},
      {"id": "0", "left": "-3", "right": "3", "value": 0},
      {"id": "3", "left": "1-3", "right": "-1", "value": 3},
      {"id": "-1", "left": null, "right": null, "value": -1},
      {"id": "1-3", "left": null, "right": null, "value": 1},
      {"id": "-3", "left": "0-2", "right": "1-2", "value": -3},
      {"id": "1-2", "left": null, "right": null, "value": 1},
      {"id": "0-2", "left": null, "right": null, "value": 0}
    ],
    "root": "1"
  }
}
Test Case 11
{
  "tree": {
    "nodes": [
      {"id": "1", "left": "-5", "right": "-3-2", "value": 1},
      {"id": "-3-2", "left": "2-2", "right": "1-6", "value": -3},
      {"id": "1-6", "left": "1-7", "right": "1-9", "value": 1},
      {"id": "1-9", "left": "-5-2", "right": "0-5", "value": 1},
  
... (test file truncated for display)
```
