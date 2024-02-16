package a1primitives;

public class CharsTest {
    public static void main(String[] args) {
        int chars[] = new int[127];
        char test = 'a';
        chars[test] = 1;//chars[test]+
        System.out.println(chars[test]);

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] +"\t");
        }
    }
}
