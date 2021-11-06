package leetCode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {

    LargestNumber largestNumber = new LargestNumber();
    @Test
    void largestNumber() {
        int input[] = new int[]{10,2};
        String expected = "210";

        var actual = largestNumber.largestNumber(input);
        Assertions.assertEquals(expected, actual);
    }
}