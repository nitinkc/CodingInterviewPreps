package algoEx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProgramTest {

    // Add, edit, or remove tests in this file.
// Treat it as your playground!
    @Test
    public void TestCase1() {
        var input = new int[]{};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase2() {
        var input = new int[]{1};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase3() {
        var input = new int[]{1, 2};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase4() {
        var input = new int[]{2, 1};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase5() {
        var input = new int[]{1, 5, 10, 1100, 1101, 1102, 9001};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase6() {
        var input = new int[]{-1, -5, -10, -1100, -1101, -1102, -9001};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase7() {
        var input = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase8() {
        var input = new int[]{-1, -5, -10, -1100, -900, -1101, -1102, -9001};
        var expected = false;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase9() {
        var input = new int[]{1, 2, 0};
        var expected = false;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase10() {
        var input = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11};
        var expected = false;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase11() {
        var input = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase12() {
        var input = new int[]{-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11};
        var expected = false;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase13() {
        var input = new int[]{-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCase14() {
        var input = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        var expected = true;
        var actual = Program.isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }
}