# Linked List Construction

**Category:** Linked Lists

```
## Problem Statement

Linked List Construction
Write a DoublyLinkedList class that has a head and a tail , both of which point to either a linked list Node or None / null . The class should support:
- Setting the head and tail of the linked list.
- Inserting nodes before and after other nodes as well as at given positions.
- Removing given nodes and removing nodes with given values;
- Searching for nodes with given values.
Each Node has an integer value as well as a prev node and a next node, both of which can point to either another node or None / null .
Sample Usage
// Assume the following linked list has already been created:
<-> 2 <-> 3 <-> 4 <-> 5
setHead(4): 4 <-> 1 <-> 2 <-> 3 <-> 5 // set the existing node with value 4 as the head
setTail(6): 4 <-> 1 <-> 2 <-> 3 <-> 5 <-> 6 // set the existing node with value 6 as the tail
insertBefore(6, 3): 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 // move the existing node with value 3 before the existing node with value 6
insertAfter(6, 3): 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 <-> 3 // insert a new node with value 3 after the existing node with value 6
insertAtPosition(1, 3): 3 <-> 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 <-> 3 // insert a new node with value 3 in position 1
removeNodesWithValue(3): 4 <-> 1 <-> 2 <-> 5 <-> 6 // remove all nodes with value 3
remove(2): 4 <-> 1 <-> 5 <-> 6 // remove the existing node with value 2
containsNodeWithValue(5): true
Hints
Hint 1
When dealing with linked lists, it's very important to keep track of pointers on nodes (i.e., the "next" and "prev" properties on the nodes). For instance, if you're inserting a node in a
linked list, but that node is already located somewhere else in the linked list (in other words, if you're moving a node), it's crucial to completely update the pointers of the adjacent nodes
of the node being moved before updating the node's own pointers. The order in which you update nodes' pointers will make or break your algorithm.
Hint 2
Realize that the insertBefore() and insertAfter() methods can be used to implement the setHead(), setTail(), and insertAtPosition() methods; making the insertBefore() and insertAfter()
methods as robust as possible will simplify your code for the other methods. Make sure to take care of edge cases involving inserting nodes before the head of the linked list or
inserting nodes after the tail of the linked list.
Hint 3
Similar to Hint #2, realize that the remove() method can be used to implement the removeNodesWithValue() method as well as parts of the insertBefore() and insertAfter() methods;
make sure that the remove() method handles edge cases regarding the head and the tail.
Optimal Space & Time Complexity
setHead, setTail, insertBefore, insertAfter, and remove: O(1) time | O(1) space
insertAtPosition: O(p) time | O(1) space - where p is input position
removeNodesWithValue, containsNodeWithValue: O(n) time | O(1) space - where n is the number of nodes in the linked list

```
---

## Approach & Solution

### Solution 1

```
}
node.next = nodeToInsert;
}
// O(p) time | O(1) space
public void insertAtPosition(int position, Node nodeToInsert) {
if (position == 1) {
setHead(nodeToInsert);
return;
}
Node node = head;
int currentPosition = 1;
while (node != null && currentPosition++ != position) node = node.next;
if (node != null) {
insertBefore(node, nodeToInsert);
} else {
setTail(nodeToInsert);
}
}
// O(n) time | O(1) space
public void removeNodesWithValue(int value) {
Node node = head;
while (node != null) {
Node nodeToRemove = node;
node = node.next;
if (nodeToRemove.value == value) remove(nodeToRemove);
}
}
// O(1) time | O(1) space
public void remove(Node node) {
if (node == head) head = head.next;
if (node == tail) tail = tail.prev;
removeNodeBindings(node);
}
// O(n) time | O(1) space
public boolean containsNodeWithValue(int value) {
Node node = head;
while (node != null && node.value != value) node = node.next;
return node != null;
}
public void removeNodeBindings(Node node) {
if (node.prev != null) node.prev.next = node.next;
if (node.next != null) node.next.prev = node.prev;
node.prev = null;
node.next = null;
}
}
static class Node {
public int value;
public Node prev;
public Node next;
public Node(int value) {
this.value = value;
}
}
}

### Solution 2

```
60 }
61 Node node = head;
62 int currentPosition = 1;
63 while (node != null && currentPosition++ != position) node = node.next;
64 if (node != null) {
65 insertBefore(node, nodeToInsert);
66 } else {
67 setTail(nodeToInsert);
68 }
69 }
70
71 // O(n) time | O(1) space
72 public void removeNodesWithValue(int value) {
73 Node node = head;
74 while (node != null) {
75 Node nodeToRemove = node;
76 node = node.next;
77 if (nodeToRemove.value == value) remove(nodeToRemove);
78 }
79 }
80
81 // O(1) time | O(1) space
82 public void remove(Node node) {
83 if (node == head) head = head.next;
84 if (node == tail) tail = tail.prev;
85 removeNodeBindings(node);
86 }
87
88 // O(n) time | O(1) space
89 public boolean containsNodeWithValue(int value) {
90 Node node = head;
91 while (node != null && node.value != value) node = node.next;
92 return node != null;
93 }
94
95 public void removeNodeBindings(Node node) {
96 if (node.prev != null) node.prev.next = node.next;
97 if (node.next != null) node.next.prev = node.prev;
98 node.prev = null;
99 node.next = null;
100 }
101 }
102
103 static class Node {
104 public int value;
105 public Node prev;
106 public Node next;
107
108 public Node(int value) {
109 this.value = value;
110 }
111 }
112 }

