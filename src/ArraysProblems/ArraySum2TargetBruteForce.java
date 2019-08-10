package ArraysProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySum2TargetBruteForce {

    public static void main(String[] args) {
        int a[] = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;

        twoNumberSum(a,target);

    }

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
            System.out.println(ret[i]);
        }

        return ret;
    }
}

