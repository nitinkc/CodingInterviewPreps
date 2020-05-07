package algoEx;

/**
 * Created by nitin on Tuesday, April/07/2020 at 9:59 PM
 */
class Program {

        // O(n) time | O(1) space - where n is the length of the array

    public static boolean isMonotonic(int[] array) {

        if (array.length <= 2) return true;
        var direction = array[1] - array[0];

        for (int i = 2; i < array.length; i++) {

            if (direction == 0) {

                direction = array[i] - array[i - 1];

                continue;

            }
​

            if (breaksDirection(direction, array[i - 1], array[i])) {

                return false;

            }
