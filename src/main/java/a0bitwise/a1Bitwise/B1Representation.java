package a0bitwise.a1Bitwise;

public class B1Representation {
    public static void main(String[] args) {
        //
        short num = -16;
        int x = 0b11111111111111111111111111110001;
        //System.out.println(binNum);
        //System.out.println(Integer.toBinaryString(num));

        //2s compliment -> invert the bits +1 -> FIND SHORTCUT TO MAKE A BINARY NUM a 2s complement
        int positiveNum =    0b00101100;//44, 32 bit number
        int twoScomplement = 0b11111111111111111111111111010100;//Flip all the bits after the First 1 from LSB (rightmost Setbit), Go Left to Right
        System.out.println("Positive Number : " + positiveNum + " :::: 2's Complement : "+ twoScomplement + " :: -44 = " + Integer.toBinaryString(-44));
    }
}
