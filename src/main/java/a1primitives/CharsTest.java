package a1primitives;

import java.util.Arrays;

public class CharsTest {
    public static void main(String[] args) {
        int chars[] = new int[127];
        charIntTest(chars);

        char chArray[] = new char[127];
        //System.out.println((int) ',');
        // char2int();
    }

    private static void char2int() {
        System.out.println();
        char charNum1 = '7';
        char charNum2 = '2';

        System.out.println("char number 1 : " + charNum1);
        int num1 = charNum1;
        System.out.println("Num 1 : " + num1);
        int num2 = charNum2 - '0';

        System.out.println("Int number :: " + (num1+num2));
    }

    private static void charIntTest(int[] chars) {
        char test = 'a';
        chars[test]++;
        chars['A']++;
        System.out.println(Arrays.toString(chars));

        /*for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] +"\t");
        }*/
    }
}
