package a0bitwise;

public class BitTests {
    public static void main(String[] args) {
        int n = 1;

        int x = 1 << n;
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
    }
}