package zest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FindAllDuplicatesInArrayTest {

    private FindAllDuplicatesInArray finder;

    @BeforeEach
    void setUp() {
        finder = new FindAllDuplicatesInArray();
    }

    @Test
    void nullInputThrows() {
        assertThatThrownBy(() -> finder.findDuplicates(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");
    }

    @Test
    void lengthZeroThrows() {
        assertThatThrownBy(() -> finder.findDuplicates(new int[]{}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lengthTooLargeThrows() {
        int[] nums = new int[100_001];
        Arrays.fill(nums, 1);
        assertThatThrownBy(() -> finder.findDuplicates(nums))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void valueTooSmallThrows() {
        assertThatThrownBy(() -> finder.findDuplicates(new int[]{1, 0, 2}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void valueTooLargeThrows() {
        assertThatThrownBy(() -> finder.findDuplicates(new int[]{1, 4, 2}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readmeExampleOne() {
        assertThat(finder.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}))
            .containsExactlyInAnyOrder(2, 3);
    }

    @Test
    void readmeExampleTwo() {
        assertThat(finder.findDuplicates(new int[]{1, 1, 2})).containsExactly(1);
    }

    @Test
    void readmeExampleThree() {
        assertThat(finder.findDuplicates(new int[]{1})).isEmpty();
    }

    @Test
    void noDuplicates() {
        assertThat(finder.findDuplicates(new int[]{3, 1, 2, 5, 4})).isEmpty();
    }

    @Test
    void everyValueDuplicated() {
        assertThat(finder.findDuplicates(new int[]{1, 1, 2, 2, 3, 3}))
            .containsExactlyInAnyOrder(1, 2, 3);
    }

    @Property
    void resultsInRange(@ForAll("validArrays") int[] nums) {
        finder = new FindAllDuplicatesInArray();
        List<Integer> result = finder.findDuplicates(nums);
        for (int v : result) {
            assertThat(v).isBetween(1, nums.length);
        }
    }

    @Property
    void sizeBound(@ForAll("validArrays") int[] nums) {
        finder = new FindAllDuplicatesInArray();
        assertThat(finder.findDuplicates(nums).size())
            .isLessThanOrEqualTo(nums.length / 2);
    }

    @Property
    void inputImmutable(@ForAll("validArrays") int[] nums) {
        finder = new FindAllDuplicatesInArray();
        int[] before = nums.clone();
        finder.findDuplicates(nums);
        assertThat(nums).containsExactly(before);
    }

    @Property
    void matchesExpectedDuplicates(@ForAll("validArrays") int[] nums) {
        finder = new FindAllDuplicatesInArray();
        Set<Integer> expected = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int v : nums) {
            if (!seen.add(v)) expected.add(v);
        }
        assertThat(finder.findDuplicates(nums)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Provide
    Arbitrary<int[]> validArrays() {
        return Arbitraries.integers().between(1, 15).flatMap(n ->
            Arbitraries.integers().between(1, n)
                .array(int[].class).ofSize(n)
                .filter(arr -> {
                    int[] count = new int[n + 1];
                    for (int v : arr) {
                        if (++count[v] > 2) return false;
                    }
                    return true;
                })
        );
    }
}
