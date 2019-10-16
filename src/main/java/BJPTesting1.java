package main.java;

import java.util.*;

public class BJPTesting1 {

    public static void main(String[] args) {

        Integer a[] = new Integer[]{3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
        Integer b[] = new Integer[]{-5, 15, 2, -1, 7, 15, 36};

        List<Integer> l1 = new ArrayList<Integer>();
        l1.addAll(Arrays.asList(a));

        List<Integer> l2 = new ArrayList<Integer>();
        l2.addAll(Arrays.asList(b));

        System.out.println(countCommon(l1,l2));
    }

    public static int countCommon(List<Integer> l1, List<Integer> l2){

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i : l1){
            set.add(i);
        }

        for(int j : l2){
            if (!set.add(j)){
                System.out.println(j);
                count = count + 1;
            }
        }
        return count;
    }
}
