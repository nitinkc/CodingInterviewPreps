package a2utilities;

import java.util.*;

public class ArraysUtilityClass {
    public static void main(String[] args) {
        //Sort takes array
        int intArray[] = {4,5,3,8,2,71};

        arraysClass(intArray);
        sortArray();
    }

    private static void sortArray() {
        // Create an array
        String[] array = {"apple", "banana", "orange"};
        Arrays.sort(array);
        System.out.println(array);

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