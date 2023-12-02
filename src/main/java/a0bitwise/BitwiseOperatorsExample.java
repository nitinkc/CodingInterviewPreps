package a0bitwise;

public class BitwiseOperatorsExample {

    public static void main(String[] args) {
        int x = -8;

        // Original value
        System.out.println("Original Value: " + x);
        System.out.println("Binary Representation: " + Integer.toBinaryString(x));

        x = rightShiftDivideByTwo(x);
        x = leftShiftMultiplyByTwo(x);
        x = unsignedRightShift(x);
        x = bitwiseANDWith3(x);
        x = bitwiseORWith5(x);
        x = bitwiseXORWith12(x);
        x = bitwiseNOT(x);
    }

    private static int rightShiftDivideByTwo(int value) {
        // Right Shift (Divide by 2)
        value = value >> 1;
        System.out.println("\nAfter Right Shift (Divide by 2): " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int leftShiftMultiplyByTwo(int value) {
        // Left Shift (Multiply by 2)
        value = value << 1;
        System.out.println("\nAfter Left Shift (Multiply by 2): " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int unsignedRightShift(int value) {
        // Unsigned Right Shift
        value = value >>> 1;
        System.out.println("\nAfter Unsigned Right Shift: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int bitwiseANDWith3(int value) {
        // Bitwise AND
        value = value & 3;
        System.out.println("\nAfter Bitwise AND with 3: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int bitwiseORWith5(int value) {
        // Bitwise OR
        value = value | 5;
        System.out.println("\nAfter Bitwise OR with 5: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int bitwiseXORWith12(int value) {
        // Bitwise XOR
        value = value ^ 12;
        System.out.println("\nAfter Bitwise XOR with 12: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }

    private static int bitwiseNOT(int value) {
        // Bitwise NOT
        value = ~value;
        System.out.println("\nAfter Bitwise NOT: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }
}
