package zest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MinCostClimbingStairsTest {

    private MinCostClimbingStairs solver;

    @BeforeEach
    void setUp() {
        solver = new MinCostClimbingStairs();
    }

    @Test
    void boundaryMaxValueAccepted() {
        assertThat(solver.minCostClimbingStairs(new int[]{999, 999})).isEqualTo(999);
    }

    @Test
    void nullInputThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");
    }

    @Test
    void lengthZeroThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(new int[]{}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lengthOneThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(new int[]{5}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lengthTooLargeThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(new int[1001]))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void negativeElementThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(new int[]{1, -1, 2}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tooLargeElementThrows() {
        assertThatThrownBy(() -> solver.minCostClimbingStairs(new int[]{1, 1000, 2}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readmeExampleOne() {
        assertThat(solver.minCostClimbingStairs(new int[]{10, 15, 20})).isEqualTo(15);
    }

    @Test
    void readmeExampleTwo() {
        assertThat(solver.minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})).isEqualTo(6);
    }

    @Test
    void lastStepExpensive() {
        assertThat(solver.minCostClimbingStairs(new int[]{1, 1, 1, 999})).isEqualTo(2);
    }

    @Test
    void maxLengthConstantCost() {
        int[] cost = new int[1000];
        Arrays.fill(cost, 1);
        assertThat(solver.minCostClimbingStairs(cost)).isEqualTo(500);
    }

    @Property
    void resultWithinBounds(@ForAll("validCostArrays") int[] cost) {
        solver = new MinCostClimbingStairs();
        int result = solver.minCostClimbingStairs(cost);
        long sum = 0;
        for (int c : cost) sum += c;
        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat((long) result).isLessThanOrEqualTo(sum);
    }

    @Property
    void twoElementCase(
        @ForAll @IntRange(min = 0, max = 999) int a,
        @ForAll @IntRange(min = 0, max = 999) int b) {
        solver = new MinCostClimbingStairs();
        assertThat(solver.minCostClimbingStairs(new int[]{a, b})).isEqualTo(Math.min(a, b));
    }

    @Property
    void inputImmutable(@ForAll("validCostArrays") int[] cost) {
        solver = new MinCostClimbingStairs();
        int[] before = cost.clone();
        solver.minCostClimbingStairs(cost);
        assertThat(cost).containsExactly(before);
    }

    @Property
    void appendingZeroCannotIncrease(@ForAll("validCostArraysSmall") int[] cost) {
        if (cost.length + 1 > 1000) return;

        solver = new MinCostClimbingStairs();
        int base = solver.minCostClimbingStairs(cost);
        int[] extended = Arrays.copyOf(cost, cost.length + 1);
        extended[cost.length] = 0;
        int extendedResult = solver.minCostClimbingStairs(extended);
        assertThat(extendedResult).isLessThanOrEqualTo(base);
    }

    @Provide
    Arbitrary<int[]> validCostArrays() {
        return Arbitraries.integers().between(0, 999)
            .array(int[].class).ofMinSize(2).ofMaxSize(1000);
    }

    @Provide
    Arbitrary<int[]> validCostArraysSmall() {
        return Arbitraries.integers().between(0, 99)
            .array(int[].class).ofMinSize(2).ofMaxSize(50);
    }
}
