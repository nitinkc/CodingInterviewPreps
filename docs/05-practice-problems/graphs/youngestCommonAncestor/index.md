# Youngest Common Ancestor

**Category:** Graphs

```
## Problem Statement

Youngest Common Ancestor
You're given three inputs, all of which are instances of an AncestralTree class that have an ancestor property pointing to their youngest ancestor. The rst input is the top ancestor in
an ancestral tree (i.e., the only instance that has no ancestor--its ancestor property points to None / null ), and the other two inputs are descendants in the ancestral tree.
Write a function that returns the youngest common ancestor to the two descendants.
Sample Input
// The nodes are from the ancestral tree below.
topAncestor = Node A
descendantOne = Node E
descendantTwo = Node I
A
/ \
B C
/ \ / \
D E F G
/ \
H I
Sample Output
Node B
Hints
Hint 1
You could try to simultaneously iterate through the ancestors of both input descendants until you nd a common ancestor; however, if one of the descendants has more ancestors than
the other (i.e., is lower in the ancestral tree), you won't nd the youngest common ancestor. How can you get around this problem?
Hint 2
Start by nding the two input descendants' depths in the ancestral tree. If one of them is deeper, iterate up through its ancestors until you reach the depth of the higher descendant.
Then, iterate through both descendants' ancestors in tandem until you nd the rst common ancestor. Note that at this point, one of the descendants will be the ancestor of the lower
descendant that is at the same level as the higher descendant.
Optimal Space & Time Complexity
O(d) time | O(1) space - where d is the depth (height) of the ancestral tree

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(d) time | O(1) space - where d is the depth (height) of the ancestral tree
public static AncestralTree getYoungestCommonAncestor(
AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
int depthOne = getDescendantDepth(descendantOne, topAncestor);
int depthTwo = getDescendantDepth(descendantTwo, topAncestor);
if (depthOne > depthTwo) {
return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
} else {
return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
}
}
public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
int depth = 0;
while (descendant != topAncestor) {
depth++;
descendant = descendant.ancestor;
}
return depth;
}
public static AncestralTree backtrackAncestralTree(
AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
while (diff > 0) {
lowerDescendant = lowerDescendant.ancestor;
diff--;
}
while (lowerDescendant != higherDescendant) {
lowerDescendant = lowerDescendant.ancestor;
higherDescendant = higherDescendant.ancestor;
}
return lowerDescendant;
}
static class AncestralTree {
public char name;
public AncestralTree ancestor;
AncestralTree(char name) {
this.name = name;
this.ancestor = null;
}
// This method is for testing only.
void addAsAncestor(AncestralTree[] descendants) {
for (AncestralTree descendant : descendants) {
descendant.ancestor = this;
}
}
}
}
