package a2utilities;

import java.util.*;

public class ArraysUtilityClass {
    public static void main(String[] args) {
        //Sort takes array
        int intArray[] = {4,5,3,8,2,71};

        arraysClass(intArray);
        sortArray();
        sortList();
        collectionsSort();
        collectionsSortNullSafe();

        List<Integer> integerListWithNull = Arrays.asList(5, 6, 71, 2, 3);
        List<String> emptyList = Collections.emptyList();
        Integer max = Collections.max(integerListWithNull);//Not null safe
        System.out.println("Collections Max :: " + max);


    }

    private static void collectionsSortNullSafe() {
        List<Integer> integerListWithNull = Arrays.asList(5, 6, null, 71, 2, 3);
        Collections.sort(integerListWithNull, Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("integerListWithNull sorted " + integerListWithNull);

        List<String> stringList = Arrays.asList("apple", null, null, "banana", "orange");
        Collections.sort(stringList, Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("stringList sorted " + stringList);
    }

    private static void collectionsSort() {
        List<Integer> integerListWithoutNull = Arrays.asList(5, 6, 71, 2, 3);

        Collections.sort(integerListWithoutNull);//Not Null Safe, gives NPE if there is a null
        System.out.println("After First Sorting " + integerListWithoutNull.toString());

        Collections.sort(integerListWithoutNull, Collections.reverseOrder());
        System.out.println(integerListWithoutNull.toString());

        Collections.sort(integerListWithoutNull, Comparator.reverseOrder());//Same as Collections.reverseOrder()
        System.out.println(integerListWithoutNull.toString());

        List<String> stringList = Arrays.asList("apple","banana", "orange");
        Collections.sort(stringList, Comparator
                .comparing(String::length)
                .thenComparing(Comparator.reverseOrder()));
        System.out.println(stringList);

    }

    private static void sortList() {
        List<Integer> list = Arrays.asList(4,5,3,8,2,71);
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());
        System.out.println("List Sort " + list);

        List<String> stringList = Arrays.asList("apple", "banana", "orange");
        stringList.sort(Comparator.comparing(String::length).reversed());
    }

    private static void sortArray() {
        // Create an array
        String[] array = {"apple", "banana", "orange"};
        // Convert array to ArrayList using Arrays.asList()
        List<String> arrayListString = new ArrayList<>(Arrays.asList(array));
        arrayListString.sort(Comparator.naturalOrder());

        List<Integer> arrayListInteger = Arrays.asList(4,5,3,8,2,71);
        arrayListInteger.sort(Comparator.reverseOrder());
    }

    private static void arraysClass(int[] intArray) {
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        //Comparator can only be used with a CLASS
        Integer integerArray[] = {4,5,3,8,2,71};
        Arrays.sort(integerArray, Comparator.reverseOrder());//Reverse sorting
        System.out.println(Arrays.toString(integerArray));

        String[] stringArray = {"one", "two", "three", "four"};
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));
        Arrays.sort(stringArray, Comparator.reverseOrder());
        System.out.println(Arrays.toString(stringArray));
    }
}