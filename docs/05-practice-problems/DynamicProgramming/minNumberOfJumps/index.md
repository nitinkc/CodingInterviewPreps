# Min Number Of Jumps

**Category:** Dynamic Programming

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

Solution 1 Solution 2
2
3 class Program {
4 // O(n) time | O(1) space
5 public static int minNumberOfJumps(int[] array) {
6 if (array.length == 1) {
7 return 0;
8 }
9 int jumps = 0;
10 int maxReach = array[0];
11 int steps = array[0];
12 for (int i = 1; i < array.length - 1; i++) {
13 maxReach = Math.max(maxReach, i + array[i]);
14 steps--;
15 if (steps == 0) {
16 jumps++;
17 steps = maxReach - i;
18 }
19 }
20 return jumps + 1;
21 }
22 }
23
CustomSu Obumtpitu Ctode
Run or subm
when you're

### Solution 2

Solution 1 Solution 2
2
3 import java.util.Arrays;
4
5 class Program {
6 // O(n^2) time | O(n) space
7 public static int minNumberOfJumps(int[] array) {
8 int[] jumps = new int[array.length];
9 Arrays.fill(jumps, Integer.MAX_VALUE);
10 jumps[0] = 0;
11 for (int i = 1; i < array.length; i++) {
12 for (int j = 0; j < i; j++) {
13 if (array[j] >= i - j) {
14 jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
15 }
16 }
17 }
18 return jumps[jumps.length - 1];
19 }
20 }
21
CustomSu Obumtpitu Ctode
Run or subm
when you're

```
---

## Test Cases

```
Hide

```
Test Case 1
{"array": [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]}
Test Case 2
{"array": [1]}
Test Case 3
{"array": [1, 1]}
Test Case 4
{"array": [3, 1]}
Test Case 5
{"array": [1, 1, 1]}
Test Case 6
{"array": [2, 1, 1]}
Test Case 7
{"array": [2, 1, 2, 3, 1]}
Test Case 8
{"array": [2, 1, 2, 3, 1, 1, 1]}
Test Case 9
{"array": [2, 1, 2, 2, 1, 1, 1]}
Test Case 10
{"array": [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 6, 2, 1, 1, 1, 1]}
Test Case 11
{"array": [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1]}
Test Case 12
{"array": [3, 10, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1]}
Test Case 13
{"array": [3, 12, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1]}
Test Case 14
{"array": [3, 12, 2, 1, 2, 3, 15, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1]}

