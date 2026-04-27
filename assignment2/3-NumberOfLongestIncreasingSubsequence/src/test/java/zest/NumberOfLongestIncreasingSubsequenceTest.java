package zest;

import java.util.Arrays;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfLongestIncreasingSubsequenceTest {

    NumberOfLongestIncreasingSubsequence solution = new NumberOfLongestIncreasingSubsequence();

    // Task 1: Coverage
    @Test
    void testExample1() {
        assertEquals(2, solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    @Test
    void testExample2() {
        assertEquals(5, solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }

    @Test
    void testSingleElement() {
        assertEquals(1, solution.findNumberOfLIS(new int[]{5}));
    }

    @Test
    void testAllIncreasing() {
        assertEquals(1, solution.findNumberOfLIS(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testAllDecreasing() {
        assertEquals(5, solution.findNumberOfLIS(new int[]{5, 4, 3, 2, 1}));
    }

    // Task 3: Contract tests
    @Test
    void testNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.findNumberOfLIS(null));
    }

    @Test
    void testEmptyArrayThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.findNumberOfLIS(new int[]{}));
    }

    @Test
    void testElementTooLargeThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.findNumberOfLIS(new int[]{1000001}));
    }

    @Test
    void testElementTooSmallThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.findNumberOfLIS(new int[]{-1000001}));
    }

    // Task 4: Property-based testing
    @Property
    void resultAlwaysPositive(@ForAll @Size(min=1, max=2000) int[] nums) {
        Assume.that(Arrays.stream(nums).allMatch(x -> x >= -1000000 && x <= 1000000));
        assertTrue(solution.findNumberOfLIS(nums) >= 1);
    }

    @Property
    void singleElementAlwaysOne(@ForAll int value) {
        Assume.that(value >= -1000000 && value <= 1000000);
        assertEquals(1, solution.findNumberOfLIS(new int[]{value}));
    }
}