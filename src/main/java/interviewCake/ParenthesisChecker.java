package interviewCake;

import java.util.Stack;

/**
 * Created by nitin on 2/25/15.
 * Correct Approach : Use Stack as an Intermediate DS. Push on closurs and pop on closures
 */
public class ParenthesisChecker {
    public static void main(String[] args) {

        boolean result1 = parenthesisChecker("([])");
        System.out.println("Result1 = " + result1);

        boolean result4 = parenthesisChecker("{[]()}");
        boolean result2 = parenthesisChecker("{[(])}");
        boolean result3 = parenthesisChecker("{[}");

        System.out.println("Result1 = " + result1);
        System.out.println("Result2 = " + result2);
        System.out.println("Result3 = " + result3);

//        boolean result2 = parenthesisChecker("{[(])}");
//        System.out.println("Result2 = " + result2);
//
//        boolean result3 = parenthesisChecker("([{}])");
//        System.out.println("Result3 = " + result3);
    }

    public static boolean parenthesisChecker(String str) {
        boolean result = false;
        if (str.length() % 2 != 0 || str.length() == 0)
            return false;

        // Stack as an intermediate Data Structure
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // Push on Openers
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else { // pop on similar CLOSURES
                // ALSO CHECK IF SIMILAR IS COMING OUT
                char top = stack.peek();//top element of stack
                //System.out.println(top);
                if (    ((top == '(') && (curr == ')')) ||
                        ((top == '{') && (curr == '}')) ||
                        ((top == '[') && (curr == ']'))
                        ) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return (stack.empty());
    }
}
