class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= 2; j++) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][j][0];
                        int skip = dp[i + 1][j][1];
                        dp[i][j][buy] = Math.max(take, skip);
                    } else {
                        int take = prices[i] + dp[i + 1][j - 1][1];
                        int skip = dp[i + 1][j][0];
                        dp[i][j][buy] = Math.max(take, skip);
                    }
                }
            }
        }
        return dp[0][2][1];
    }
}