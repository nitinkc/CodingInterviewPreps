package interviewCake;

/**
 * Created by nitin on 2/25/15.
 */
public class ProblemUnknown {
    public static void main(String[] args) {
        boolean result1 = parenthesisChecker("{[]()}");
        boolean result2 = parenthesisChecker("{[(])}");
        boolean result3 = parenthesisChecker("{[}");

        System.out.println("Result1 = " + result1);
        System.out.println("Result2 = " + result2);
        System.out.println("Result3 = " + result3);
    }

    public static boolean parenthesisChecker(String s) {
        boolean result = false;
        if (s.length() % 2 != 0 || s.length() == 0)
            return false;
        else {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    //System.out.println(s.charAt(i) + " "+ s.charAt(s.length() - i - 1));
                    result = false;
                } else result = true;
            }
        }
        return result;

    }
}
