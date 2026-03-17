package zest;

public class BestTimeToBuyAndSellStock {

    public static final int UPPER_LIMIT_LENGTH = 100000;
    public static final int UPPER_LIMIT_VALUES = 10000;

    /**
     * Returns the maximum profit that can be achieved by
     * buying on one day and selling on a later day.
     *
     * @param prices array of stock prices
     * @return maximum possible profit, or 0 if no profit is possible
     * @throws IllegalArgumentException if prices is null or empty
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        if (prices.length > UPPER_LIMIT_LENGTH) {
            throw new IllegalArgumentException("Input array should have at most 10^5 elements");
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < 0 || price > UPPER_LIMIT_VALUES) {
                throw new IllegalArgumentException(String.format("Value %d is not valid. " +
                        "The values cannot be negative and should be smaller then 10^4", price));
            }

            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

}