package a0bitwise;

public class B8BitMasking {
    public static void main(String[] args) {
        //using bit mask : 1 << n
        int x = -237;
        int n = 3;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.bitCount(x));

        turnOnNthBit(x, n);//0 based index
        turnOffNthBit(x, n);
        toggleNthBit(x,n);
    }

    private static void toggleNthBit(int x, int n) {
        int toggledBit = x ^ (1 << n);
        System.out.println(Integer.toBinaryString(toggledBit));
    }

    private static void turnOnNthBit(int x, int n) {
        int setBit = x | (1 << n);
        System.out.println(Integer.toBinaryString(setBit));
    }

    private static void turnOffNthBit(int x, int n) {
        int clearedBit = x & ~(1 << n);
        System.out.println(Integer.toBinaryString(clearedBit));
    }
}