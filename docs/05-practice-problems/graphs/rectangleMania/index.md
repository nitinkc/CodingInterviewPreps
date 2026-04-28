# Rectangle Mania

**Category:** Graphs

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2 Solution 3
}
return rectangleCount;
}
public static int clockwiseCountRectangles(
Point coord1,
Map<String, Map<Integer, List<Point>>> coordsTable,
String direction,
int lowerLeftY) {
if (direction == DOWN) {
List<Point> relevantCoords = coordsTable.get("x").get(coord1.x);
for (Point coord2 : relevantCoords) {
int lowerRightY = coord2.y;
if (lowerRightY == lowerLeftY) return 1;
}
return 0;
} else {
int rectangleCount = 0;
if (direction == UP) {
List<Point> relevantCoords = coordsTable get("x") get(coord1 x);
List<Point> relevantCoords = coordsTable.get( x ).get(coord1.x);
for (Point coord2 : relevantCoords) {
boolean isAbove = coord2.y > coord1.y;
if (isAbove)
rectangleCount += clockwiseCountRectangles(coord2, coordsTable, RIGHT, lowerLeftY);
}
} else if (direction == RIGHT) {
List<Point> relevantCoords = coordsTable.get("y").get(coord1.y);
for (Point coord2 : relevantCoords) {
boolean isRight = coord2.x > coord1.x;
if (isRight)
rectangleCount += clockwiseCountRectangles(coord2, coordsTable, DOWN, lowerLeftY);
}
}
return rectangleCount;
}
}
static class Point {
public int x;
public int y;
public Point(int x, int y) {
this.x = x;
this.y = y;
}
}
}

### Solution 2

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 static String UP = "up";
7 static String RIGHT = "right";
8 static String DOWN = "down";
9
10 // O(n^2) time | O(n) space - where n is the number of coordinates
11 public static int rectangleMania(Point[] coords) {
12 Map<String, Map<Integer, List<Point>>> coordsTable = getCoordsTable(coords);
13 return getRectangleCount(coords, coordsTable);
14 }
15
16 public static Map<String, Map<Integer, List<Point>>> getCoordsTable(Point[] coords) {
17 Map<String, Map<Integer, List<Point>>> coordsTable =
18 new HashMap<String, Map<Integer, List<Point>>>();
19 coordsTable.put("x", new HashMap<Integer, List<Point>>());
20 coordsTable.put("y", new HashMap<Integer, List<Point>>());
21 for (Point coord : coords) {
22 if (!coordsTable.get("x").containsKey(coord.x)) {
23 coordsTable.get("x").put(coord.x, new ArrayList<Point>());
24 }
25 if (!coordsTable.get("y").containsKey(coord.y)) {
26 coordsTable.get("y").put(coord.y, new ArrayList<Point>());
27 }
28 coordsTable.get("x").get(coord.x).add(coord);
29 coordsTable.get("y").get(coord.y).add(coord);
30 }
31 return coordsTable;
32 }
33
34 public static int getRectangleCount(
35 Point[] coords, Map<String, Map<Integer, List<Point>>> coordsTable) {
36 int rectangleCount = 0;
37 for (Point coord : coords) {
38 int lowerLeftY = coord.y;
39 rectangleCount += clockwiseCountRectangles(coord, coordsTable, UP, lowerLeftY);
40 }
41 return rectangleCount;
42 }
43
44 public static int clockwiseCountRectangles(
45 Point coord1,

### Solution 3

```
Solution 1 Solution 2 Solution 3
import java.util.*;
class Program {
// O(n^2) time | O(n) space - where n is the number of coordinates
public static int rectangleMania(Point[] coords) {
Set<String> coordsTable = getCoordsTable(coords);
return getRectangleCount(coords, coordsTable);
}
public static Set<String> getCoordsTable(Point[] coords) {
Set<String> coordsTable = new HashSet<String>();
for (Point coord : coords) {
String coordString = coordToString(coord);
coordsTable.add(coordString);
}
return coordsTable;
}
public static int getRectangleCount(Point[] coords, Set<String> coordsTable) {
int rectangleCount = 0;
for (Point coord1 : coords) {
for (Point coord2 : coords) {
if (!isInUpperRight(coord1, coord2)) continue;
String upperCoordString = coordToString(new Point(coord1.x, coord2.y));
String rightCoordString = coordToString(new Point(coord2.x, coord1.y));
if (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString))
rectangleCount++;
}
}
return rectangleCount;
}
public static boolean isInUpperRight(Point coord1, Point coord2) {
return coord2.x > coord1.x && coord2.y > coord1.y;
}
public static String coordToString(Point coord) {
return Integer.toString(coord.x) + "-" + Integer.toString(coord.y);
}
static class Point {
public int x;
public int y;

### Solution 4

```
Solution 1 Solution 2 Solution 3
47 } else if (coord2.y < coord1.y) {
48 return DOWN;
49 }
50 }
51 return "";
52 }
53
54 public static int getRectangleCount(
55 Point[] coords, Map<String, Map<String, List<Point>>> coordsTable) {
56 int rectangleCount = 0;
57 for (Point coord : coords) {
58 rectangleCount += clockwiseCountRectangles(coord, coordsTable, UP, coord);
59 }
60 return rectangleCount;
61 }
62
63 public static int clockwiseCountRectangles(
64 Point coord,
65 Map<String, Map<String, List<Point>>> coordsTable,
66 String direction,
67 Point origin) {
68 String coordString = coordToString(coord);
69 if (direction == LEFT) {
70 boolean rectangleFound = coordsTable.get(coordString).get(LEFT).contains(origin);
71 return rectangleFound ? 1 : 0;
72 } else {
73 int rectangleCount = 0;
74 String nextDirection = getNextClockwiseDirection(direction);
75 for (Point nextCoord : coordsTable.get(coordString).get(direction)) {
76 rectangleCount += clockwiseCountRectangles(nextCoord, coordsTable, nextDirection, origin);
77 }
78 return rectangleCount;
79 }
80 }
81
82 public static String getNextClockwiseDirection(String direction) {
83 if (direction == UP) return RIGHT;
84 if (direction == RIGHT) return DOWN;
85 if (direction == DOWN) return LEFT;
86 return "";
87 }
88
89 public static String coordToString(Point coord) {
90 return Integer.toString(coord.x) + "-" + Integer.toString(coord.y);
91 }
92
93 static class Point {
94 public int x;
95 public int y;
96
97 public Point(int x, int y) {
98 this.x = x;
99 this.y = y;
100 }
101
102 public boolean equals(Object a) {
103 return this.x == ((Point) a).x && this.y == ((Point) a).y;
104 }
105 }
106 }

