package a1DataStructures.ds1Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin.chaurasia on 2/20/2017.
 */
public class ds3ArrayList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        final int iter = 5;

        //USING LOOPING METHOD
        for (int i = 0 ; i< iter; i++){
            arr.add(i*i);
        }

        for (int a: arr) {
            System.out.print(a + "\t");
        }

        System.out.println();
        //USING ITERATOR
        Iterator itr = arr.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next() + "\t");
        }
    }
}
