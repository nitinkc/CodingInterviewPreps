package a1DataStructures.ds5Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ds1TreeMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        map.put("Joe", 12);
        map.put("Noel", 76);
        map.put("Michael", 23);
        map.put("Nitin", 32);
        map.put("Kirti", 29);
        map.put("Adam", 34);
        map.put("aAdam", 32);//Notice small a

        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()){
            String key = itr.next();
            int value = map.get(key);

            System.out.println("The Key : Value pair is ==> " + key +" : "+ value);
        }



    }
}
