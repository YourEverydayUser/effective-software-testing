package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LengthOfLastWordTest {

    @Test
    public void testNullCase(){
        String s = null;
        assertThatThrownBy(() -> {
            LengthOfLastWord.lengthOfLastWord(s);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input string cannot be null or empty");
    }

    @Test
    public void testEmptyCase(){
        String s = "";
        assertThatThrownBy(() -> {
            LengthOfLastWord.lengthOfLastWord(s);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input string cannot be null or empty");
    }

    @Test
    public void testOneLetter() {
        String s = "f";
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testLongString() {
        String s = "c";
        s = s.repeat(10000);
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(10000);
    }

    @Test
    public void testMultipleSpaces() {
        String s = "  f ";
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testTrailingSpaces() {
        String s = "f  ";
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testMultipleWords() {
        String s = "Dies   ist ein TesT";
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void testSpaces() {
        String s = "  ";
        int result = LengthOfLastWord.lengthOfLastWord(s);
        assertThat(result).isEqualTo(0);
    }

}