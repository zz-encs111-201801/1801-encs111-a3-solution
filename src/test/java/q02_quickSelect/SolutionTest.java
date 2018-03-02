package q02_quickSelect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q02 Quick Select")
class SolutionTest {

    @Test
    void case1() {
        test("1");
    }

    @Test
    void case2() {
        test("1, 1");
    }

    @Test
    void case3() {
        test("1, 2");
    }

    @Test
    void case4() {
        test("1, 3");
    }

    @Test
    void case5() {
        test("1, 1, 2");
    }

    @Test
    void case6() {
        test("1, 7, 4");
    }

    @Test
    void case7() {
        test("6, 7, 3, 8, 4");
    }

    void test(String arrStr) {
        int[] arr = arr(arrStr);
        List<Integer> list = list(arrStr);
        boolean fails = false;
        for (int i = 0; i < arr.length; i++) {
            Solution solution = new Solution();
            int expected = list.get(i);
            int actual = solution.getAtRank(arr, i);
            try {
                assertEquals(expected, actual);
            } catch (Error e) {
                System.err.println("Target arr: " + arrStr);
                System.err.println("Error on testing: " + i);
                System.err.println("Expected: " + expected + ", Actual: " + actual);
                System.err.println();
                fails = true;
            }
        }
        if (fails) {
            fail("Fails");
        }
    }

    private int[] arr(String literal) {
        return Arrays.stream(literal.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private List<Integer> list(String literal) {
        return Arrays.stream(literal.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}