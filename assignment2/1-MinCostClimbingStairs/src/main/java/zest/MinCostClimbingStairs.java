package zest;

public class MinCostClimbingStairs {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 1000;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 999;

    public int minCostClimbingStairs(int[] cost) {
        validate(cost);

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    private static void validate(int[] cost) {
        if (cost == null) {
            throw new IllegalArgumentException("cost array must not be null");
        }

        if (cost.length < MIN_LENGTH || cost.length > MAX_LENGTH) {
            throw new IllegalArgumentException(
                "cost length must be in [" + MIN_LENGTH + ", " + MAX_LENGTH + "], got " + cost.length);
        }

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < MIN_VALUE || cost[i] > MAX_VALUE) {
                throw new IllegalArgumentException(
                    "cost[" + i + "] must be in [" + MIN_VALUE + ", " + MAX_VALUE + "], got " + cost[i]);
            }
        }
    }
}
