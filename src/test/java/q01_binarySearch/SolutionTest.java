package q01_binarySearch;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q01 Binary Search")
class SolutionTest {

    Solution solution;

    void prepare() {
        solution = new Solution();
    }

    @Test
    void empty() {
        test("", 0, 2);
    }

    @Test
    void single() {
        test("1", 0, 3);
    }

    @Test
    void doubleSame() {
        test("1, 1", 0, 3);
    }

    @Test
    void doubleDiff() {
        test("1, 2", 0, 4);
    }

    @Test
    void doubleDiff2() {
        test("1, 3", 0, 6);
    }


    @Test
    void triple1() {
        test("1, 1, 1", 0, 6);
    }

    @Test
    void triple2() {
        test("1, 2, 2", 0, 6);
    }

    @Test
    void triple3() {
        test("1, 2, 3", 0, 6);
    }

    @Test
    void triple4() {
        test("1, 3, 9", 0, 12);
    }


    @Test
    void real() {
        test("1, 1, 4, 5, 8, 9, 11, 30", 0, 32);
    }

    void test(String arrStr, int from, int to) {
        int[] arr = arr(arrStr);
        Collection set = set(arrStr);
        boolean fails = false;
        for (int i = from; i < to; i++) {
            prepare();
            boolean expected = set.contains(i);
            boolean actual = solution.contains(arr, i);
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

    private Collection<Integer> set(String literal) {
        return Arrays.stream(literal.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }





}