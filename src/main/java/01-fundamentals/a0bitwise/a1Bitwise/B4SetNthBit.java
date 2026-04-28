package a0bitwise.a1Bitwise;

public class B4SetNthBit {
    public static void main(String[] args) {
        int number = 10; // Example number
        int n = 2;      // Set the 2nd bit from LSB (0-based index)

        // Using bitwise OR to set the nth bit from LSB
        int result = number | (1 << n); // 1 + number = 1

        // Displaying the binary representation of the result and original number
        System.out.println("Original Number:           " + Integer.toBinaryString(number));
        System.out.println("Setting " + n + "nd bit from LSB: " + Integer.toBinaryString(result));
        System.out.println("Result:                    " + result);

    }
}