### Solution 3

```java
class Program {
static class DoublyLinkedList {
public Node head;
public Node tail;
// O(1) time | O(1) space
public void setHead(Node node) {
if (head == null) {
head = node;
tail = node;
return;
}
insertBefore(head, node);
}
// O(1) time | O(1) space
public void setTail(Node node) {
if (tail == null) {
setHead(node);
return;
}
insertAfter(tail, node);
}
// O(1) time | O(1) space
public void insertBefore(Node node, Node nodeToInsert) {
if (nodeToInsert == head && nodeToInsert == tail) return;
remove(nodeToInsert);
nodeToInsert.prev = node.prev;
nodeToInsert.next = node;
if (node.prev == null) {
head = nodeToInsert;
} else {
node.prev.next = nodeToInsert;
}
node.prev = nodeToInsert;
}
// O(1) time | O(1) space
public void insertAfter(Node node, Node nodeToInsert) {
if (nodeToInsert == head && nodeToInsert == tail) return;
remove(nodeToInsert);
nodeToInsert.prev = node;
nodeToInsert.next = node.next;
if (node.next == null) {
tail = nodeToInsert;
} else {
node.next.prev = nodeToInsert;
}
node.next = nodeToInsert;
}
// O(p) time | O(1) space
public void insertAtPosition(int position, Node nodeToInsert) {
if (position == 1) {
setHead(nodeToInsert);
return;
}
Node node = head;
int currentPosition = 1;

```
---

## Code Template

```java
// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      // Write your code here.
    }

    public void setTail(Node node) {
      // Write your code here.
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      // Write your code here.
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      // Write your code here.
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
    }

    public void removeNodesWithValue(int value) {
      // Write your code here.
    }

    public void remove(Node node) {
      // Write your code here.
    }

    public boolean containsNodeWithValue(int value) {
      // Write your code here.
      return false;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}

```
---

