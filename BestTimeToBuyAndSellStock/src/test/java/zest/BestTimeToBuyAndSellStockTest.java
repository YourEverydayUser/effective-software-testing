package zest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;


public class BestTimeToBuyAndSellStockTest {

    private static final Logger logger = LoggerFactory.getLogger(BestTimeToBuyAndSellStockTest.class);

    @Test
    public void testWithNullArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BestTimeToBuyAndSellStock.maxProfit(null);
        });
    }

    @Test
    public void testWithEmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BestTimeToBuyAndSellStock.maxProfit(new int[0]);
        });
    }

    @Test
    public void testWithArrayLengthOnBoundary() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(new int[
                BestTimeToBuyAndSellStock.UPPER_LIMIT_LENGTH]);
        AssertEquals(0, profit);
    }

    @Test
    public void testWithArrayTooLarge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BestTimeToBuyAndSellStock.maxProfit(new int[
                    BestTimeToBuyAndSellStock.UPPER_LIMIT_LENGTH + 1]);
        });
    }

    @Test
    public void testWithNegativeValueInArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BestTimeToBuyAndSellStock.maxProfit(getArrayOf(0, 1, -5, 2));
        });
    }

    @Test
    public void testWithValueTooBig() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BestTimeToBuyAndSellStock.maxProfit(getArrayOf(0, 1, 9999,
                    BestTimeToBuyAndSellStock.UPPER_LIMIT_VALUES + 1));
        });
    }

    @Test
    public void testWithSingleDayPriceArray() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(getArrayOf(1));
        AssertTrue(() -> profit == 0, profit);
    }

    @Test
    public void testWithAscendingValuesArray() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(getArrayOf(1, 2, 3, 4, 5, 10000));
        AssertEquals(9999, profit);
    }

    @Test
    public void testWithDescendingValuesArray() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(getArrayOf(5, 4, 3, 2, 1));
        AssertEquals(0, profit);
    }

    @Test
    public void testWithConstantValuesArray() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(getArrayOf(5, 5, 5, 5));
        AssertEquals(0, profit);
    }

    @Test
    public void testWithTwoMaxima() {
        var profit = BestTimeToBuyAndSellStock.maxProfit(getArrayOf(1, 3, 2, 3, 1, 5));
        AssertEquals(4, profit);
    }

    private static void AssertTrue(Supplier<Boolean> condition, Object result) {
        Assertions.assertTrue(condition.get());
        logger.info(() -> "Test successful, got " + result.toString());
    }

    private static void AssertEquals(Object a, Object b) {
        Assertions.assertEquals(a, b, String.format("Expected %s but got %s", a, b));
        logger.info(() -> "Test successful, got " + b.toString());
    }

    private static int[] getArrayOf(int... args) {
        return args;
    }
}