class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = solve(coins, amount, dp);
        return result == amount + 1 ? -1 : result;
    }

    private int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        int minCoins = amount + 1;
        for (int coin : coins) {
            if (coin <= amount) {
                minCoins = Math.min(minCoins, solve(coins, amount - coin, dp) + 1);
            }
        }
        return dp[amount] = minCoins;
    }
}
