class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        Boolean[][] dp = new Boolean[nums.length][20001];
        return solve(nums,sum,0,0,dp);
    }
    private boolean solve(int nums[],int total_sum,int initial_sum,int i,Boolean[][] dp){
        if(i==nums.length && total_sum-initial_sum==initial_sum) return true;
        if(i==nums.length && total_sum-initial_sum!=initial_sum) return false;
        if(dp[i][initial_sum]!=null) return dp[i][initial_sum];
        boolean take = false;
        boolean skip = false;
        take = solve(nums,total_sum,initial_sum+nums[i],i+1,dp);
        skip = solve(nums,total_sum,initial_sum,i+1,dp);
        return dp[i][initial_sum] = take || skip;
    }
}