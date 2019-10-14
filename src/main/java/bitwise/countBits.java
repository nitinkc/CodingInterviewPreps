package bitwise;

public class countBits {
    public static void main(String[] args) {
        System.out.println(countBits(0b1100011));

    }

    private static short countBits(int x){
        short numBits = 0;

        while(x != 0){
            numBits += (x & 1);

            x >>>= 1;
        }
        return numBits;
    }
}
