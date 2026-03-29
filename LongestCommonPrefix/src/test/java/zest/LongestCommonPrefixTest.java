package zest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonPrefixTest {

    @Test
    void commonPrefixExists() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"brother", "bread", "breast"});
        assertEquals("br", result);
    }

    @Test
    void allStringsIdentical() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"bro", "bro", "bro", "bro"});
        assertEquals("bro", result);
    }

    @Test
    void entireFirstWordIsPrefix() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"bro", "brother", "brotherhood"});
        assertEquals("bro", result);
    }

    @Test
    void noCommonPrefix() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"brother", "sister", "father"});
        assertEquals("", result);
    }

    @Test
    void emptyArray() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{});
        assertEquals("", result);
    }

    @Test
    void singleStringInArray() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"brother"});
        assertEquals("brother", result);
    }

    @Test
    void oneStringIsEmpty() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"brother", ""});
        assertEquals("", result);
    }

    @Test
    void singleCharacterPrefix() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"ab", "ad", "abc"});
        assertEquals("a", result);
    }

    @Test
    void firstStringIsLongest() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"greatest", "grade", "grok"});
        assertEquals("gr", result);
    }

    @Test
    void nullArray() {
        assertThrows(IllegalArgumentException.class, () ->
                LongestCommonPrefix.longestCommonPrefix(null)
        );
    }

    @Test
    void differentSingleCharacters() {
        String result = LongestCommonPrefix.longestCommonPrefix(new String[]{"a", "b"});
        assertEquals("", result);
    }

}