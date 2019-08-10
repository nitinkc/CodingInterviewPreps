package ArraysProblems.peob7;

import java.util.Arrays;

class Sol2_TwoPointer {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // O(nlog(n) + mlog(m))
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int p1 = 0;
        int p2 = 0;
        int[] ret = new int[2];

        int smallest = Integer.MAX_VALUE;

        while(p1 < arrayOne.length && p2 < arrayTwo.length){
            int curr = Math.abs(arrayOne[p1] - arrayTwo[p2]);
            if (smallest > curr){
                smallest = curr;
                ret[0] = arrayOne[p1];
                ret[1] = arrayTwo[p2];
            }

            if(arrayOne[p1] < arrayTwo[p2]){
                p1++;
            }else{
                p2++;
            }
        }

        return ret;
    }
}
