# Lowest Common Manager

**Category:** Recursion

```
## Problem Statement

Lowest Common Manager
You're given three inputs, all of which are instances of an OrgChart class that have a directReports property pointing to their direct reports. The rst input is the top manager in an
organizational chart (i.e., the only instance that isn't anybody else's direct report), and the other two inputs are reports in the organizational chart.
Write a function that returns the lowest common manager to the two reports.
Sample Input
// From the organizational chart below.
topManager = Node A
reportOne = Node E
reportTwo = Node I
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
Given a random subtree in the organizational chart, the manager at the root of that subtree is common to any two reports in the subtree.
Hint 2
Knowing Hint #1, the lowest common manager to two reports in an organizational chart is the root of the lowest subtree containing those two reports. Find that lowest subtree to nd
the lowest common manager.
Hint 3
To nd the lowest subtree containing both of the input reports, try recursively traversing the organizational chart and keeping track of the number of those reports contained in each
subtree as well as the lowest common manager in each subtree. Some subtrees might contain neither of the two reports, some might contain one of them, and others might contain
both; the rst to contain both should return the lowest common manager for all of the subtrees above it that contain it, including the entire organizational chart.
Optimal Space & Time Complexity
O(n) time | O(d) space - where n is the number of people in the org and d is the depth (height) of the org chart

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(d) space - where n is the number of people
// in the org and d is the depth (height) of the org chart
public static OrgChart getLowestCommonManager(
OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
}
public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
int numImportantReports = 0;
for (OrgChart directReport : manager.directReports) {
OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
if (orgInfo.lowestCommonManager != null) return orgInfo;
numImportantReports += orgInfo.numImportantReports;
}
if (manager == reportOne || manager == reportTwo) numImportantReports++;
OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, numImportantReports);
return newOrgInfo;
}
static class OrgChart {
public char name;
public List<OrgChart> directReports;
OrgChart(char name) {
this.name = name;
this.directReports = new ArrayList<OrgChart>();
}
// This method is for testing only.
public void addDirectReports(OrgChart[] directReports) {
for (OrgChart directReport : directReports) {
this.directReports.add(directReport);
} CSuusbtommit O Cuotdpeut
}
}
static class OrgInfo {
public OrgChart lowestCommonManager;
int numImportantReports;
OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
this.lowestCommonManager = lowestCommonManager;
this.numImportantReports = numImportantReports;
}
}
}
Run or s
when yo

```
---

## Test Cases

```
Test Case 1
{
  "topManager": "A",
  "reportOne": "E",
  "reportTwo": "I",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C"], "id": "A", "name": "A"},
      {"directReports": ["D", "E"], "id": "B", "name": "B"},
      {"directReports": ["F", "G"], "id": "C", "name": "C"},
      {"directReports": ["H", "I"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": [], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": [], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"}
    ]
  }
}
Test Case 2
{
  "topManager": "A",
  "reportOne": "A",
  "reportTwo": "B",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
      {"directReports": ["T", "U"], "id": "P", "name": "P"},
      {"directReports": [], "id": "Q", "name": "Q"},
      {"directReports": ["V"], "id": "R", "name": "R"},
      {"directReports": [], "id": "S", "name": "S"},
      {"directReports": [], "id": "T", "name": "T"},
      {"directReports": [], "id": "U", "name": "U"},
      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
      {"directReports": [], "id": "W", "name": "W"},
      {"directReports": ["Z"], "id": "X", "name": "X"},
      {"directReports": [], "id": "Y", "name": "Y"},
      {"directReports": [], "id": "Z", "name": "Z"}
    ]
  }
}
Test Case 3
{
  "topManager": "A",
  "reportOne": "B",
  "reportTwo": "F",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
      {"directReports": ["T", "U"], "id": "P", "name": "P"},
      {"directReports": [], "id": "Q", "name": "Q"},
      {"directReports": ["V"], "id": "R", "name": "R"},
      {"directReports": [], "id": "S", "name": "S"},
      {"directReports": [], "id": "T", "name": "T"},
      {"directReports": [], "id": "U", "name": "U"},
      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
      {"directReports": [], "id": "W", "name": "W"},
      {"directReports": ["Z"], "id": "X", "name": "X"},
      {"directReports": [], "id": "Y", "name": "Y"},
      {"directReports": [], "id": "Z", "name": "Z"}
    ]
  }
}
Test Case 4
{
  "topManager": "A",
  "reportOne": "G",
  "reportTwo": "M",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
      {"directReports": ["T", "U"], "id": "P", "name": "P"},
      {"directReports": [], "id": "Q", "name": "Q"},
      {"directReports": ["V"], "id": "R", "name": "R"},
      {"directReports": [], "id": "S", "name": "S"},
      {"directReports": [], "id": "T", "name": "T"},
      {"directReports": [], "id": "U", "name": "U"},
      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
      {"directReports": [], "id": "W", "name": "W"},
      {"directReports": ["Z"], "id": "X", "name": "X"},
      {"directReports": [], "id": "Y", "name": "Y"},
      {"directReports": [], "id": "Z", "name": "Z"}
    ]
  }
}
Test Case 5
{
  "topManager": "A",
  "reportOne": "U",
  "reportTwo": "S",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
      {"directReports": ["T", "U"], "id": "P", "name": "P"},
      {"directReports": [], "id": "Q", "name": "Q"},
      {"directReports": ["V"], "id": "R", "name": "R"},
      {"directReports": [], "id": "S", "name": "S"},
      {"directReports": [], "id": "T", "name": "T"},
      {"directReports": [], "id": "U", "name": "U"},
      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
      {"directReports": [], "id": "W", "name": "W"},
      {"directReports": ["Z"], "id": "X", "name": "X"},
      {"directReports": [], "id": "Y", "name": "Y"},
      {"directReports": [], "id": "Z", "name": "Z"}
    ]
  }
}
Test Case 6
{
  "topManager": "A",
  "reportOne": "Z",
  "reportTwo": "M",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
      {"directReports": ["T", "U"], "id": "P", "name": "P"},
      {"directReports": [], "id": "Q", "name": "Q"},
      {"directReports": ["V"], "id": "R", "name": "R"},
      {"directReports": [], "id": "S", "name": "S"},
      {"directReports": [], "id": "T", "name": "T"},
      {"directReports": [], "id": "U", "name": "U"},
      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
      {"directReports": [], "id": "W", "name": "W"},
      {"directReports": ["Z"], "id": "X", "name": "X"},
      {"directReports": [], "id": "Y", "name": "Y"},
      {"directReports": [], "id": "Z", "name": "Z"}
    ]
  }
}
Test Case 7
{
  "topManager": "A",
  "reportOne": "O",
  "reportTwo": "I",
  "orgChart": {
    "nodes": [
      {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
      {"directReports": ["J"], "id": "C", "name": "C"},
      {"directReports": ["K", "L"], "id": "D", "name": "D"},
      {"directReports": [], "id": "E", "name": "E"},
      {"directReports": ["M", "N"], "id": "F", "name": "F"},
      {"directReports": [], "id": "G", "name": "G"},
      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
      {"directReports": [], "id": "I", "name": "I"},
      {"directReports": [], "id": "J", "name": "J"},
      {"directReports": ["S"], "id": "K", "name": "K"},
      {"directReports": [], "id": "L", "name": "L"},
      {"directReports": [], "id": "M", "name": "M"},
      {"directReports": [], "id": "N", "name": "N"},
      {"directReports": [], "id": "O", "name": "O"},
 
... (test file truncated for display)
```
