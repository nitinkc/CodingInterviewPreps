package a0bitwise;

public class P3FindNthBit {
    public static void main(String[] args) {
        int number = 124567;
        System.out.println(Integer.toBinaryString(number));
        int n = 3;      // The bit position (0-based index)

        // Create a bitmask with only the nth bit set
        int bitmask = 1 << n;

        // Use bitwise AND to check if the nth bit is set
        int result = (number & bitmask);//& operator returns the same number with 1

        result = result >> n;//Keeping only the required bit as 1

        System.out.println("The " + n + "th bit of " + number + " is: " + result);
    }
}
