# Merge Sort

**Category:** Sorting

```
## Problem Statement

Merge Sort
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Merge Sort algorithm to sort the array.
If you're unfamiliar with Merge Sort, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.
Sample Input
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]
Hints
Hint 1
Merge Sort works by cutting an array in two halves, respectively sorting those two halves by performing some special logic, and then merging the two newly-sorted halves into one sorted
array. The respective sorting of the two halves is done by reapplying the Merge Sort algorithm / logic on each half until single-element halves are obtained; these single-element arrays
are sorted by nature and can very easily be merged back together.
Hint 2
Divide the input array in two halves by nding the middle-most index in the array and slicing the two halves around that index. Then, recursively apply Merge Sort to each half, and nally
merge them into one single, sorted array by iterating through their values and progressively adding them to the new array in ascending order.
Hint 3
Your implementation of Merge Sort almost certainly uses a lot of auxiliary space and likely does not sort the input array in place. What is the space complexity of your algorithm? Can you
implement a version of the algorithm using only one additional array of the same length as the input array, and can this version sort the input array in place?
Optimal Space & Time Complexity
Best: O(nlog(n)) time | O(n) space - where n is the length of the input array
Average: O(nlog(n)) time | O(n) space - where n is the length of the input array
Worst: O(nlog(n)) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
class Program {
// Best: O(nlog(n)) time | O(n) space
// Average: O(nlog(n)) time | O(n) space
// Worst: O(nlog(n)) time | O(n) space
public static int[] mergeSort(int[] array) {
if (array.length <= 1) {
return array;
}
int[] auxiliaryArray = array.clone();
mergeSort(array, 0, array.length - 1, auxiliaryArray);
return array;
}
public static void mergeSort(int[] mainArray, int startIdx, int endIdx, int[] auxiliaryArray) {
if (startIdx == endIdx) {
return;
}
int middleIdx = (startIdx + endIdx) / 2;
mergeSort(auxiliaryArray, startIdx, middleIdx, mainArray);
mergeSort(auxiliaryArray, middleIdx + 1, endIdx, mainArray);
doMerge(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray);
}
public static void doMerge(
int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
int k = startIdx;
int i = startIdx;
int j = middleIdx + 1;
while (i <= middleIdx && j <= endIdx) {
if (auxiliaryArray[i] <= auxiliaryArray[j]) {
mainArray[k++] = auxiliaryArray[i++];
} else {
mainArray[k++] = auxiliaryArray[j++];
}
}
while (i <= middleIdx) {
mainArray[k++] = auxiliaryArray[i++];
}
while (j <= endIdx) {
mainArray[k++] = auxiliaryArray[j++];
}
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.Arrays;
4
5 class Program {
6 // Best: O(nlog(n)) time | O(nlog(n)) space
7 // Average: O(nlog(n)) time | O(nlog(n)) space
8 // Worst: O(nlog(n)) time | O(nlog(n)) space
9 public static int[] mergeSort(int[] array) {
10 if (array.length <= 1) {
11 return array;
12 }
13 int middleIdx = array.length / 2;
14 int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
15 int[] rightHalf = Arrays.copyOfRange(array, middleIdx, array.length);
16 return mergeSortedArrays(mergeSort(leftHalf), mergeSort(rightHalf));
17 }
18
19 public static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf) {
20 int[] sortedArray = new int[leftHalf.length + rightHalf.length];
21 int k = 0;
22 int i = 0;
23 int j = 0;
24 while (i < leftHalf.length && j < rightHalf.length) {
25 if (leftHalf[i] <= rightHalf[j]) {
26 sortedArray[k++] = leftHalf[i++];
27 } else {
28 sortedArray[k++] = rightHalf[j++];
29 }
30 }
31 while (i < leftHalf.length) {
32 sortedArray[k++] = leftHalf[i++];
33 }
34 while (j < rightHalf.length) {
35 sortedArray[k++] = rightHalf[j++];
36 }
37 return sortedArray;
38 }
39 }
40

```
---

## Test Cases

