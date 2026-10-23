class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int result=solve(coins, amount,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int[] coins, int amount,int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0)
            return Integer.MAX_VALUE;
        
        if(dp[amount]!=-1) return dp[amount];
        
        int minCoins = Integer.MAX_VALUE;
        
        for (int i = 0; i < coins.length; i++) { 
            int subResult = solve(coins, amount - coins[i],dp); 
            if (subResult != Integer.MAX_VALUE) { 
                minCoins = Math.min(minCoins, subResult + 1); 
            } 
        } 
        return dp[amount]=minCoins;
    }
}