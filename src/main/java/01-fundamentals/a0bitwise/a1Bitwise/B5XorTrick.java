package a0bitwise.a1Bitwise;

public class B5XorTrick {
    public static void main(String[] args) {
        // XOR Trick - Cancellation
        int a = 90, b = 90;
        int c = a ^ b;
        System.out.println(c);

        System.out.println(a ^ (~a));//All 1's (32 bits) = -1

        // XOR Trick - Add without Carry

        boolean flag1 = true;//1
        boolean flag2 = 2 < 1;//0

        // Definition of  XOR
        if ((flag1 & !flag2) || (!flag1 & flag2)){//Intuitive and Self explanatory
            System.out.println("Reached here 1");
        }

        if (flag1 ^ flag2){//Optimized
            System.out.println("Reached here 2");
        }




    }
}
