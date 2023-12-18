package a2utilities;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Harry Potter", "Hermione Granger", "Ron Weasley",
                "Albus Dumbledore", "Severus Snape", "Voldemort",
                "Hagrid", "Draco Malfoy",
                "Neville Longbottom", "Luna Lovegood", "Sirius Black", "Remus Lupin"
        );

        //reversedTreeMap(namesList);
        //naturalTreeMap(namesList);
        //customTreeMap(namesList);

        //iterateMaps(namesList);

        countFrequency();
    }

    private static void countFrequency() {
        List<String> namesList = Arrays.asList(
                "Harry", "Hermione", "Ron",
                "Harry", "Ron", "Ron", "Remus"
        );
        Map<String,Integer> map = new HashMap<>();
        for (String str: namesList) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        map.forEach((name, length) -> System.out.println(name + ": " + length));

        System.out.println("########## TREE MAP ##########");
        Map<String,Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (String str: namesList) {
            if(treeMap.containsKey(str))
                treeMap.put(str, map.get(str) + 1);
            else
                treeMap.put(str,1);
        }
        treeMap.forEach((name, length) -> System.out.println(name + ": " + length));

    }

    private static void iterateMaps(List<String> namesList) {
        Map<String,Integer> map = new HashMap<>();
        for (String name : namesList) {
            map.put(name, name.length());
        }

        // Iterate over the map using entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()){
            String key = itr.next();
            Integer value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        map.forEach((name, length) -> System.out.println(name + ": " + length));
    }

    private static void reversedTreeMap(List<String> namesList) {
        Map<String, Integer> treeMapReversed =
                new TreeMap<>(Comparator.reverseOrder());

        for (String name : namesList) {
            treeMapReversed.put(name, name.length());
        }

        treeMapReversed.forEach((name, length) -> System.out.println(name + ": " + length));
    }

    private static void naturalTreeMap(List<String> namesList) {
        Map<String, Integer> treeMap =
                new TreeMap<>();

        for (String name : namesList) {
            treeMap.put(name, name.length());
        }

        treeMap.forEach((name, length) -> System.out.println(name + ": " + length));
    }

    private static void customTreeMap(List<String> namesList) {
        Map<String, Integer> treeMap =
                new TreeMap<>(Comparator.comparing(String::length));

        for (String name : namesList) {
            treeMap.put(name, name.length());
        }

        treeMap.forEach((name, length) -> System.out.println(name + ": " + length));
    }
}