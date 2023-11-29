package bitwise;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countBits(0b1100011));

        System.out.println(countOnes(0b1100011));
    }

    private static short countBits(int x){
        short numBits = 0;

        while(x != 0){
            numBits += (x & 1);

            x >>>= 1;
        }
        return numBits;
    }

    public static int countOnes(int x) {
        int count = 0;

        while (x != 0) {
            // Check the least significant bit
            if ((x & 1) == 1) {
                count++;
            }

            // Right shift to check the next bit
            x >>>= 1;
        }

        return count;
    }
}
