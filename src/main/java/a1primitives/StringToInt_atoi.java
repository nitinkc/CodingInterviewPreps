package a1primitives;

public class StringToInt_atoi {
    public static void main(String[] args) {
        String str = "1$2345!";

        int digit = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                //Getting the integer value of the character, Not the Ascii value
                //int x = c - '0';//Subtracting '0' char is important
                int x = Character.getNumericValue(c);//If there is a number, it returns its Numeric value

                //12345 = 1*10^4 + 2*10^3 + 3*10^2 + 4*10^1 + 5*10^0;
                //digit = (int) (digit + (x * Math.pow(10, str.length() - 1 - i)));

                //12345 = 1 -> 10+2 -> 120+3 -> 1230+4 -> 12340+5
                digit = (digit * 10) + x;
            }else{
                System.out.println("Invalid, Non numeric character");
                //return;
            }
        }
        System.out.println("The int value of String " + str + " is = "+ digit);
    }
}
