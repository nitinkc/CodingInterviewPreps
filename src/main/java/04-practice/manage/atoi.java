package manage;

/**
 * Created by Nitin Chaurasia on 10/26/15 at 8:42 AM.
 */
public class atoi {

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(atoi("1232677568"));
    }

    public static long atoi(String str) {
        if (str == null || str.length() == 0)
            throw new RuntimeException("Empty/Null string:" + str);

        long digits = 0;
        for (int i = 0; i < str.length(); i++) {
            //int val = str.charAt(i) - '0';
            int val = Character.getNumericValue(str.charAt(i));

            if (val >= 0 && val <= 9) {
                int placevalue = str.length() - i - 1;
                //digits = (int) (digits + (val * Math.pow(10, placevalue)));
                digits = digits*10 + val;
            } else {
                throw new NumberFormatException("Not a number:" + str.charAt(i));
            }
        }
        return digits;
    }
}
