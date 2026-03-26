package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SortColorsTest {


    @Test
    public void testNullCase() {
        assertThatThrownBy(() -> {
            SortColors.sortColors(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input array cannot be null");
    }

    @Test
    public void testEmptyCase() {
        int[] test = {};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {});
    }

    @Test
    public void test0Case() {
        int[] test = {0};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0});
    }

    @Test
    public void testSortedCase() {
        int[] test = {0, 1, 2};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0, 1, 2});
    }

    @Test
    public void testUnSortedCase() {
        int[] test = {0, 2, 2, 1, 1, 0, 2};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0, 0, 1, 1, 2, 2, 2});
    }

    @Test
    public void testAll0Case() {
        int[] test = {0, 0, 0, 0};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0, 0, 0, 0});
    }

    @Test
    public void testTwoColorCase() {
        int[] test = {1, 1, 1, 0};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0, 1, 1, 1});
    }

    @Test
    public void testAlternatingCase() {
        int[] test = {0, 1, 0, 1, 0, 1, 0};
        SortColors.sortColors(test);
        assertThat(test).isEqualTo(new int[] {0, 0, 0, 0, 1, 1, 1});
    }


}