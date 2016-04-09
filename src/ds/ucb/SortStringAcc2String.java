package ds.ucb;

import java.util.*;

/**
 * Created by Nitin Chaurasia on 3/21/16 at 8:52 PM.
 */
public class SortStringAcc2String {
    public static void main(String[] args) {
        SortStringAcc2String s = new SortStringAcc2String();
        String[] output = s.reArrange("cbefagilnxompyzwkhrtsqdjvu", new String[]{"apple", "color", "ball", "beautiful","nose"});

        for (String i : output){
            System.out.println(i);
        }
    }


    public String[] reArrange(String rankString, String[] input){

        Map<Integer,String> wordMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            String temp = input[i];
            char val = temp.charAt(0);

            int rank = rankString.indexOf(val);
            if(wordMap.containsKey(rank+1)){
            } else{
                wordMap.put(rank+1, temp);
            }
        }

        Iterator<Integer> itr = wordMap.keySet().iterator();
        List<Integer> list = new ArrayList<Integer>();
        while (itr.hasNext()){
            int key = itr.next();
           System.out.println(key +" : " + wordMap.get(key));
            list.add(key);
        }

        Collections.sort(list);


        // Putting the String into the output Array accding to the modified rank
        itr = wordMap.keySet().iterator();
        String[] output = new String[input.length];
        int index = 0;
        while (itr.hasNext()){
            int key = itr.next();

            output[index++] = wordMap.get(key);
        }

        return output;

    }
}
