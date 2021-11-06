package leetCode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralCountTest {

    SpiralCount sc= new SpiralCount();
    @Test
    public void test1(){
        int input[][] = new int[][]{{1,2,3,4,5,6,7}, {20,21,22,23,24,25,8},
                                    {19,32,33,34,35,26,9},{18,31,30,29,28,27,10},
                                    {17,16,15,14,13,12,11}};
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            expected.add(i);
        }
        var actual = sc.spiralOrder(input);
        Assertions.assertEquals(expected, actual);
    }
}