package ArraysProblems;

import java.util.*;

public class ArraySum2TargetHashMap {
    public static void main(String[] args) {
        int[] a = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;

        twoNumberSum(a,target);

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            //CONSIDERING UNIQUE
            map.put(i,array[i]);
        }

        Iterator<Integer> itr = map.keySet().iterator();

        while(itr.hasNext()){
            int key = itr.next();//key
            int y = map.get(key);

            if (map.containsValue(targetSum - y)){
                list.add(y);
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
