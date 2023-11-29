package bitwise;

public class CountZeroes {
    public static void main(String[] args) {
        int x = 235;//11101011
        int count = countZeroes(x);

        System.out.println("Number of zeroes in binary representation of x = " + x + " is : " + count);
    }

    public static int countZeroes(int x) {
        int count = 0;

        while (x != 0) {
            // Check the least significant bit
            if ((x & 1) == 0) {
                count++;
            }

            // Right shift to check the next bit
            x >>>= 1;
        }

        return count;
    }
}
