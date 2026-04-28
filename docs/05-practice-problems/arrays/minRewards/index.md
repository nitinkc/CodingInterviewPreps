# Min Rewards

**Category:** Arrays

```
## Problem Statement

Min Rewards
Imagine that you're a teacher who's just graded the nal exam in a class. You have a list of student scores on the nal exam in a particular order (not necessarily sorted), and
you want to reward your students. You decide to do so fairly by giving them arbitrary rewards following two rules:
1) All students must receive at least one reward.
2) Any given student must receive strictly more rewards than an adjacent student (a student immediately to the left or to the right) with a lower score and must receive
strictly fewer rewards than an adjacent student with a higher score.
Write a function that takes in a list of scores and returns the minimum number of rewards that you must give out to students to satisfy the two rules.
You can assume that all students have dierent scores; in other words, the scores are all unique.
Sample Input
scores = [8, 4, 2, 1, 3, 6, 7, 9, 5]
Sample Output
// you would give out the following rewards: [4, 3, 2, 1, 2, 3, 4, 5, 1]
Hints
Hint 1
You could try iterating through the input list of scores and incrementing the number of rewards you give to each student if they have a greater score than the previous
student's score. However, if you reach a student with a smaller score than the previous student's score, you'll have to backtrack through the array to x previous
reward assignments. During this backtrack, is it correct to simply increment the reward of a student whose score is greater than the next student's score?
Hint 2
Notice that there are local mins and local maxes in the input list of scores: scores that are smaller than both scores next to them and scores that are greater than both
scores next to them. Find the local mins, and try expanding away from them until you reach local maxes, assigning (and incrementing) rewards as you go.
Hint 3
Do you actually need to nd the local mins mentioned in Hint #2? Can you simply do two sweeps of the input list of scores, one from left to right, and one from right to
left?
Optimal Space & Time Complexity
O(n) time | O(n) space - where in is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3
import java.util.*;
import java.util.stream.*;
// O(n) time | O(n) space - where in is the length of the input array
class Program {
public static int minRewards(int[] scores) {
int[] rewards = new int[scores.length];
Arrays.fill(rewards, 1);
for (int i = 1; i < scores.length; i++) {
if (scores[i] > scores[i - 1]) rewards[i] = rewards[i - 1] + 1;
}
for (int i = scores.length - 2; i >= 0; i--) {
if (scores[i] > scores[i + 1]) {
rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
}
}
return IntStream.of(rewards).sum();
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4 import java.util.stream.*;
5
6 // O(n) time | O(n) space - where in is the length of the input array
7 class Program {
8 public static int minRewards(int[] scores) {
9 int[] rewards = new int[scores.length];
10 Arrays.fill(rewards, 1);
11 List<Integer> localMinIdxs = getLocalMinIdxs(scores);
12 for (Integer localMinIdx : localMinIdxs) {
13 expandFromLocalMinIdx(localMinIdx, scores, rewards);
14 }
15 return IntStream.of(rewards).sum();
16 }
17
18 public static List<Integer> getLocalMinIdxs(int[] array) {
19 List<Integer> localMinIdxs = new ArrayList<Integer>();
20 if (array.length == 1) {
21 localMinIdxs.add(0);
22 return localMinIdxs;
23 }
24 for (int i = 0; i < array.length; i++) {
25 if (i == 0 && array[i] < array[i + 1]) localMinIdxs.add(i);
26 if (i == array.length - 1 && array[i] < array[i - 1]) localMinIdxs.add(i);
27 if (i == 0 || i == array.length - 1) continue;
28 if (array[i] < array[i + 1] && array[i] < array[i - 1]) localMinIdxs.add(i);
29 }
30 return localMinIdxs;
31 }
32
33 public static void expandFromLocalMinIdx(int localMinIdx, int[] scores, int[] rewards) {
34 int leftIdx = localMinIdx - 1;
35 while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
36 rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
37 leftIdx--;
38 }
39 int rightIdx = localMinIdx + 1;

### Solution 3

```
Solution 1 Solution 2 Solution 3
import java.util.*;
import java.util.stream.*;
// O(n^2) time | O(n) space - where in is the length of the input array
class Program {
public static int minRewards(int[] scores) {
int[] rewards = new int[scores.length];
Arrays.fill(rewards, 1);
for (int i = 1; i < scores.length; i++) {
int j = i - 1;
if (scores[i] > scores[j]) {
rewards[i] = rewards[j] + 1;
} else {
while (j >= 0 && scores[j] > scores[j + 1]) {
rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
j--;
}
}
}
return IntStream.of(rewards).sum();
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
{"scores": [8, 4, 2, 1, 3, 6, 7, 9, 5]}
Test Case 2
{"scores": [1]}
Test Case 3
{"scores": [5, 10]}
Test Case 4
{"scores": [10, 5]}
Test Case 5
{"scores": [4, 2, 1, 3]}
Test Case 6
{"scores": [0, 4, 2, 1, 3]}
Test Case 7
{"scores": [2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0]}
Test Case 8
{"scores": [2, 1, 4, 3, 6, 5, 8, 7, 10, 9]}
Test Case 9
{
  "scores": [
    800,
    400,
    20,
    10,
    30,
    61,
    70,
    90,
    17,
    21,
    22,
    13,
    12,
    11,
    8,
    4,
    2,
    1,
    3,
    6,
    7,
    9,
    0,
    68,
    55,
    67,
    57,
    60,
    51,
    661,
    50,
    65,
    53
  ]
}

```
Video Solution

​
import java.util.*;
import java.util.stream.*;
​
// O(n^2) time | O(n) space - where in is the length of the input array
class Program {
  public static int minRewards(int[] scores) {
    int[] rewards = new int[scores.length];
    Arrays.fill(rewards, 1);
    for (int i = 1; i < scores.length; i++) {
      int j = i - 1;
      if (scores[i] > scores[j]) {
        rewards[i] = rewards[j] + 1;
      } else {
        while (j >= 0 && scores[j] > scores[j + 1]) {
          rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
          j--;
        }
      }
    }
    return IntStream.of(rewards).sum();
  }
}
​

```
Test Case 1
{"scores": [8, 4, 2, 1, 3, 6, 7, 9, 5]}
Test Case 2
{"scores": [1]}
Test Case 3
{"scores": [5, 10]}
Test Case 4
{"scores": [10, 5]}
Test Case 5
{"scores": [4, 2, 1, 3]}
Test Case 6
{"scores": [0, 4, 2, 1, 3]}
Test Case 7
{"scores": [2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0]}
Test Case 8
{"scores": [2, 1, 4, 3, 6, 5, 8, 7, 10, 9]}
Test Case 9
{
  "scores": [
    800,
    400,
    20,
    10,
    30,
    61,
    70,
    90,
    17,
    21,
    22,
    13,
    12,
    11,
    8,
    4,
    2,
    1,
    3,
    6,
    7,
    9,
    0,
    68,
    55,
    67,
    57,
    60,
    51,
    661,
    50,
    65,
    53
  ]
}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
Input(s)
{"scores": [8, 4, 2, 1, 3, 6, 7, 9, 5]}
Test Case 2 passed!
Our Code's Output
Input(s)
{"scores": [1]}
Test Case 3 passed!
Our Code's Output
Input(s)
{"scores": [5, 10]}
Test Case 4 passed!
Our Code's Output
Input(s)
{"scores": [10, 5]}
Test Case 5 passed!
Our Code's Output
Input(s)
{"scores": [4, 2, 1, 3]}
Test Case 6 passed!
Our Code's Output
Input(s)
{"scores": [0, 4, 2, 1, 3]}
Test Case 7 passed!
Our Code's Output
Input(s)
{"scores": [2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0]}
Test Case 8 passed!
Our Code's Output
Input(s)
{"scores": [2, 1, 4, 3, 6, 5, 8, 7, 10, 9]}
Test Case 9 passed!
Our Code's Output
Input(s)
{
  "scores": [
    800,
    400,
    20,
    10,
    30,
    61,
    70,
    90,
    17,
    21,
    22,
    13,
    12,
    11,
    8,
    4,
    2,
    1,
    3,
    6,
    7,
    9,
    0,
    68,
    55,
    67,
    57,
    60,
    51,
    661,
    50,
    65,
  ]
}

```
