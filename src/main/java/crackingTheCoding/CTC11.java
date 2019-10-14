package crackingTheCoding; /**
 *
 * Created by nitinc on 2/11/2015.
 *
 */

import java.util.Set;
import java.util.HashSet;
public class CTC11 {
    public static void main(String[] args) {
        System.out.println(hasUniqueChar("Nit"));
        System.out.println(hasUniqueChar("Nitin"));
    }

    public static boolean hasUniqueChar(String str) {
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < charSet.length; i++) {
            charSet[i] = false;
        }

        for (int i = 0; i < str.length(); i++) {
             if (charSet[str.charAt(i)] == false){
                 charSet[str.charAt(i)] = true;
             }
            else
                 return false;
        }
        return true;
    }
}
    /* USes an extra Data Structure */
/*
    public static boolean hasUniqueChar(String str){
        Set<Character> s = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
        // If on adding the character, if its already present, set.add() returns false
            if(s.add(str.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
*/

