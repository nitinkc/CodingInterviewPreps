package algoEx.arrays.twoNumberSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nitin on Tuesday, April/28/2020 at 12:20 AM
 */
public class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            for(int j=i+1; j < array.length; j++){
                if(array[i] + array[j] == targetSum){
                    list.add(array[i]);list.add(array[j]);
                }
            }
        }
        Collections.sort(list);

        int[] ret = new int[list.size()];

        for (int i=0 ; i<list.size(); i++){
            ret[i] = list.get(i);
            // System.out.println(ret[i]);
        }

        return ret;
    }
}
