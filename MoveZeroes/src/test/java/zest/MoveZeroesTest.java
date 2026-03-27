package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveZeroesTest {

    @Test
    void basicTest() {
        int[] result = {1, 0, 2, 0, 3};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, result);
    }

    @Test
    void allZeros() {
        int[] result = {0, 0, 0, 0};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{0, 0, 0, 0}, result);
    }

    @Test
    void noZeros() {
        int[] result = {1, 2, 3, 4};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void zerosAtStart() {
        int[] result = {0, 0, 1, 2};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{1, 2, 0, 0}, result);
    }

    @Test
    void zerosAtEnd() {
        int[] result = {1, 2, 0, 0};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{1, 2, 0, 0}, result);
    }

    @Test
    void singleElement() {
        int[] result = {5};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void emptyArray() {
        int[] result = {};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void nullArray() {
        assertThrows(IllegalArgumentException.class, () ->
            MoveZeroes.moveZeroes(null)
        );
    }

    @Test
    void twoElements() {
        int[] result = {0, 1};
        MoveZeroes.moveZeroes(result);
        assertArrayEquals(new int[]{1, 0}, result);
    }
}
