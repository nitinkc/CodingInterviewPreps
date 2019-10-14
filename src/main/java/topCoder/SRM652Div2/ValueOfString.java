package topCoder.SRM652Div2;

import java.util.*;
/**
 * Created by nitinc on 2/27/2015.
 * 250 Point Problem
 */
public class ValueOfString {
    public static void main(String[] a){
        System.out.println(findValue("zz"));

    }

        public static int findValue(String str) {
            Map<Character, Integer> ref = new HashMap<Character, Integer>();
            //Create a map of the characters greater than or equal to the current character
            Map<Character, Integer> word = new HashMap<Character, Integer>();

            int count = 1;
            for (char i = 'a'; i <= 'z'; i++) {
                ref.put(i, count);
                count++;
            }

            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (word.get(temp) == null) {
                    word.put(temp, wordCount(str, temp));
                }
            }
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                int a = ref.get(temp);
                int b = word.get(temp);
                sum = sum + (a*b);
            }
            return sum;
        }

    public static int wordCount(String str, char c){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= c){
                count++;
            }
        }
        return count;
    }
}
