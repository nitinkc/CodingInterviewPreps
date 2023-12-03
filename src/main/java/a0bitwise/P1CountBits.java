package a0bitwise;

/**
 * Created by Nitin Chaurasia on 2/12/17 at 11:07 PM.
 *
 * Count the number of bits that are set to 1 in an integer, starting with the lease significant bit
 *
 * Short is 16 bits long minimum value of -32,768 and a maximum value of 32,767
 */
public class P1CountBits {

    public static void main(String[] args) {
        System.out.println(countBits(6));
    }

    public static short countBits(int x){
        short numBits = 0;//16 bit number

        while (x != 0){
            numBits += (x & 1);

            x >>>= 1;
        }

        return numBits;
    }
}
