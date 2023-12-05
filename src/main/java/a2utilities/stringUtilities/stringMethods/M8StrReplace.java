package a2utilities.stringUtilities.stringMethods;

public class M8StrReplace {
    public static void main(String[] args) {
        String str = "Replace Strings";

        System.out.println(str.replace('e','*'));
        System.out.println(str.replace("a","$$"));

        String str1 = str.replaceAll(" ", "" );
        System.out.println(str1);
    }


}
