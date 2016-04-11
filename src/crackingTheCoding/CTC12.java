package crackingTheCoding;

/**
 * Created by nitinc on 2/11/2015.
 */
public class CTC12 {
    public static void main(String[] args){
        System.out.println(revString("abcdefghijklmopqrstuvwxyz"));
        System.out.println(revString(""));
        System.out.println(revString("Nitin.."));



    }

    //Simple implementation of reversing the string
    public static String revString(String str){
        String ret = "";

        for(int i =str.length()-1; i >= 0; i--){
            ret = ret + str.charAt(i);
        }
        return ret;
    }

}
