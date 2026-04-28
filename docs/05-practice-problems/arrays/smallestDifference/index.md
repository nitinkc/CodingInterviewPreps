# Smallest Difference

**Category:** Arrays

```
## Problem Statement

Smallest Dierence
Write a function that takes in two non-empty arrays of integers, nds the pair of numbers (one from each array) whose absolute dierence is closest to zero, and returns an
array containing these two numbers, with the number from the rst array in the rst position.
You can assume that there will only be one pair of numbers with the smallest dierence.
Sample Input
arrayOne = [-1, 5, 10, 20, 28, 3]
arrayTwo = [26, 134, 135, 15, 17]
Sample Output
[28, 26]
Hints
Hint 1
Instead of generating all possible pairs of numbers, try somehow only looking at pairs that you know could actually have the smallest dierence. How can you
accomplish this?
Hint 2
Would it help if the two arrays were sorted? If the arrays were sorted and you were looking at a given pair of numbers, could you eciently nd the next pair of numbers
to look at? What are the runtime implications of sorting the arrays?
Hint 3
Start by sorting both arrays, as per Hint #2. Put a pointer at the beginning of both arrays and evaluate the absolute dierence of the pointer-numbers. If the dierence is
equal to zero, then you've found the closest pair; otherwise, increment the pointer of the smaller of the two numbers to nd a potentially better pair. Continue until you
get a pair with a dierence of zero or until one of the pointers gets out of range of its array.
Optimal Space & Time Complexity
O(nlog(n) + mlog(m)) time | O(1) space - where n is the length of the rst input array and m is the length of the second input array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.Arrays;
class Program {
// O(nlog(n) + mlog(m)) time | O(1) space
public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
Arrays.sort(arrayOne);
Arrays.sort(arrayTwo);
int idxOne = 0;
int idxTwo = 0;
int smallest = Integer.MAX_VALUE;
int current = Integer.MAX_VALUE;
int[] smallestPair = new int[2];
while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
int firstNum = arrayOne[idxOne];
int secondNum = arrayTwo[idxTwo];
if (firstNum < secondNum) {
current = secondNum - firstNum;
idxOne++;
} else if (secondNum < firstNum) {
current = firstNum - secondNum;
idxTwo++;
} else {
return new int[] {firstNum, secondNum};
}
if (smallest > current) {
smallest = current;
smallestPair = new int[] {firstNum, secondNum};
}
}
return smallestPair;
}
}

```
---

## Test Cases

```
​
import java.util.Arrays;
​
class Program {
  // O(nlog(n) + mlog(m)) time | O(1) space
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int idxOne = 0;
    int idxTwo = 0;
    int smallest = Integer.MAX_VALUE;
    int current = Integer.MAX_VALUE;
    int[] smallestPair = new int[2];
    while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
      int firstNum = arrayOne[idxOne];
      int secondNum = arrayTwo[idxTwo];
      if (firstNum < secondNum) {
        current = secondNum - firstNum;
        idxOne++;
      } else if (secondNum < firstNum) {
        current = firstNum - secondNum;
        idxTwo++;
      } else {
        return new int[] {firstNum, secondNum};
      }
      if (smallest > current) {
        smallest = current;
        smallestPair = new int[] {firstNum, secondNum};
      }
    }
    return smallestPair;
  }
}
​

```
Test Case 1
{"arrayOne": [-1, 5, 10, 20, 28, 3], "arrayTwo": [26, 134, 135, 15, 17]}
Test Case 2
{"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
Test Case 3
{"arrayOne": [10, 0, 20, 25], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 4
{"arrayOne": [10, 0, 20, 25, 2200], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 5
{"arrayOne": [10, 0, 20, 25, 2000], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 6
{
  "arrayOne": [240, 124, 86, 111, 2, 84, 954, 27, 89],
  "arrayTwo": [1, 3, 954, 19, 8]
}
Test Case 7
{"arrayOne": [0, 20], "arrayTwo": [21, -2]}
Test Case 8
{
  "arrayOne": [10, 1000],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}
Test Case 9
{
  "arrayOne": [10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}
Test Case 10
{
  "arrayOne": [10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123, 530],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[28, 26]
Input(s)
{"arrayOne": [-1, 5, 10, 20, 28, 3], "arrayTwo": [26, 134, 135, 15, 17]}
Test Case 2 passed!
Our Code's Output
[20, 17]
Input(s)
{"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
Test Case 3 passed!
Our Code's Output
[25, 1005]
Input(s)
{"arrayOne": [10, 0, 20, 25], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 4 passed!
Our Code's Output
[25, 1005]
Input(s)
{"arrayOne": [10, 0, 20, 25, 2200], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 5 passed!
Our Code's Output
[2000, 1032]
Input(s)
{"arrayOne": [10, 0, 20, 25, 2000], "arrayTwo": [1005, 1006, 1014, 1032, 1031]}
Test Case 6 passed!
Our Code's Output
[954, 954]
Input(s)
{
  "arrayOne": [240, 124, 86, 111, 2, 84, 954, 27, 89],
  "arrayTwo": [1, 3, 954, 19, 8]
}
Test Case 7 passed!
Our Code's Output
[20, 21]
Input(s)
{"arrayOne": [0, 20], "arrayTwo": [21, -2]}
Test Case 8 passed!
Our Code's Output
[1000, 1014]
Input(s)
{
  "arrayOne": [10, 1000],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}
Test Case 9 passed!
Our Code's Output
[-123, -124]
Input(s)
{
  "arrayOne": [10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}
Test Case 10 passed!
Our Code's Output
[530, 530]
Input(s)
{
  "arrayOne": [10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123, 530],
  "arrayTwo": [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]
}

```
