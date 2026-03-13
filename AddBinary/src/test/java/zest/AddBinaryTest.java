package zest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

public class AddBinaryTest {

    private static final Logger logger = LoggerFactory.getLogger(AddBinary.class);

    @Test
    public void testWithNullValuesForInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AddBinary.addBinary(null, null);
        });
    }

    @Test
    public void testWithOneZeroLengthInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AddBinary.addBinary("", "");
        });
    }

    @Test
    public void testWithNumbersStartingWithZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AddBinary.addBinary("0011", "011");
        });
    }

    @Test
    public void testWithBiggerThenUpperBoundBinaryNumber() {
        var number = getPaddedBinaryNumber(10001);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AddBinary.addBinary(number, "1");
        });
    }

    @Test
    public void testOnUpperBound() {
        var number = getPaddedBinaryNumber(10000);
        var result = AddBinary.addBinary(number, "1");
        AssertEquals(result, number.substring(
                0, number.length() - 1) + "1");
    }

    @Test
    public void testWithOneLengthInputs() {
        var result = AddBinary.addBinary("1", "0");
        AssertEquals("1", result);
    }

    @Test
    public void testZeroResult() {
        var result = AddBinary.addBinary("0", "0");
        AssertTrue(() -> result.equals("0"), result);
    }

    @Test
    public void testWithEqualLengthStringsAndCarryOver() {
        var result = AddBinary.addBinary("1101", "11");
        AssertEquals("10000", result);
    }

    @Test
    public void testWithEqualLengthStringsWithoutCarryOver() {
        var result = AddBinary.addBinary("1001", "11");
        AssertEquals("1100", result);
    }

    @Test
    public void testWithUnequalLengthALargerThenB() {
        var result = AddBinary.addBinary("100", "11");
        AssertEquals("111", result);
    }

    @Test
    public void testWithUnequalLengthBLargerThenA() {
        var result = AddBinary.addBinary("11", "100");
        AssertEquals("111", result);
    }

    private static void AssertTrue(Supplier<Boolean> condition, Object result) {
        Assertions.assertTrue(condition.get());
        logger.info(() -> "Test successful, got " + result.toString());
    }

    private static void AssertEquals(Object a, Object b) {
        Assertions.assertEquals(a, b, String.format("Expected %s but got %s", a, b));
        logger.info(() -> "Test successful, got " + b.toString());
    }

    private static String getPaddedBinaryNumber(int length) {
        var builder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if (i == length-1) {
                builder.append("1");
                continue;
            }

            builder.append("0");
        }

        return builder.reverse().toString();
    }
}