package algoEx.arrays.smallestDifference;

/**
 * Created by nitin on Tuesday, April/28/2020 at 12:48 AM
 */

import java.util.Arrays;
class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.

		/*
		//Brute Force O(nXm)
		int smallest = Integer.MAX_VALUE;
		int ret[] = new int[2];
		for (int i = 0; i < arrayOne.length; i++){
			for(int j = 0; j < arrayTwo.length; j++){
				if (smallest >= Math.abs(arrayOne[i] - arrayTwo[j])){
					ret[0] = arrayOne[i];
					ret[1] = arrayOne[j];
				}
			}
		}

		return ret;
		*/

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

