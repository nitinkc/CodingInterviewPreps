package a1DataStructures.ds5Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * There are 3 classes that implements the Map interface
 *
 * 1.) HashMap: "the map" in which we store key-value pairs. Find the value according to the key in O(1)
 *      if the hash function is perfect/good
 *
 * 		PROBLEM: There is no ordering --> the iteration order can change when new items are added !!!
 *
 * 2.) TreeMap: it supports DNSO, natural ordering, so numerical ordering for numbers alphabetical
 * 		ordering for strings and characters compareTo() method or Comparator is important 
 * 			~ to be able to decide the order !!!
 *
 * 3.) LinkedHashMap: it contains a doubly linked list connecting all the entries in the map 
 * 			It can provide the so-called insertion-order: so unlike HashMap it can provide the order 
 * 				in which keys were inserted into a map ~ insertion order is not affected if a key is
 * 					re-inserted into the map
 *
 * 				IMPORTANT: they consume more memory than HashMap !!!
 */

public class ds1HashMapsJava {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Adam", 34);
        map.put("Joe", 12);
        map.put("Noel", 76);
        map.put("Michael", 23);
        map.put("Nitin", 32);
        map.put("kirti", 29);

        System.out.println(map);

        //Iterating the Maps
        Iterator<String> itr = map.keySet().iterator();

        while(itr.hasNext()){
            String key = itr.next();
            int value = map.get(key);

            System.out.println("The Key : Value pair is ==> " + key + " : " + value);
        }
    }
}