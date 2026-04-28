# Single Cycle Check

**Category:** Graphs

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```java
class Program {
// O(n) time | O(1) space - where n is the length of the input array
public static boolean hasSingleCycle(int[] array) {
int numElementsVisited = 0;
int currentIdx = 0;
while (numElementsVisited < array.length) {
if (numElementsVisited > 0 && currentIdx == 0) return false;
numElementsVisited++;
currentIdx = getNextIdx(currentIdx, array);
}
return currentIdx == 0;
}
public static int getNextIdx(int currentIdx, int[] array) {
int jump = array[currentIdx];
int nextIdx = (currentIdx + jump) % array.length;
return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
}
}

```
---

## Test Cases

```
Video Solution
Video Solution

```
Test Case 1
{"array": [2, 3, 1, -4, -4, 2]}
Test Case 2
{"array": [2, 2, -1]}
Test Case 3
{"array": [2, 2, 2]}
Test Case 4
{"array": [1, 1, 1, 1, 1]}
Test Case 5
{"array": [-1, 2, 2]}
Test Case 6
{"array": [0, 1, 1, 1, 1]}
Test Case 7
{"array": [1, 1, 0, 1, 1]}
Test Case 8
{"array": [1, 1, 1, 1, 2]}
Test Case 9
{"array": [3, 5, 6, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]}
Test Case 10
{"array": [3, 5, 5, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]}
Test Case 11
{"array": [1, 2, 3, 4, -2, 3, 7, 8, 1]}
Test Case 12
{"array": [1, 2, 3, 4, -2, 3, 7, 8, -8]}
Test Case 13
{"array": [1, 2, 3, 4, -2, 3, 7, 8, -26]}
Test Case 14
{"array": [10, 11, -6, -23, -2, 3, 88, 908, -26]}
Test Case 15
{"array": [10, 11, -6, -23, -2, 3, 88, 909, -26]}
Test Case 16
{"array": [1, -1, 1, -1]}

