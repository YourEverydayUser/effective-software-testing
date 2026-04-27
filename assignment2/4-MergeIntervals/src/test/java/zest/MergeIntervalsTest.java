package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    MergeIntervals solution = new MergeIntervals();

    // Task 1: Coverage
    @Test
    void testExample1() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected, solution.merge(input));
    }

    @Test
    void testExample2() {
        int[][] input = {{1,4},{4,5}};
        int[][] expected = {{1,5}};
        assertArrayEquals(expected, solution.merge(input));
    }

    @Test
    void testEmptyArray() {
        assertArrayEquals(new int[0][], solution.merge(new int[0][]));
    }

    @Test
    void testSingleInterval() {
        int[][] input = {{1,5}};
        int[][] expected = {{1,5}};
        assertArrayEquals(expected, solution.merge(input));
    }

    @Test
    void testNoOverlap() {
        int[][] input = {{1,2},{3,4},{5,6}};
        int[][] expected = {{1,2},{3,4},{5,6}};
        assertArrayEquals(expected, solution.merge(input));
    }

    @Test
    void testAllOverlap() {
        int[][] input = {{1,10},{2,6},{3,8}};
        int[][] expected = {{1,10}};
        assertArrayEquals(expected, solution.merge(input));
    }

    @Test
    void testUnsortedInput() {
        int[][] input = {{8,10},{1,3},{2,6},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected, solution.merge(input));
    }

    // Task 3: Contract tests
    @Test
    void testNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.merge(null));
    }

    @Test
    void testInvalidIntervalLengthThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.merge(new int[][]{{1,2,3}}));
    }

    @Test
    void testStartGreaterThanEndThrows() {
        assertThrows(IllegalArgumentException.class, () -> solution.merge(new int[][]{{5,2}}));
    }

    @Test
    void testTooManyIntervalsThrows() {
        int[][] big = new int[10001][2];
        assertThrows(IllegalArgumentException.class, () -> solution.merge(big));
    }

    // Task 4: Property-based testing
    @Property
    void resultIsNeverLongerThanInput(@ForAll @Size(min=1, max=20) int[] starts, @ForAll @Size(min=1, max=20) int[] ends) {
        int size = Math.min(starts.length, ends.length);
        int[][] intervals = new int[size][2];
        for (int i = 0; i < size; i++) {
            intervals[i][0] = Math.min(starts[i], ends[i]);
            intervals[i][1] = Math.max(starts[i], ends[i]);
        }
        int[][] result = solution.merge(intervals);
        assertTrue(result.length <= intervals.length);
    }

    @Property
    void singleIntervalUnchanged(@ForAll @IntRange(min=-1000, max=1000) int start,
                                 @ForAll @IntRange(min=-1000, max=1000) int end) {
        Assume.that(start <= end);
        int[][] input = {{start, end}};
        int[][] result = solution.merge(input);
        assertEquals(1, result.length);
        assertEquals(start, result[0][0]);
        assertEquals(end, result[0][1]);
    }
}