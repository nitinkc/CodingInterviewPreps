package a0bitwise;

public class B0Xor {
    public static void main(String[] args) {
        System.out.println(1^0);//1
        System.out.println(1^1);//0
        System.out.println("###################");
        int x = -13;

        System.out.println(x^x);//0
        System.out.println(x^(~x));//-1
    }

    private static int bitwiseXOR(int value) {
        // Bitwise XOR
        value = value ^ 12;
        System.out.println("\nAfter Bitwise XOR with 12: " + value);
        System.out.println("Binary Representation: " + Integer.toBinaryString(value));
        return value;
    }
}