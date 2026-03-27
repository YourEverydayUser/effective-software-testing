package zest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LongestCommonPrefixTest {

    @Test
    public void testNullCase(){
        String[] s = null;
        assertThatThrownBy(() -> {
            LongestCommonPrefix.longestCommonPrefix(s);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input array cannot be null");
    }

    @Test
    public void testEmptyCase(){
        String[] s = {};
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testEmptyEntryCase(){
        String[] s = {""};
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testOneEntryCase(){
        String[] s = {"Hello"};
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("Hello");
    }

    @Test
    public void testTwoEntriesCase(){
        String[] s = {"HelloWorld", "HellWorld"};
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("Hell");
    }

    @Test
    public void testOneLetterStringCase(){
        String[] s = {"HelloWorld", "H"};
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("H");
    }

    @Test
    public void testTwoHundredEntriesCase(){
        String[] s = new String[200];
        Arrays.fill(s, "Hello");
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("Hello");
    }

    @Test
    public void testTwoHundredEntriesDiffCase(){
        String[] s = new String[200];
        Arrays.fill(s, "Hello");
        s[90] = "UT";
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testLongEntriesCase(){
        String[] s = new String[200];
        Arrays.fill(s, "aaHello");
        String a = "a";
        a = a.repeat(200);
        s[99] = a;
        String result = LongestCommonPrefix.longestCommonPrefix(s);
        assertThat(result).isEqualTo("aa");
    }






}