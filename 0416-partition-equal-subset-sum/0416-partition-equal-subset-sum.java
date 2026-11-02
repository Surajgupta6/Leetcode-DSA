class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = n - 1; i >=0 ; i--) {
            for (int j = 1; j <= target; j++) {
                boolean take = false;
                boolean skip = dp[i + 1][j];
                if(j>=nums[i]){
                    take = dp[i + 1][j - nums[i]];
                }
                dp[i][j] = take || skip;
            }
        }
        return dp[0][target];
    }
}

class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return solve(nums, target, 0, dp);
    }

    private boolean solve(int nums[], int target, int i, Boolean[][] dp) {
        if (target == 0)
            return true;
        if (i == nums.length || target < 0)
            return false;
        if (dp[i][target] != null)
            return dp[i][target];
        boolean take = false;
        boolean skip = false;
        take = solve(nums, target - nums[i], i + 1, dp);
        skip = solve(nums, target, i + 1, dp);
        return dp[i][target] = take || skip;
    }
}