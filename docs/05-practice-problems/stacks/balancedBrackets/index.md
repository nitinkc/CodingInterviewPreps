# Balanced Brackets

**Category:** Stacks

```
## Problem Statement

Balanced Brackets
Write a function that takes in a string made up of brackets ( ( , [ , { , ) , ] , and } ) and other optional characters. The function should return a boolean representing whether the string
is balanced with regards to brackets.
A string is said to be balanced if it has as many opening brackets of a certain type as it has closing brackets of that type and if no bracket is unmatched. Note that an opening bracket can't
match a corresponding closing bracket that comes before it, and similarly, a closing bracket can't match a corresponding opening bracket that comes after it. Also, brackets can't overlap each
other as in [(]) .
Sample Input
string = "([])(){}(())()()"
Sample Output
true // it's balanced
Hints
Hint 1
If you iterate through the input string one character at a time, there are two scenarios in which the string will be unbalanced: either you run into a closing bracket with no prior matching
opening bracket or you get to the end of the string with some opening brackets that haven't been matched. Can you use an auxiliary data structure to keep track of all the brackets and
eciently check if you run into a unbalanced scenario at every iteration?
Hint 2
Consider using a stack to store opening brackets as you traverse the string. The Last-In-First-Out property of the stack should allow you to match any closing brackets that you run into
against the most recent opening bracket, if one exists, in which case you can simply pop it out of the stack. How can you check that there are no unmatched opening bracket once you've
nished traversing through the string?
Optimal Space & Time Complexity
O(n) time | O(n) space - where n is the length of the input array

```
---

## Approach & Solution

### Solution 1

```java
import java.util.*;
class Program {
// O(n) time | O(n) space
public static boolean balancedBrackets(String str) {
String openingBrackets = "([{";
String closingBrackets = ")]}";
Map<Character, Character> matchingBrackets = new HashMap<Character, Character>();
matchingBrackets.put(')', '(');
matchingBrackets.put(']', '[');
matchingBrackets.put('}', '{');
List<Character> stack = new ArrayList<Character>();
for (int i = 0; i < str.length(); i++) {
char letter = str.charAt(i);
if (openingBrackets.indexOf(letter) != -1) {
stack.add(letter);
} else if (closingBrackets.indexOf(letter) != -1) {
if (stack.size() == 0) {
return false;
}
if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
stack.remove(stack.size() - 1);
} else {
return false;
}
}
}
return stack.size() == 0;
}
}

```
---

## Test Cases

```
Test Case 1
{"string": "([])(){}(())()()"}
Test Case 2
{"string": "()[]{}{"}
Test Case 3
{"string": "(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"}
Test Case 4
{"string": "()()[{()})]"}
Test Case 5
{"string": "(()())((()()()))"}
Test Case 6
{"string": "{}()"}
Test Case 7
{"string": "()([])"}
Test Case 8
{"string": "((){{{{[]}}}})"}
Test Case 9
{"string": "((({})()))"}
Test Case 10
{"string": "(([]()()){})"}
Test Case 11
{
  "string": "(((((([[[[[[{{{{{{{{{{{{()}}}}}}}}}}}}]]]]]]))))))((([])({})[])[])[]([]){}(())"
}
Test Case 12
{"string": "{[[[[({(}))]]]]}"}
Test Case 13
{"string": "[((([])([]){}){}){}([])[]((())"}
Test Case 14
{"string": ")[]}"}

