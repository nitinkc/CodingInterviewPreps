# Merge Linked Lists

**Category:** Linked Lists

```
## Problem Statement

Merge Linked Lists
Write a function that takes in the heads of two Singly Linked Lists that are in sorted order, respectively. The function should merge the lists in place (i.e., it shouldn't create a brand new list) and
return the head of the merged list; the merged list should be in sorted order.
Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
You can assume that the input linked lists will always have at least one node; in other words, the heads will never be None / null .
Sample Input
headOne = 2 -> 6 -> 7 -> 8 // the head node with value 2
headTwo = 1 -> 3 -> 4 -> 5 -> 9 -> 10 // the head node with value 1
Sample Output
-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 // the new head node with value 1
Hints
Hint 1
You can iterate through the Linked Lists from head to tail and merge them along the way by inserting nodes from the second Linked List into the rst Linked List.
Hint 2
You'll need to manipulate three nodes at once at every step.
Hint 3
At every step, you'll need to have three variables (p1, p2, and p1Prev) pointing to the current node in the rst Linked List (p1), the current node in the second Linked List (p2), and the
previous node in the rst Linked List (p1Prev). If the value of p1 is smaller than the value of p2, then you can just "move forward" in the rst Linked List by moving p1 and p1Prev forward
by one position (p1Prev becomes p1 and p1 becomes p1.next). If the value of p1 is greater than the value of p2, then you need to insert p2 before p1. You'll have to rst make p1Prev
point to p2, then make p2 point to p1, all the while not losing track of p2's "next" node, which you'll need to move to right after. You'll also have to handle edge cases when you're dealing
with head nodes or tail nodes.
Hint 4
You can implement this algorithm both iteratively and recursively following nearly identical logic.
Optimal Space & Time Complexity
O(n + m) time | O(1) space - where n is the number of nodes in the rst Linked List and m is the number of nodes in the second Linked List

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
public static class LinkedList {
int value;
LinkedList next;
LinkedList(int value) {
this.value = value;
this.next = null;
}
}
// O(n + m) time | O(n + m) space - where n is the number of nodes in the first
// Linked List and m is the number of nodes in the second Linked List
public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
recursiveMerge(headOne, headTwo, null);
return headOne.value < headTwo.value ? headOne : headTwo;
}
public static void recursiveMerge(LinkedList p1, LinkedList p2, LinkedList p1Prev) {
if (p1 == null) {
p1Prev.next = p2;
return;
}
if (p2 == null) return;
if (p1.value < p2.value) {
recursiveMerge(p1.next, p2, p1);
} else {
if (p1Prev != null) p1Prev.next = p2;
LinkedList newP2 = p2.next;
p2.next = p1;
recursiveMerge(p1, newP2, p2);
}
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 class Program {
4 public static class LinkedList {
5 int value;
6 LinkedList next;
7
8 LinkedList(int value) {
9 this.value = value;
10 this.next = null;
11 }
12 }
13
14 // O(n + m) time | O(1) space - where n is the number of nodes in the first
15 // Linked List and m is the number of nodes in the second Linked List
16 public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
17 LinkedList p1 = headOne;
18 LinkedList p1Prev = null;
19 LinkedList p2 = headTwo;
20 while (p1 != null && p2 != null) {
21 if (p1.value < p2.value) {
22 p1Prev = p1;
23 p1 = p1.next;
24 } else {
25 if (p1Prev != null) p1Prev.next = p2;
26 p1Prev = p2;
27 p2 = p2.next;
28 p1Prev.next = p1;
29 }
30 }
31 if (p1 == null) p1Prev.next = p2;
32 return headOne.value < headTwo.value ? headOne : headTwo;
33 }
34 }
35

```
---

## Test Cases

```
Test Case 1
{
  "linkedListOne": {
    "head": "2",
    "nodes": [
      {"id": "2", "next": "6", "value": 2},
      {"id": "6", "next": "7", "value": 6},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": null, "value": 8}
    ]
  },
  "linkedListTwo": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "3", "value": 1},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "9", "value": 5},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": null, "value": 10}
    ]
  }
}
Test Case 2
{
  "linkedListOne": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": null, "value": 5}
    ]
  },
  "linkedListTwo": {
    "head": "6",
    "nodes": [
      {"id": "6", "next": "7", "value": 6},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": "9", "value": 8},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": null, "value": 10}
    ]
  }
}
Test Case 3
{
  "linkedListOne": {
    "head": "6",
    "nodes": [
      {"id": "6", "next": "7", "value": 6},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": "9", "value": 8},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": null, "value": 10}
    ]
  },
  "linkedListTwo": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": null, "value": 5}
    ]
  }
}
Test Case 4
{
  "linkedListOne": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "3", "value": 1},
      {"id": "3", "next": "5", "value": 3},
      {"id": "5", "next": "7", "value": 5},
      {"id": "7", "next": "9", "value": 7},
      {"id": "9", "next": null, "value": 9}
    ]
  },
  "linkedListTwo": {
    "head": "2",
    "nodes": [
      {"id": "2", "next": "4", "value": 2},
      {"id": "4", "next": "6", "value": 4},
      {"id": "6", "next": "8", "value": 6},
      {"id": "8", "next": "10", "value": 8},
      {"id": "10", "next": null, "value": 10}
    ]
  }
}
Test Case 5
{
  "linkedListOne": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "7", "value": 5},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": "9", "value": 8},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": null, "value": 10}
    ]
  },
  "linkedListTwo": {
    "head": "6",
    "nodes": [{"id": "6", "next": null, "value": 6}]
  }
}
Test Case 6
{
  "linkedListOne": {
    "head": "6",
    "nodes": [{"id": "6", "next": null, "value": 6}]
  },
  "linkedListTwo": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "7", "value": 5},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": "9", "value": 8},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": null, "value": 10}
    ]
  }
}
Test Case 7
{
  "linkedListOne": {
    "head": "1",
    "nodes": [{"id": "1", "next": null, "value": 1}]
  },
  "linkedListTwo": {
    "head": "2",
    "nodes": [{"id": "2", "next": null, "value": 2}]
  }
}
Test Case 8
{
  "linkedListOne": {
    "head": "2",
    "nodes": [{"id": "2", "next": null, "value": 2}]
  },
  "linkedListTwo": {
    "head": "1",
    "nodes": [{"id": "1", "next": null, "value": 1}]
  }
}
Test Case 9
{
  "linkedListOne": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "1-2", "value": 1},
      {"id": "1-2", "next": "1-3", "value": 1},
      {"id": "1-3", "next": "3", "value": 1},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "5-2", "value": 5},
      {"id": "5-2", "next": "5-3", "value": 5},
      {"id": "5-3", "next": "5-4", "value": 5},
      {"id": "5-4", "next": "10", "value": 5},
      {"id": "10", "next": null, "value": 10}
    ]
  },
  "linkedListTwo": {
    "head": "1",
    "nodes": [
      {"id": "1", "next": "1-2", "value": 1},
      {"id": "1-2", "next": "2", "value": 1},
      {"id": "2", "next": "2-2", "value": 2},
      {"id": "2-2", "next": "5", "value": 2},
      {"id": "5", "next": "6", "value": 5},
      {"id": "6", "next": "10", "value": 6},
      {"id": "10", "next": "10-2", "value": 10},
      {"id": "10-2", "next": null, "value": 10}
    ]
  }
}

