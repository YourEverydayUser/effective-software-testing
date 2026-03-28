package zest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

public class CompareVersionNumbersTest {

    private static final Logger logger = LoggerFactory.getLogger(CompareVersionNumbersTest.class);
    private static final String TOO_BIG_NUMBER = "2147483648";

    @Test
    public void testSomeInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion(null, "3.0.1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion("3.0.1", null);
        });
    }

    @Test
    public void testWithInvalidVersionNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion("00,1", "1.0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion("1.0",  "00,1");
        });
    }

    @Test
    public void testWithZeroLengthVersion() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion("", "1.0");
        });
    }

    @Test
    public void testWithVersionNumberTooLong() {
        var longVersion = new StringBuilder("1.");
        for(int i = 0; i <= 500; i++) {
            longVersion.append("1").append(".");
        }
        longVersion.append("0");
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion(longVersion.toString(), "1.0");
        });
    }

    @Test
    public void testWithVersionNumberTooBig() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion(TOO_BIG_NUMBER + ".0", "1.0");
        });
    }

    @Test
    public void testVersionNumber1IsBigger() {
        var value = CompareVersionNumbers.compareVersion("2.1.0", "1.9.2");
        AssertEquals(1, value);
    }

    @Test
    public void testVersionNumber2IsBigger() {
        var value = CompareVersionNumbers.compareVersion("1.9.2", "2.1.0");
        AssertEquals(-1, value);
    }

    @Test
    public void testEqualVersionNumbers() {
        var value = CompareVersionNumbers.compareVersion("1.1", "1.1");
        AssertEquals(0, value);
    }

    @Test
    public void testDifferentLengthNumbers() {
        var value = CompareVersionNumbers.compareVersion("1.0.1", "2.0");
        AssertEquals(1, value);
    }

    @Test
    public void testDifferentLengthNumbers2() {
        var value = CompareVersionNumbers.compareVersion("1.0", "2.0.1");
        AssertEquals(-1, value);
    }

    @Test
    public void testVersionsWithLeadingZeros() {
        var value = CompareVersionNumbers.compareVersion("001.10.1", "1.10.1");
        AssertEquals(0, value);
    }

    private static void AssertEquals(Object a, Object b) {
        Assertions.assertEquals(a, b, String.format("Expected %s but got %s", a, b));
        logger.info(() -> "Test successful, got " + b.toString());
    }

    private static <T extends Throwable> void assertThrows(Class<T> expectedException, Runnable throwable) {
        var ex = Assertions.assertThrows(expectedException, throwable::run);
        logger.info(() -> "Caught " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
    }
}
