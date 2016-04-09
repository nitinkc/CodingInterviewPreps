package udemyJobInterview;

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

        long ret = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';

            if (val >= 0 && val <= 9) {
                int placevalue = str.length() - i - 1;
                ret = (int) (ret + (val * Math.pow((double) 10, (double) placevalue)));
            } else {
                throw new RuntimeException("Not a number:" + str.charAt(i));
            }
        }
        return ret;
    }
}
