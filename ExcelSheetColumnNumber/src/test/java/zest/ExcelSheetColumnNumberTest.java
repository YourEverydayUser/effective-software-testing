package zest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class ExcelSheetColumnNumberTest {

    private static final Logger logger = LoggerFactory.getLogger(ExcelSheetColumnNumberTest.class);

    @Test
    public void testColumnTitleNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExcelSheetColumnNumber.titleToNumber(null);
        });
    }

    @Test
    public void testEmptyColumnTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExcelSheetColumnNumber.titleToNumber("");
        });
    }

    @Test
    public void testInvalidColumnTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExcelSheetColumnNumber.titleToNumber("123");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ExcelSheetColumnNumber.titleToNumber("A1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ExcelSheetColumnNumber.titleToNumber("aB");
        });
    }

    @Test
    public void testValidColumnTitles() {
        AssertEquals(1, ExcelSheetColumnNumber.titleToNumber("A"));
        AssertEquals(28, ExcelSheetColumnNumber.titleToNumber("AB"));
        AssertEquals(701, ExcelSheetColumnNumber.titleToNumber("ZY"));
        AssertEquals(18278, ExcelSheetColumnNumber.titleToNumber("ZZZ"));
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