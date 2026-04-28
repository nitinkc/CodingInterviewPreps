package a0bitwise;

public class B4FindParity_CountOnes {
    public static void main(String[] args) {
        //Trick: x & (x-1) turns the Rightmost 1, from LSB to zero
        int x = 10;
        System.out.println(Integer.toBinaryString(x));//Converts Short to 32 bit Integer

        int count=0;
        short parity = 0;
        while (x != 0){//O(K) where k = number of 1's in the bit representation
            x = (short) (x & (x-1));//Changes the first 1 from LSB, to zero, and count
            count++;
            parity = (short) (parity ^ 1);//Keep flipping the parity, when even its 0, when odd, its 1
        }
        System.out.println("Count : " +count);
        System.out.println("Result : " +parity);
    }
}
