package a0bitwise;

public class B4FindParity_Longer {
    public static void main(String[] args) {
        //Trick: pick the LSB and check if its 1
        int x = -8;
        System.out.println(Integer.toBinaryString(x));//Converts Short to 32 bit Integer

        usingLongerMethod(x);
        System.out.println("####################");
        usingShorterMethod(x);
    }

    private static void usingLongerMethod(int x) {
        int count=0;
        short parity = 0;
        while (x != 0) {
            if ((x & 1) == 1) {//pick the LSB
                count++;
                parity = (short) (parity ^ 1);//Keep flipping the parity, when even its 0, when odd, its 1
            }
            x = x >>> 1;//Use Unsigned Right Shift for negative numbers, else infinite loop
        }
        System.out.println("Count : " +count);
        System.out.println("Result : " +parity);
    }

    private static void usingShorterMethod(int x) {
        int count=0;
        short parity = 0;
        while (x != 0) {
            parity = (short) (parity ^ (x & 1));//Check the LSB and XOR with the parity (initilized with 0)
            count = count + (x & 1);
            x = x >>> 1;//Use Unsigned Right Shift for negative numbers, else infinite loop
        }
        System.out.println("Count : " +count);
        System.out.println("Result : " +parity);
    }
}
