class Solution1 {  // Memoization
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,0,dp),solve(cost,1,0,dp));
    }
    private int solve(int[] cost,int idx,int price,int[] dp){
        if(idx>=cost.length){
            return price;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        return Math.min(solve(cost,idx+1,price+cost[idx],dp),solve(cost,idx+2,price+cost[idx],dp));
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n+1];
        dp[n]=0;
        for(int idx=n-1;idx>=0;idx--){
            dp[idx]=cost[idx]+Math.min(dp[idx+1],(idx+2<=n)?dp[idx+2]:0);
        }
        return Math.min(dp[0],dp[1]);
    }
}