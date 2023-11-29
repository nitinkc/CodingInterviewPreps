package bitwise;

public class NumOfDigits {
    public static void main(String[] args) {
        int i = 123456789;

        int v = (int) Math.floor(Math.log10(i)) + 1;

        System.out.println("v = " + v);
    }
}
