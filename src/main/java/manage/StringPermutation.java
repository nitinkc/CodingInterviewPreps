package manage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 10/31/15 at 4:37 PM.
 */
public class StringPermutation {

    static int a = 0;
    public static void main(String[] a){
        String str= "abc";
        System.out.println(permString(str).toString());
    }

    public static List<String> permString(String str){
        List<String> list = new ArrayList<String>(); //empty
        List<String> newPerm = new ArrayList<String>(); // empty

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // a, b
            List<String> temp = new ArrayList<String>();
            if(list.size() == 0){
                list.add(Character.toString(c)); // [a]
            } else {
                for(String perm : list){
                    getPermForChar(perm, Character.toString(c), temp);
                }
                list = temp;
            }
        }
        return list;
    }

    private static void getPermForChar(String perm, String c, List<String> collect){
        System.out.println("getPermFromChar STRING: " + perm);
        for (int i = 0; i <= perm.length(); i++) {
            collect.add(perm.substring(0,i) + c + perm.substring(i));
        }
        System.out.println("getPermFromChar: " + collect);
    }
}
