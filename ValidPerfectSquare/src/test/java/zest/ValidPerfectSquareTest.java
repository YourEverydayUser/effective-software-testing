package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidPerfectSquareTest {
    @Test
    public void testCase() {
        int test = 1;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test0Case() {
        assertThatThrownBy(() -> {
            ValidPerfectSquare.isPerfectSquare(0);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input must be positive");
    }

    @Test
    public void testNegativeCase() {
        assertThatThrownBy(() -> {
            ValidPerfectSquare.isPerfectSquare(-1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input must be positive");
    }

    @Test
    public void testFalseCase() {
        int test = 2;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void testTrueCase() {
        int test = 4;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void testMaxCase(){
        int test = Integer.MAX_VALUE;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void testBigFalseCase(){
        int test = 65 * 65 + 1;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void testBigTrueCase(){
        int test = 65 * 65;
        boolean result = ValidPerfectSquare.isPerfectSquare(test);
        assertThat(result).isEqualTo(true);
    }



}