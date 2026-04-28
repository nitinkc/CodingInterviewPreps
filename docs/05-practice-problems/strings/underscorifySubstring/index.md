# Underscorify Substring

**Category:** Strings

```
## Problem Statement

(Problem statement not extracted)

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n*m) | O(n) space
public static String underscorifySubstring(String str, String substring) {
List<Integer[]> locations = collapse(getLocations(str, substring));
return underscorify(str, locations);
}
public static List<Integer[]> getLocations(String str, String substring) {
List<Integer[]> locations = new ArrayList<Integer[]>();
int startIdx = 0;
while (startIdx < str.length()) {
int nextIdx = str.indexOf(substring, startIdx);
if (nextIdx != -1) {
locations.add(new Integer[] {nextIdx, nextIdx + substring.length()});
startIdx = nextIdx + 1;
} else {
break;
}
}
return locations;
}
public static List<Integer[]> collapse(List<Integer[]> locations) {
if (locations.size() == 0) {
return locations;
}
List<Integer[]> newLocations = new ArrayList<Integer[]>();
newLocations.add(locations.get(0));
Integer[] previous = newLocations.get(0);
for (int i = 1; i < locations.size(); i++) {
Integer[] current = locations.get(i);
if (current[0] <= previous[1]) {
previous[1] = current[1];
} else {
newLocations.add(current);
previous = current;
}
}
return newLocations;
}
public static String underscorify(String str, List<Integer[]> locations) {
int locationsIdx = 0;
int stringIdx = 0;
boolean inBetweenUnderscores = false;
List<String> finalChars = new ArrayList<String>();
int i = 0;
while (stringIdx < str.length() && locationsIdx < locations.size()) {
if (stringIdx == locations.get(locationsIdx)[i]) {
finalChars.add("_");
inBetweenUnderscores = !inBetweenUnderscores;
if (!inBetweenUnderscores) {
locationsIdx++;
}
i = i == 1 ? 0 : 1;
}
finalChars.add(String.valueOf(str.charAt(stringIdx)));
stringIdx += 1;
}
if (locationsIdx < locations.size()) {
finalChars.add("_");
} else if (stringIdx < str.length()) {
finalChars.add(str.substring(stringIdx));
}
return String.join("", finalChars);
}
}

```
---

## Test Cases

```
Test Case 1
{
  "string": "testthis is a testtest to see if testestest it works",
  "substring": "test"
}
Test Case 2
{"string": "this is a test to see if it works", "substring": "test"}
Test Case 3
{"string": "test this is a test to see if it works", "substring": "test"}
Test Case 4
{"string": "testthis is a test to see if it works", "substring": "test"}
Test Case 5
{
  "string": "testthis is a testest to see if testestes it works",
  "substring": "test"
}
Test Case 6
{"string": "this is a test to see if it works and test", "substring": "test"}
Test Case 7
{
  "string": "this is a test to see if it works and test",
  "substring": "bfjawkfja"
}
Test Case 8
{"string": "ttttttttttttttbtttttctatawtatttttastvb", "substring": "ttt"}
Test Case 9
{"string": "tzttztttz", "substring": "ttt"}
Test Case 10
{"string": "abababababababababababababaababaaabbababaa", "substring": "a"}
Test Case 11
{"string": "abcabcabcabcabcabcabcabcabcabcabcabcabcabc", "substring": "abc"}

