package manage.interviewCake;

import java.util.Stack;

/**
 * Created by nitin on 2/25/15.
 * Correct Approach : Use Stack as an Intermediate DS. Push on closurs and pop on closures
 */
public class ParenthesisChecker {
    public static void main(String[] args) {
        boolean result1 = parenthesisChecker("([])");
        System.out.println("Result1 = " + result1);

        boolean result2 = parenthesisChecker("{[(])}");
        System.out.println("Result2 = " + result2);

        boolean result3 = parenthesisChecker("{[}");
        System.out.println("Result3 = " + result3);

        boolean result4 = parenthesisChecker("{[]()}");
        System.out.println("Result4 = " + result4);

        boolean result5 = parenthesisChecker("{[(])}");
        System.out.println("Result5 = " + result5);

        boolean result6 = parenthesisChecker("([{}])");
        System.out.println("Result6 = " + result6);

        boolean result7 = parenthesisChecker("){");
        System.out.println("Result7 = " + result7);

    }

    public static boolean parenthesisChecker(String str) {
        System.out.println("Pattern is : " + str);
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
                if(!stack.isEmpty()){
                    char top = stack.peek();//top element of stack
                    //System.out.println(top);
                    if(((top == '(') && (curr == ')')) || ((top == '{') && (curr == '}')) || ((top == '[') && (curr == ']'))){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return (stack.empty());
    }
}
