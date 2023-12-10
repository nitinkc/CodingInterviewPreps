package a0bitwise.a1Bitwise;

public class B2LSB {
    public static void main(String[] args) {
        int x = 0b11111111111111111111111111110001;

        //Logic : Communicative Identity : a * 1 = 1 * a = a (for the last bit)
        //LSB and & operator
        short lsb = (short) (x & 000000000000001);//Give ONLY the LSB
        System.out.println("x = " + x + " LSB of x = " + lsb);
    }
}