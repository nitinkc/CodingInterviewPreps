package leetCode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    TwoSum twoSum = new TwoSum();
    @Test
    public void test1(){
        int[] input = new int[]{2,7,11,15};
        int[] expected = new int[]{1,0};

        var actual = twoSum.twoSum(input,9);
        Assertions.assertArrayEquals(expected, actual);
    }

}