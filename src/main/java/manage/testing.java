package manage;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 8:53 PM.
 */
public class testing {
    private static final int count;
    static {
        System.out.println("In block 1");
        count = 10;
    }

    private final int[] data;
    {
        System.out.println("In block 2");
        String str = "Nitin";
        str.length();
        int left =0, right = 0;
        left++; right--;
        data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    public static void main (String[] args) {
        System.out.println("Count = " + count);
        System.out.println("Before 1st call to new");
        testing test1 = new testing();
        System.out.println("Before 2nd call to new");
        testing test2 = new testing();
    }
}