package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FindFirstOccurrenceTest {


    @Test
    public void testBothNull() {
        String first = null;
        String second = null;
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null or empty");
    }

    @Test
    public void testFirstNull() {
        String first = null;
        String second = "abc";
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null or empty");
    }

    @Test
    public void testSecondNull() {
        String first = "avd";
        String second = null;
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null");
    }

    @Test
    public void testBothEmpty() {
        String first = "";
        String second = "";
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null or empty");
    }


    @Test
    public void testFirstEmpty() {
        String first = "";
        String second = "abc";
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null or empty");
    }

    @Test
    public void testSecondEmpty() {
        String first = "avd";
        String second = "";
        assertThatThrownBy(() -> {
            FindFirstOccurrence.strStr(first, second);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input strings cannot be null");
    }

    @Test
    public void testBothOneTrue() {
        String first = "a";
        String second = "a";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testBothOneFalse() {
        String first = "a";
        String second = "f";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void testLongFalse() {
        String first = "c";
        first = first.repeat(10000);
        String second = "f";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void testLongTrue() {
        String first = "c";
        first = first.repeat(10000);
        String second = first;
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testLongShortTrue() {
        String first = "c";
        first = first.repeat(9999);
        first = first + "g";
        String second = "g";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(9999);
    }

    @Test
    public void testNeedleLongerFalse() {
        String first = "cdfg";
        String second = "ferecdfgrhrtgh";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void testMultiple() {
        String first = "ferecdfgrhrtghcdfg";
        String second = "cdf";
        int result = FindFirstOccurrence.strStr(first, second);
        assertThat(result).isEqualTo(4);
    }


}