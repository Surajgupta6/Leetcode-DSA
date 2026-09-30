class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length-1]=0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int result = Integer.MAX_VALUE;
            for (int start = i + 1; start <= i + nums[i] && start < nums.length; start++) {
                int count = dp[start];
                if (count != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + count);
                }
            }
            dp[i]=result;
        }
        return dp[0];
    }
}