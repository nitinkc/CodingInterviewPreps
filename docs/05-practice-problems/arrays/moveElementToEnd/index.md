# Move Element To End

**Category:** Arrays

```
## Problem Statement

Move Element To End
You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the end of the array and returns the array.
The function should perform this in place (i.e., it should mutate the input array) and doesn't need to maintain the order of the other integers.
Sample Input
array = [2, 1, 2, 2, 2, 3, 4, 2]
toMove = 2
Sample Output
[1, 3, 4, 2, 2, 2, 2, 2] // the numbers 1, 3, and 4 could be ordered differently
Hints
Hint 1
You can solve this problem in linear time.
Hint 2
In view of Hint #1, you can solve this problem without sorting the input array. Try setting two pointers at the start and end of the array, respectively, and progressively
moving them inwards.
Hint 3
Following Hint #2, set two pointers at the start and end of the array, respectively. Move the right pointer inwards so long as it points to the integer to move, and move
the left pointer inwards so long as it doesn't point to the integer to move. When both pointers aren't moving, swap their values in place. Repeat this process until the
pointers pass each other.
Optimal Space & Time Complexity
O(n) time | O(1) space - where n is the length of the array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(1) space - where n is the length of the array
public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
int i = 0;
int j = array.size() - 1;
while (i < j) {
while (i < j && array.get(j) == toMove) j--;
if (array.get(i) == toMove) swap(i, j, array);
i++;
}
return array;
}
public static void swap(int i, int j, List<Integer> array) {
int temp = array.get(j);
array.set(j, array.get(i));
array.set(i, temp);
}
}

```
---

## Test Cases

```
​
import java.util.*;
​
class Program {
  // O(n) time | O(1) space - where n is the length of the array
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int i = 0;
    int j = array.size() - 1;
    while (i < j) {
      while (i < j && array.get(j) == toMove) j--;
      if (array.get(i) == toMove) swap(i, j, array);
      i++;
    }
    return array;
  }
​
  public static void swap(int i, int j, List<Integer> array) {
    int temp = array.get(j);
    array.set(j, array.get(i));
    array.set(i, temp);
  }
}
​

```
Test Case 1
{"array": [2, 1, 2, 2, 2, 3, 4, 2], "toMove": 2}
Test Case 2
{"array": [], "toMove": 3}
Test Case 3
{"array": [1, 2, 4, 5, 6], "toMove": 3}
Test Case 4
{"array": [3, 3, 3, 3, 3], "toMove": 3}
Test Case 5
{"array": [3, 1, 2, 4, 5], "toMove": 3}
Test Case 6
{"array": [1, 2, 4, 5, 3], "toMove": 3}
Test Case 7
{"array": [1, 2, 3, 4, 5], "toMove": 3}
Test Case 8
{"array": [5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12], "toMove": 5}
Test Case 9
{"array": [1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5], "toMove": 5}
Test Case 10
{"array": [5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12], "toMove": 5}

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[4, 1, 3, 2, 2, 2, 2, 2]
Input(s)
{"array": [2, 1, 2, 2, 2, 3, 4, 2], "toMove": 2}
Test Case 2 passed!
Our Code's Output
[]
Input(s)
{"array": [], "toMove": 3}
Test Case 3 passed!
Our Code's Output
[1, 2, 4, 5, 6]
Input(s)
{"array": [1, 2, 4, 5, 6], "toMove": 3}
Test Case 4 passed!
Our Code's Output
[3, 3, 3, 3, 3]
Input(s)
{"array": [3, 3, 3, 3, 3], "toMove": 3}
Test Case 5 passed!
Our Code's Output
[5, 1, 2, 4, 3]
Input(s)
{"array": [3, 1, 2, 4, 5], "toMove": 3}
Test Case 6 passed!
Our Code's Output
[1, 2, 4, 5, 3]
Input(s)
{"array": [1, 2, 4, 5, 3], "toMove": 3}
Test Case 7 passed!
Our Code's Output
[1, 2, 5, 4, 3]
Input(s)
{"array": [1, 2, 3, 4, 5], "toMove": 3}
Test Case 8 passed!
Our Code's Output
[12, 11, 10, 9, 8, 7, 1, 2, 3, 4, 6, 5, 5, 5, 5, 5, 5]
Input(s)
{"array": [5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12], "toMove": 5}
Test Case 9 passed!
Our Code's Output
[1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5]
Input(s)
{"array": [1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5], "toMove": 5}
Test Case 10 passed!
Our Code's Output
[12, 1, 2, 11, 10, 3, 4, 6, 7, 9, 8, 5, 5, 5, 5, 5, 5]
Input(s)
{"array": [5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12], "toMove": 5}

```
