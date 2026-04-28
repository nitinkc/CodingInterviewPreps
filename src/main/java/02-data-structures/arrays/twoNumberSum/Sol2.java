package algoEx.arrays.NumberSum;

import java.util.*;

/**
 * Created by nichaurasia on Wednesday, April/08/2020 at 12:00 AM
 */

class Sol2 {
    // O(n) time | O(n) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num : array) {
            int potentialMatch = targetSum - num;
            if (nums.containsKey(potentialMatch)) {
                return new int[]{potentialMatch, num};
            } else {
                nums.put(num, true);
            }
        }
        return new int[0];
    }
}