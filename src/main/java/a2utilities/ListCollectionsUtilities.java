package a2utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListCollectionsUtilities {
    public static void main(String[] args) {
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
}
