package a0bitwise;

public class B3CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBitsCondensed(0b1100011));

        System.out.println(countOnes(0b1100011));
    }

    private static short countSetBitsCondensed(int x){
        short numSetBits = 0;

        while(x != 0){
            numSetBits += (x & 1);
            x >>>= 1;
            //System.out.println(x);
        }
        return numSetBits;
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
