package a0bitwise.a1Bitwise;

public class B3SetBit {
    public static void main(String[] args) {
        int y = 0b10101000;

        /*
         6712
        - 0099
        ---------
            13


         000100
        - 000111
        -----------
                 1
         */
        int setBitTest = (y & (y-1));//flip/unset the Right most Set bit
        System.out.println(Integer.toBinaryString(setBitTest));

        int extractSetBitTest = (y & ~(y-1));//it isolates the rightmost 1-bit of y and sets all other bits to 0
        System.out.println(Integer.toBinaryString(extractSetBitTest));
    }
}