package q03_quickSort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q03 Quick Sort")
class SolutionTest {

    @Test
    void case1() {
        test("");
    }


    @Test
    void case2() {
        test("6");
    }


    @Test
    void case3() {
        test("1, 2");
    }


    @Test
    void case4() {
        test("2, 1");
    }

    @Test
    void case5() {
        test("6, 7, 3, 8, 4");
    }



    void test(String arrStr) {
        int[] arr = arr(arrStr);
        int[] sorted = sorted(arrStr);
        boolean fails = false;

        Solution solution = new Solution();
        solution.quickSort(arr);

        try {
            assertArrayEquals(sorted, arr);
        } catch (Error e) {
            System.err.println("Target arr: " + arrStr);
            System.err.println("Error on testing: ");
            System.err.println(
                    "Expected : " + Arrays.toString(sorted) + "\n" +
                    "Actual   : " + Arrays.toString(arr));
            System.err.println();
            fails = true;
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



    private int[] sorted(String literal) {
        return Arrays.stream(literal.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

}