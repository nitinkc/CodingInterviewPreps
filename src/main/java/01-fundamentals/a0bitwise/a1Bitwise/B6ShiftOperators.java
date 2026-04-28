package a0bitwise.a1Bitwise;

public class B6ShiftOperators {
    public static void main(String[] args) {
        // 3 shift Operators
        int x = -8;
        // Original value
        System.out.println("Original Value: " + x);
        System.out.println("Binary Representation: " + Integer.toBinaryString(x));

        //right shift Operator
        rightShiftDivideBy2(x);

        //Unsigned Right shift operator. REAL SHIFT OPERATION
        unsignedRightShift_TrueRightShift(x);

        //Left Shift
        leftShiftMultiplyBy2(x);

    }

    private static void rightShiftDivideBy2(int x) {
        x = x >> 1;//Divides by 2^n, where n = 1
        System.out.println("\nAfter Right Shift (Divide by 2): " + x);
        System.out.println("Binary Representation: " + Integer.toBinaryString(x));
    }

    private static void unsignedRightShift_TrueRightShift(int x) {
        x = x >>> 32;
        System.out.println("\nAfter Unsigned Right Shift : " + x);
        System.out.println("Binary Representation: " + Integer.toBinaryString(x));
    }

    private static void leftShiftMultiplyBy2(int x) {
        x = x << 32;//Multiply by 2^n, where n = 1
        System.out.println("\nAfter Left Shift (Multiply by 2): " + x);
        System.out.println("Binary Representation: " + Integer.toBinaryString(x));
    }
}