# Reverse Linked List

**Category:** Linked Lists

```
## Problem Statement

Reverse Linked List
Write a function that takes in the head of a Singly Linked List, reverses the list in place (i.e., doesn't create a brand new list), and returns its new head.
Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
You can assume that the input Linked List will always have at least one node; in other words, the head will never be None / null .
Sample Input
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
Sample Output
-> 4 -> 3 -> 2 -> 1 -> 0 // the new head node with value 5
Hints
Hint 1
You can iterate through the Linked List from head to tail and reverse it in place along the way.
Hint 2
You'll need to manipulate three nodes at once at every step.
Hint 3
Imagine you have three variables pointing to three consecutive nodes in a Linked List. Start by setting the "next" property of the second node to the rst node. Then, set the rst variable
to the second node, and set the second variable to the third node. Finally, set the third variable to the second variable's "next" property (at this point, the second variable is the original
third node). Repeat this process until you're at the tail of the Linked List.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the number of nodes in the Linked List

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space - where n is the number of nodes in the Linked List
public static LinkedList reverseLinkedList(LinkedList head) {
LinkedList p1 = null;
LinkedList p2 = head;
while (p2 != null) {
LinkedList p3 = p2.next;
p2.next = p1;
p1 = p2;
p2 = p3;
}
return p1;
}
static class LinkedList {
int value;
LinkedList next = null;
public LinkedList(int value) {
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
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": null, "value": 5}
    ]
  }
}
Test Case 2
{"linkedList": {"head": "0", "nodes": [{"id": "0", "next": null, "value": 0}]}}
Test Case 3
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": null, "value": 1}
    ]
  }
}
Test Case 4
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": null, "value": 2}
    ]
  }
}
Test Case 5
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": null, "value": 3}
    ]
  }
}
Test Case 6
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "6", "value": 5},
      {"id": "6", "next": null, "value": 6}
    ]
  }
}
Test Case 7
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": "6", "value": 5},
      {"id": "6", "next": "7", "value": 6},
      {"id": "7", "next": "8", "value": 7},
      {"id": "8", "next": "9", "value": 8},
      {"id": "9", "next": "10", "value": 9},
      {"id": "10", "next": "11", "value": 10},
      {"id": "11", "next": "12", "value": 11},
      {"id": "12", "next": null, "value": 12}
    ]
  }
}

