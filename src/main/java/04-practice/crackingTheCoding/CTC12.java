package crackingTheCoding;

/**
 * Created by nitinc on 2/11/2015.
 */
public class CTC12 {
    public static void main(String[] args){
        System.out.println(revString("abcdefghijklmopqrstuvwxyz"));
        System.out.println(revString(""));
        System.out.println(revString("Nitin.."));
        System.out.println(revString("123456789"));

    }

    //Simple implementation of reversing the string
    public static String revString(String str){
        //String ret = "";
        StringBuilder sb = new StringBuilder();

        for(int i =str.length()-1; i >= 0; i--){
            //ret = ret + str.charAt(i);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}