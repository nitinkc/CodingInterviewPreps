package a0bitwise;

public class B6AddBitwise {
    public static void main(String[] args) {
        System.out.println(add(1, -1));
        System.out.println(add(-9, -1));
        System.out.println(add(1, 2));
        System.out.println(add(2, 3));
        System.out.println(add(9, 1));

    }

    private static long add(long a, long b) {
        while (b != 0) {
            long carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}