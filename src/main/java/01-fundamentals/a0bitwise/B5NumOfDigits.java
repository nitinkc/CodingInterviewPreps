package a0bitwise;

public class B5NumOfDigits {
    public static void main(String[] args) {
        int num = 123456789;
        int numberOfDigits = (int) Math.floor(Math.log10(num)) + 1;

        System.out.println("number of digits = " + numberOfDigits);

        int msdMask = (int) Math.pow(10,numberOfDigits-1);
        for (int i = 0; i < numberOfDigits/2 + 1; i++) {//Works well with Even number of digits
            int lsd = num%10;//Least Significant Digit
            int msd = num/msdMask;
            System.out.println(msd + " :: " + lsd);

            num = num % msdMask;//Removing the MSD, remainder is the rest of the number
            num = num / 10;//Removing the LSD

            //Adjust the msdMask, as 2 digits are already removed
            msdMask = msdMask/100;
        }
    }
}