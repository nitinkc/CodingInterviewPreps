package algoEx.tries.multiStringSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiStringSearchTest {
    // Add, edit, or remove tests in this file.
// Treat it as your playground!
    @Test
    public void TestCase1() {
        boolean[] expected = {true, false, true, true, false, true, false};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "this is a big string",
                        new String[]{"this", "yo", "is", "a", "bigger", "string", "kappa"});
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase2() {
        boolean[] expected = {true, true, false, true, true, false, false};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "Mary goes to the shopping center every week.",
                        new String[]{"to", "Mary", "centers", "shop", "shopping", "string", "kappa"});
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase3() {
        boolean[] expected = {false, false, false, false, true, false, false};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "adcb akfkw afnmc fkadn vkaca jdaf dacb cdba cbda",
                        new String[]{"abcd", "acbd", "adbc", "dabc", "cbda", "cabd", "cdab"});
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase4() {
        boolean[] expected = {true, false, false, false, true, true};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "test testing testings tests testers test-takers",
                        new String[]{"tests", "testatk", "testiing", "trsatii", "test-taker", "test"});
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase5() {
        boolean[] expected = {false, false, false, false, false, false, true};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "ndbajwhfawkjljkfaopwdlaawjk dawkj awjkawkfjhkawk ahjwkjad jadfljawd",
                        new String[]{"abc", "akwbc", "awbc", "abafac", "ajjfbc", "abac", "jadfl"});
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase6() {
        boolean[] expected = {false, true, false, false, false, false, false, true, true};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "Is this particular test going to pass or is it going to fail? That is the question.",
                        new String[]{
                                "that", "the", "questions", "goes", "mountain", "passes", "passed", "going", "is"
                        });
        Assertions.assertTrue(compare(output, expected));
    }

    @Test
    public void TestCase7() {
        boolean[] expected = {false, false, false, false, false, false};
        List<Boolean> output =
                MultiStringSearch.multiStringSearch(
                        "Everything in this test should fail.",
                        new String[]{"everything", "inn", "that", "testers", "shall", "failure"});
        Assertions.assertTrue(compare(output, expected));
    }

    public boolean compare(List<Boolean> arr1, boolean[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}