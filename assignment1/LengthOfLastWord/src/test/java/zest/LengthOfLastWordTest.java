package zest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LengthOfLastWordTest {
    @Test
    void oneWord () {
        int result =LengthOfLastWord.lengthOfLastWord("Hello");
        assertEquals(5, result);
    }
    @Test
    void multipleWords() {
        int result = LengthOfLastWord.lengthOfLastWord("Hello World World");
        assertEquals(5, result);
    }

    @Test
    void spacesInTheEnd() {
        int result = LengthOfLastWord.lengthOfLastWord("Hello World        ");
        assertEquals(5, result);
    }

    @Test
    void spacesInTheBeginning() {
        int result = LengthOfLastWord.lengthOfLastWord("      Hello");
        assertEquals(5, result);
    }

    @Test
    void multipleSpacesInBetween() {
        int result = LengthOfLastWord.lengthOfLastWord("Hello         World");
        assertEquals(5, result);
    }

    @Test
    void emptyString() {
        int result = LengthOfLastWord.lengthOfLastWord("");
        assertEquals(0, result);
    }

    @Test
    void onlySpaces() {
        int result = LengthOfLastWord.lengthOfLastWord("       ");
        assertEquals(0, result);
    }

    @Test
    void singleCharacter() {
        int result = LengthOfLastWord.lengthOfLastWord("H");
        assertEquals(1, result);
    }

    @Test
    void nullString() {
        assertThrows(IllegalArgumentException.class, () ->
        LengthOfLastWord.lengthOfLastWord(null)
        );
    }
}