```
## Test Cases

```
Test Case 1
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "3-2", "next": null, "prev": null, "value": 3},
    {"id": "3-3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4},
    {"id": "5", "next": null, "prev": null, "value": 5},
    {"id": "6", "next": null, "prev": null, "value": 6}
  ],
  "classMethodsToCall": [
    {"arguments": ["5"], "method": "setHead"},
    {"arguments": ["4"], "method": "setHead"},
    {"arguments": ["3"], "method": "setHead"},
    {"arguments": ["2"], "method": "setHead"},
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["4"], "method": "setHead"},
    {"arguments": ["6"], "method": "setTail"},
    {"arguments": ["6", "3"], "method": "insertBefore"},
    {"arguments": ["6", "3-2"], "method": "insertAfter"},
    {"arguments": [1, "3-3"], "method": "insertAtPosition"},
    {"arguments": [3], "method": "removeNodesWithValue"},
    {"arguments": ["2"], "method": "remove"},
    {"arguments": [5], "method": "containsNodeWithValue"}
  ]
}
Test Case 2
{
  "nodes": [{"id": "1", "next": null, "prev": null, "value": 1}],
  "classMethodsToCall": [{"arguments": ["1"], "method": "setHead"}]
}
Test Case 3
{
  "nodes": [{"id": "1", "next": null, "prev": null, "value": 1}],
  "classMethodsToCall": [{"arguments": ["1"], "method": "setTail"}]
}
Test Case 4
{
  "nodes": [{"id": "1", "next": null, "prev": null, "value": 1}],
  "classMethodsToCall": [{"arguments": [1, "1"], "method": "insertAtPosition"}]
}
Test Case 5
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["2"], "method": "setTail"}
  ]
}
Test Case 6
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["2"], "method": "setHead"}
  ]
}
Test Case 7
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"}
  ]
}
Test Case 8
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertBefore"}
  ]
}
Test Case 9
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"}
  ]
}
Test Case 10
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setTail"},
    {"arguments": ["1", "2"], "method": "insertBefore"},
    {"arguments": ["2", "3"], "method": "insertBefore"},
    {"arguments": ["3", "4"], "method": "insertBefore"}
  ]
}
Test Case 11
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["1"], "method": "setTail"}
  ]
}
Test Case 12
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setTail"},
    {"arguments": ["1", "2"], "method": "insertBefore"},
    {"arguments": ["2", "3"], "method": "insertBefore"},
    {"arguments": ["3", "4"], "method": "insertBefore"},
    {"arguments": ["1"], "method": "setHead"}
  ]
}
Test Case 13
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["2", "1"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertBefore"}
  ]
}
Test Case 14
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4},
    {"id": "5", "next": null, "prev": null, "value": 5},
    {"id": "6", "next": null, "prev": null, "value": 6},
    {"id": "7", "next": null, "prev": null, "value": 7}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["4", "5"], "method": "insertAfter"},
    {"arguments": ["5", "6"], "method": "insertAfter"},
    {"arguments": ["6", "7"], "method": "insertAfter"},
    {"arguments": [7, "1"], "method": "insertAtPosition"},
    {"arguments": [1, "1"], "method": "insertAtPosition"},
    {"arguments": [2, "1"], "method": "insertAtPosition"},
    {"arguments": [3, "1"], "method": "insertAtPosition"},
    {"arguments": [4, "1"], "method": "insertAtPosition"},
    {"arguments": [5, "1"], "method": "insertAtPosition"},
    {"arguments": [6, "1"], "method": "insertAtPosition"}
  ]
}
Test Case 15
{
  "nodes": [{"id": "1", "next": null, "prev": null, "value": 1}],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1"], "method": "remove"}
  ]
}
Test Case 16
{
  "nodes": [{"id": "1", "next": null, "prev": null, "value": 1}],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": [1], "method": "removeNodesWithValue"}
  ]
}
Test Case 17
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["1"], "method": "remove"}
  ]
}
Test Case 18
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["4"], "method": "remove"}
  ]
}
Test Case 19
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "2"], "method": "insertAfter"},
    {"arguments": ["2", "3"], "method": "insertAfter"},
    {"arguments": ["3", "4"], "method": "insertAfter"},
    {"arguments": ["2"], "method": "remove"}
  ]
}
Test Case 20
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "1-2", "next": null, "prev": null, "value": 1},
    {"id": "1-3", "next": null, "prev": null, "value": 1},
    {"id": "1-4", "next": null, "prev": null, "value": 1}
  ],
  "classMethodsToCall": [
    {"arguments": ["1"], "method": "setHead"},
    {"arguments": ["1", "1-2"], "method": "insertAfter"},
    {"arguments": ["1-2", "1-3"], "method": "insertAfter"},
    {"arguments": ["1-3", "1-4"], "method": "insertAfter"},
    {"arguments": [1], "method": "removeNodesWithValue"}
  ]
}
Test Case 21
{
  "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "1-2", "next": null, "prev": null, "value": 1},
    {"id": "1-3", "next": null, "prev": n
... (test file truncated for display)
```
