import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CircularQueue {
    public static final char a = ';';
    static Integer[] arr = new Integer[5];
    static int SIZE = arr.length;
    static int in = 0;
    static int out =0;

    static Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

    public static void main(String[] args) {
        fillCircularArray();
        removeFromCircularArray();
    }

    private static Integer[] removeFromCircularArray(){
        int removedElement = arr[out];
        arr[out] = Integer.MIN_VALUE;//Dummy value, NOT NEEDED

        out = (out + 1)%SIZE;

        return arr;
    }

    private static Integer[] fillCircularArray(){
        int SIZE = arr.length;

        while ((in + 1)%SIZE == out)
            ;//Do nothing when the Queue is full

        for (int element : integerStream.collect(Collectors.toList())){
            arr[in+1] = element;
            in = (in + 1)%SIZE;
        }
        return arr;
    }
}