### Solution 5

```
Solution 1 Solution 2 Solution 3
import java.util.*;
class Program {
// O(n^2) time | O(n) space - where n is the number of coordinates
public static int rectangleMania(Point[] coords) {
Set<String> coordsTable = getCoordsTable(coords);
return getRectangleCount(coords, coordsTable);
}
public static Set<String> getCoordsTable(Point[] coords) {
Set<String> coordsTable = new HashSet<String>();
for (Point coord : coords) {
String coordString = coordToString(coord);
coordsTable.add(coordString);
}
return coordsTable;
}
public static int getRectangleCount(Point[] coords, Set<String> coordsTable) {
int rectangleCount = 0;
for (Point coord1 : coords) {
for (Point coord2 : coords) {
if (!isInUpperRight(coord1, coord2)) continue;
String upperCoordString = coordToString(new Point(coord1.x, coord2.y));
String rightCoordString = coordToString(new Point(coord2.x, coord1.y));
if (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString))
rectangleCount++;
}
}
return rectangleCount;
}
public static boolean isInUpperRight(Point coord1, Point coord2) {
return coord2.x > coord1.x && coord2.y > coord1.y;
}
public static String coordToString(Point coord) {
return Integer.toString(coord.x) + "-" + Integer.toString(coord.y);
}
static class Point {
public int x;
public int y;
public Point(int x, int y) {
this.x = x;
this.y = y;
}
}
}

### Solution 6

```
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 static String UP = "up";
7 static String RIGHT = "right";
8 static String DOWN = "down";
9 static String LEFT = "left";
10
11 // O(n^2) time | O(n^2) space - where n is the number of coordinates
12 public static int rectangleMania(Point[] coords) {
13 Map<String, Map<String, List<Point>>> coordsTable = getCoordsTable(coords);
14 return getRectangleCount(coords, coordsTable);
15 }
16
17 public static Map<String, Map<String, List<Point>>> getCoordsTable(Point[] coords) {
18 Map<String, Map<String, List<Point>>> coordsTable =
19 new HashMap<String, Map<String, List<Point>>>();
20 for (Point coord1 : coords) {
21 Map<String, List<Point>> coord1Directions = new HashMap<String, List<Point>>();
22 coord1Directions.put(UP, new ArrayList<Point>());
23 coord1Directions.put(RIGHT, new ArrayList<Point>());
24 coord1Directions.put(DOWN, new ArrayList<Point>());
25 coord1Directions.put(LEFT, new ArrayList<Point>());
26 for (Point coord2 : coords) {
27 String coord2Direction = getCoordDirection(coord1, coord2);
28 if (coord1Directions.containsKey(coord2Direction))
29 coord1Directions.get(coord2Direction).add(coord2);
30 }
31 String coord1String = coordToString(coord1);
32 coordsTable.put(coord1String, coord1Directions);
33 }
34 return coordsTable;
35 }
36
37 public static String getCoordDirection(Point coord1, Point coord2) {
38 if (coord2.y == coord1.y) {
39 if (coord2.x > coord1.x) {
40 return RIGHT;
41 } else if (coord2.x < coord1.x) {
42 return LEFT;
43 }
44 } else if (coord2.x == coord1.x) {
45 if (coord2.y > coord1.y) {

### Solution 7

4/24/2020 | Ace the Coding Interviews
Prompt Scratchpad Our Solution(s) Video Explanation Run Code
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 // O(n^2) time | O(n) space - where n is the number of coordinates
7 public static int rectangleMania(Point[] coords) {
8 Set<String> coordsTable = getCoordsTable(coords);
9 return getRectangleCount(coords, coordsTable);
10 }
11
12 public static Set<String> getCoordsTable(Point[] coords) {
13 Set<String> coordsTable = new HashSet<String>();
14 for (Point coord : coords) {
15 String coordString = coordToString(coord);
16 coordsTable.add(coordString);
17 }
18 return coordsTable;
19 }
20
21 public static int getRectangleCount(Point[] coords, Set<String> coordsTable) {
22 int rectangleCount = 0;
23 for (Point coord1 : coords) {
24 for (Point coord2 : coords) {
25 if (!isInUpperRight(coord1, coord2)) continue;
26 String upperCoordString = coordToString(new Point(coord1.x, coord2.y));
27 String rightCoordString = coordToString(new Point(coord2.x, coord1.y));
28 if (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString))
29 rectangleCount++;
30 }
31 }
32 return rectangleCount;
33 }
34
35 public static boolean isInUpperRight(Point coord1, Point coord2) {
36 return coord2.x > coord1.x && coord2.y > coord1.y;
37 }
38
39 public static String coordToString(Point coord) {
https://www..io/questions/Rectangle Mania 1/2
4/24/2020 | Ace the Coding Interviews
https://www..io/questions/Rectangle Mania 2/2

### Solution 8

4/24/2020 | Ace the Coding Interviews
Prompt Scratchpad Our Solution(s) Video Explanation Run Code
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 static String UP = "up";
7 static String RIGHT = "right";
8 static String DOWN = "down";
9
10 // O(n^2) time | O(n) space - where n is the number of coordinates
11 public static int rectangleMania(Point[] coords) {
12 Map<String, Map<Integer, List<Point>>> coordsTable = getCoordsTable(coords);
13 return getRectangleCount(coords, coordsTable);
14 }
15
16 public static Map<String, Map<Integer, List<Point>>> getCoordsTable(Point[] coords) {
17 Map<String, Map<Integer, List<Point>>> coordsTable =
18 new HashMap<String, Map<Integer, List<Point>>>();
19 coordsTable.put("x", new HashMap<Integer, List<Point>>());
20 coordsTable.put("y", new HashMap<Integer, List<Point>>());
21 for (Point coord : coords) {
22 if (!coordsTable.get("x").containsKey(coord.x)) {
23 coordsTable.get("x").put(coord.x, new ArrayList<Point>());
24 }
25 if (!coordsTable.get("y").containsKey(coord.y)) {
26 coordsTable.get("y").put(coord.y, new ArrayList<Point>());
27 }
28 coordsTable.get("x").get(coord.x).add(coord);
29 coordsTable.get("y").get(coord.y).add(coord);
30 }
31 return coordsTable;
32 }
33
34 public static int getRectangleCount(
35 Point[] coords, Map<String, Map<Integer, List<Point>>> coordsTable) {
36 int rectangleCount = 0;
37 for (Point coord : coords) {
38 int lowerLeftY = coord.y;
39 rectangleCount += clockwiseCountRectangles(coord, coordsTable, UP, lowerLeftY);
https://www..io/questions/Rectangle Mania 1/2
4/24/2020 | Ace the Coding Interviews
https://www..io/questions/Rectangle Mania 2/2

### Solution 9

4/24/2020 | Ace the Coding Interviews
Prompt Scratchpad Our Solution(s) Video Explanation Run Code
Solution 1 Solution 2 Solution 3
2
3 import java.util.*;
4
5 class Program {
6 static String UP = "up";
7 static String RIGHT = "right";
8 static String DOWN = "down";
9 static String LEFT = "left";
10
11 // O(n^2) time | O(n^2) space - where n is the number of coordinates
12 public static int rectangleMania(Point[] coords) {
13 Map<String, Map<String, List<Point>>> coordsTable = getCoordsTable(coords);
14 return getRectangleCount(coords, coordsTable);
15 }
16
17 public static Map<String, Map<String, List<Point>>> getCoordsTable(Point[] coords) {
18 Map<String, Map<String, List<Point>>> coordsTable =
19 new HashMap<String, Map<String, List<Point>>>();
20 for (Point coord1 : coords) {
21 Map<String, List<Point>> coord1Directions = new HashMap<String, List<Point>>();
22 coord1Directions.put(UP, new ArrayList<Point>());
23 coord1Directions.put(RIGHT, new ArrayList<Point>());
24 coord1Directions.put(DOWN, new ArrayList<Point>());
25 coord1Directions.put(LEFT, new ArrayList<Point>());
26 for (Point coord2 : coords) {
27 String coord2Direction = getCoordDirection(coord1, coord2);
28 if (coord1Directions.containsKey(coord2Direction))
29 coord1Directions.get(coord2Direction).add(coord2);
30 }
31 String coord1String = coordToString(coord1);
32 coordsTable.put(coord1String, coord1Directions);
33 }
34 return coordsTable;
35 }
36
37 public static String getCoordDirection(Point coord1, Point coord2) {
38 if (coord2.y == coord1.y) {
39 if (coord2.x > coord1.x) {
40 return RIGHT;
41 } else if (coord2.x < coord1.x) {
42 return LEFT;
43 }
44 } else if (coord2.x == coord1.x) {
45 if (coord2.y > coord1.y) {
46 return UP;
https://www..io/questions/Rectangle Mania 1/2
4/24/2020 | Ace the Coding Interviews
47 } else if (coord2.y < coord1.y) {
48 return DOWN;
49 }
50 }
51 return "";
52 }
53
54 public static int getRectangleCount(
55 Point[] coords, Map<String, Map<String, List<Point>>> coordsTable) {
56 int rectangleCount = 0;
57 for (Point coord : coords) {
58 rectangleCount += clockwiseCountRectangles(coord, coordsTable, UP, coord);
59 }
60 return rectangleCount;
61 }
https://www..io/questions/Rectangle Mania 2/2

```
---

## Test Cases

```
Test Case 1
{"coords": [[0, 0], [0, 1], [1, 1], [1, 0], [2, 1], [2, 0], [3, 1], [3, 0]]}
Test Case 2
{"coords": [[0, 0], [0, 1], [1, 1], [1, 0]]}
Test Case 3
{"coords": [[0, 0], [0, 1], [1, 1], [1, 0], [2, 1], [2, 0]]}
Test Case 4
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 1],
    [2, 0],
    [3, 1],
    [3, 0],
    [1, 3],
    [3, 3]
  ]
}
Test Case 5
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 1],
    [2, 0],
    [3, 1],
    [3, 0],
    [1, 3],
    [3, 3],
    [0, -4],
    [3, -4]
  ]
}
Test Case 6
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 1],
    [2, 0],
    [3, 1],
    [3, 0],
    [1, 3],
    [3, 3],
    [0, -4],
    [3, -4],
    [1, -3],
    [3, -3]
  ]
}
Test Case 7
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 1],
    [2, 0],
    [3, 1],
    [3, 0],
    [1, 3],
    [3, 3],
    [0, -4],
    [3, -4],
    [1, -3],
    [3, -3],
    [-1, 0],
    [-10, 0],
    [-1, -1],
    [2, -2]
  ]
}
Test Case 8
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 1],
    [2, 0],
    [3, 1],
    [3, 0],
    [1, 3],
    [3, 3],
    [0, -4],
    [3, -4],
    [1, -3],
    [3, -3],
    [-1, 0],
    [-10, 0],
    [-1, -1],
    [2, -2],
    [0, -1],
    [1, -4],
    [-10, -4]
  ]
}
Test Case 9
{
  "coords": [
    [0, 0],
    [0, 1],
    [1, 0],
    [2, 1],
    [1, 3],
    [3, 3],
    [0, -4],
    [3, -5],
    [1, -3],
    [3, -2],
    [-1, 0],
    [-10, 0],
    [-1, -1],
    [2, -2]
  ]
}
Test Case 10
{"coords": [[0, 0], [0, 1], [1, 1]]}