```
Test Case 1
{"array": [8, 5, 2, 9, 5, 6, 3]}
Test Case 2
{"array": [1]}
Test Case 3
{"array": [1, 2]}
Test Case 4
{"array": [2, 1]}
Test Case 5
{"array": [1, 3, 2]}
Test Case 6
{"array": [3, 1, 2]}
Test Case 7
{"array": [1, 2, 3]}
Test Case 8
{
  "array": [
    -4,
    5,
    10,
    8,
    -10,
    -6,
    -4,
    -2,
    -5,
    3,
    5,
    -4,
    -5,
    -1,
    1,
    6,
    -7,
    -6,
    -7,
    8
  ]
}
Test Case 9
{"array": [-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8]}
Test Case 10
{
  "array": [
    8,
    -6,
    7,
    10,
    8,
    -1,
    6,
    2,
    4,
    -5,
    1,
    10,
    8,
    -10,
    -9,
    -10,
    8,
    9,
    -2,
    7,
    -2,
    4
  ]
}
Test Case 11
{"array": [5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1]}
Test Case 12
{
  "array": [
    2,
    -2,
    -6,
    -10,
    10,
    4,
    -8,
    -1,
    -8,
    -4,
    7,
    -4,
    0,
    9,
    -9,
    0,
    -9,
    -9,
    8,
    1,
    -4,
    4,
    8,
    5,
    1,
    5,
    0,
    0,
    2,
    -10
  ]
}
Test Case 13
{
  "array": [
    4,
    1,
    5,
    0,
    -9,
    -3,
    -3,
    9,
    3,
    -4,
    -9,
    8,
    1,
    -3,
    -7,
    -4,
    -9,
    -1,
    -7,
    -2,
    -7,
    4
  ]
}
Test Case 14
{
  "array": [
    427,
    787,
    222,
    996,
    -359,
    -614,
    246,
    230,
    107,
    -706,
    568,
    9,
    -246,
    12,
    -764,
    -212,
    -484,
    603,
    934,
    -848,
    -646,
    -991,
    661,
    -32,
    -348,
    -474,
    -439,
    -56,
    507,
    736,
    635,
    -171,
    -215,
    564,
    -710,
    710,
    565,
    892,
    970,
    -755,
    55,
    821,
    -3,
    -153,
    240,
    -160,
    -610,
    -583,
    -27,
    131
  ]
}
Test Case 15
{
  "array": [
    991,
    -731,
    -882,
    100,
    280,
    -43,
    432,
    771,
    -581,
    180,
    -382,
    -998,
    847,
    80,
    -220,
    680,
    769,
    -75,
    -817,
    366,
    956,
    749,
    471,
    228,
    -435,
    -269,
    652,
    -331,
    -387,
    -657,
    -255,
    382,
    -216,
    -6,
    -163,
    -681,
    980,
    913,
    -169,
    972,
    -523,
    354,
    747,
    805,
    382,
    -827,
    -796,
    372,
    753,
    519,
    906
  ]
}
Test Case 16
{
  "array": [
    384,
    -67,
    120,
    759,
    697,
    232,
    -7,
    -557,
    -772,
    -987,
    687,
    397,
    -763,
    -86,
    -491,
    947,
    921,
    421,
    825,
    -679,
    946,
    -562,
    -626,
    -898,
    204,
    776,
    -343,
    393,
    51,
    -796,
    -425,
    31,
    165,
    975,
    -720,
    878,
    -785,
    -367,
    -609,
    662,
    -79,
    -112,
    -313,
    -94,
    187,
    260,
    43,
    85,
    -746,
    612,
    67,
    -389,
    508,
    777,
    624,
    993,
    -581,
    34,
    444,
    -544,
    243,
    -995,
    432,
    -755,
    -978,
    515,
    -68,
    -559,
    489,
    732,
    -19,
    -489,
    737,
    924
  ]
}
Test Case 17
{
  "array": [
    544,
    -578,
    556,
    713,
    -655,
    -359,
    -810,
    -731,
    194,
    -531,
    -685,
    689,
    -279,
    -738,
    886,
    -54,
    -320,
    -500,
    738,
    445,
    -401,
    993,
    -753,
    329,
    -396,
    -924,
    -975,
    376,
    748,
    -356,
    972,
    459,
    399,
    669,
    -488,
    568,
    -702,
    551,
    763,
    -90,
    -249,
    -45,
    452,
    -917,
    394,
    195,
    -877,
    153,
    153,
    788,
    844,
    867,
    266,
    -739,
    904,
    -154,
    -947,
    464,
    343,
    -312,
    150,
    -656,
    528,
    61,
    94,
    -581
  ]
}
Test Case 18
{
  "array": [
    -19,
    759,
    168,
    306,
    270,
    -602,
    558,
    -821,
    -599,
    328,
    753,
    -50,
    -568,
    268,
    -92,
    381,
    -96,
    730,
    629,
    678,
    -837,
    351,
    896,
    63,
    -85,
    437,
    -453,
    -991,
    294,
    -384,
    -628,
    -529,
    518,
    613,
    -319,
    -519,
    -220,
    -67,
    834,
    619,
    802,
    207,
    946,
    -904,
    295,
    718,
    -740,
    -557,
    -560,
    80,
    296,
    -90,
    401,
    407,
    798,
    254,
    154,
    387,
    434,
    491,
    228,
    307,
    268,
    505,
    -415,
    -976,
    676,
    -917,
    937,
    -609,
    593,
    -36,
    881,
    607,
    121,
    -373,
    915,
    -885,
    879,
    391,
    -158,
    588,
    -641,
    -937,
    986,
    949,
    -321
  ]
}
Test Case 19
{
  "array": [
    -823,
    164,
    48,
    -987,
    323,
    399,
    -293,
    183,
    -908,
    -376,
    14,
    980,
    965,
    842,
    422,
    829,
    59,
    724,
    -415,
    -733,
    356,
    -855,
    -155,
    52,
    328,
    -544,
    -371,
    -160,
    -942,
    -51,
    700,
    -363,
    -353,
    -359,
    238,
    892,
    -730,
    -575,
    892,
    490,
    490,
    995,
    572,
    888,
    -935,
    919,
    -191,
    646,
    -120,
    125,
    -817,
    341,
    -575,
    372,
    -874,
    243,
    610,
    -36,
    -685,
    -337,
    -13,
    295,
    800,
    -950,
    -949,
    -257,
    631,
    -542,
    201,
    -796,
    157,
    950,
    540,
    -846,
    -265,
    746,
    355,
    -578,
    -441,
    -254,
    -941,
    -738,
    -469,
    -167,
    -420,
    -126,
    -410,
    59
  ]
}

