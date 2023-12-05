package manage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nitin Chaurasia on 4/9/16 at 10:29 AM.
 */
public class UncoupledInteger {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 3,5,6,7};
        //uncoupledInt(arr);

        xorApproach(arr);

    }

    private static void xorApproach(int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++){
            xor = xor^arr[i]; // Keeps only unique numbers
        }
        System.out.println(xor);
    }


    private static void uncoupledInt(int[] arr) {
        Set<Integer> unique = new HashSet<Integer>();

        for (int i : arr) { // iterating the array
            if (unique.add(i)) {
                // do nothing;
            } else {
                unique.remove(i);
            }
        }

        System.out.println(unique);

    }


}