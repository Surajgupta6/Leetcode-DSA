class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp = new int[amount + 1][n+1];
        Arrays.fill(dp[0], 1);
        for (int a = 1; a <= amount; a++) {
            for (int idx = n - 1; idx >= 0; idx--) {

                int count = 0;

                for (int i = idx; i < n; i++) {
                    if (a >= coins[i]) {
                        count += dp[a - coins[i]][i];
                    }
                }

                dp[a][idx] = count;
            }
        }
        return dp[amount][0];
    }
}

class Solution1 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(amount, coins, 0, dp);
    }

    private int solve(int amount, int[] coins, int idx, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0)
            return 0;
        if (dp[amount][idx] != -1)
            return dp[amount][idx];
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            count += solve(amount - coins[i], coins, i, dp);
        }
        return dp[amount][idx] = count;
    }
}