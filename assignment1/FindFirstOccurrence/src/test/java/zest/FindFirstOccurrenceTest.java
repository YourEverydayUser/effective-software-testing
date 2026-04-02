package zest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindFirstOccurrenceTest {
    @Test
    void foundAtStart() {
        int result = FindFirstOccurrence.strStr("sadbutsad", "sad");
        assertEquals(0, result);
    }

    @Test
    void foundAtMiddle() {
        int result = FindFirstOccurrence.strStr("sadbutsad", "but");
        assertEquals(3, result);
    }

    @Test
    void foundAtEnd() {
        int result = FindFirstOccurrence.strStr("sadbutasd", "asd");
        assertEquals(6, result);
    }

    @Test
    void notFoundAtAll() {
        int result = FindFirstOccurrence.strStr("sadbutsad", "happy");
        assertEquals(-1, result);
    }

    @Test
    void singleCharMatch() {
        int result = FindFirstOccurrence.strStr("s", "s");
        assertEquals(0, result);
    }

    @Test
    void singleCharNoMatch() {
        int result = FindFirstOccurrence.strStr("s", "a");
        assertEquals(-1, result);
    }

    @Test
    void MatchAtLastLoopItteration() {
        int result = FindFirstOccurrence.strStr("sad", "d");
        assertEquals(2, result);
    }

    @Test
    void partialMatch() {
        int result = FindFirstOccurrence.strStr("sad", "ab");
        assertEquals(-1, result);
    }

    @Test
    void nullHaystack() {
        assertThrows(IllegalArgumentException.class, () ->
                FindFirstOccurrence.strStr(null, "sad")
        );
    }

    @Test
    void nullNeedle() {
        assertThrows(IllegalArgumentException.class, () ->
                FindFirstOccurrence.strStr("sadbutsad", null)
                );
    }

    @Test
    void NeedleLongerThanHaystack() {
        int result = FindFirstOccurrence.strStr("sad", "sadbutsad");
        assertEquals(-1, result);
    }
}