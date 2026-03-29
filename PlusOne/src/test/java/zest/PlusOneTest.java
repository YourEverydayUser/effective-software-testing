package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class PlusOneTest {

    @Test
    public void testNullCase() {
        assertThatThrownBy(() -> {
            PlusOne.plusOne(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input array cannot be null");
    }

    @Test
    public void testEmptyCase() {
        assertThatThrownBy(() -> {
            PlusOne.plusOne(new int[] {});
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input array cannot be null");
    }

    @Test
    public void test0Case() {
        int[] test = {0};
        test = PlusOne.plusOne(test);
        assertThat(test).isEqualTo(new int[] {1});
    }

    @Test
    public void test9Case() {
        int[] test = {9};
        test = PlusOne.plusOne(test);
        assertThat(test).isEqualTo(new int[] {1, 0});
    }

    @Test
    public void test100Case() {
        int[] test = new int[100];
        int[] result = new int[101];
        result[0] = 1;
        for(int j = 0; j<100; j++){
            test[j] = 9;
        }
        test = PlusOne.plusOne(test);
        assertThat(test).isEqualTo(result);
    }

    @Test
    public void testLeadingZeroes(){
        int[] test = {0, 0, 1, 2};
        test = PlusOne.plusOne(test);
        assertThat(test).isEqualTo(new int[] {0, 0, 1, 3});
    }

    @Test
    public void testLeadingZeroes9(){
        int[] test = {0, 0, 9};
        test = PlusOne.plusOne(test);
        assertThat(test).isEqualTo(new int[] {0, 1, 0});
    }

}