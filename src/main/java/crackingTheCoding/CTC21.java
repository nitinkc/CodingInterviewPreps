package crackingTheCoding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nitin on 2/21/15.
 */
public class CTC21 {

    public static void main(String[] args){
        List<Integer> ll = new LinkedList<Integer>();

        for (int i = 0; i < 10 ; i++) {
            ll.add(i);
        }


        LinkedList<Integer> test = removeDuplicate((LinkedList<Integer>) ll);

    }

    public static LinkedList<Integer> removeDuplicate(LinkedList<Integer> list){

        Iterator<Integer> itr = list.iterator();

        while(itr.hasNext()){
            int temp = itr.next();

            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == temp){
                    list.remove(i);
                }
            }
        }


        return list;

    }


}
