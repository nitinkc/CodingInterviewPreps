package a0bitwise;

public class B1ShiftOperators {
    public static void main(String[] args) {
        int a = 0b11011;
        int x = -8;//11111111111111111111111111111000

        System.out.println(Integer.toBinaryString(x));

    }

    int toggleNthBit(int num, int n) {
        return num ^ (1 << n);
    }
}
