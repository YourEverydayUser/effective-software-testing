package zest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveZeroesTest {

    @Test
    public void testNullCase(){
        int[] s = null;
        assertThatThrownBy(() -> {
            MoveZeroes.moveZeroes(s);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array cannot be null");
    }

    @Test
    public void testEmptyCase() {
        int[] s = {};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {});
    }

    @Test
    public void testLengthOneCase(){
        int[] s = {1};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {1});
    }

    @Test
    public void testOnlyZeroesCase(){
        int[] s = {0, 0, 0, 0};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {0, 0, 0, 0});
    }

    @Test
    public void testNoZeroesCase(){
        int[] s = {4, 50, 7, 8};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {4, 50, 7, 8});
    }

    @Test
    public void testNegativeNumbersCase(){
        int[] s = {-4, 50, 0, -7, 8};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {-4, 50, -7, 8, 0});
    }

    @Test
    public void testMultipleZeroes(){
        int[] s = {0, 5, 50, 0, -7, 8};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {5, 50, -7, 8, 0, 0});
    }

    @Test
    public void testCreativeZeroes(){
        int[] s = {0, 0, -888885, 1111110, 0, -7, Integer.MIN_VALUE, Integer.MAX_VALUE};
        MoveZeroes.moveZeroes(s);
        assertThat(s).isEqualTo(new int[] {-888885, 1111110, -7, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0});
    }

    @Test
    public void testBigArray(){
        int[] s = new int[1000000];
        s[89875] = 99;
        MoveZeroes.moveZeroes(s);
        int[] result = new int[1000000];
        result[0] = 99;
        assertThat(s).isEqualTo(result);
    }


}