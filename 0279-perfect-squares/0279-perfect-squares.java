class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n]=0;
        for (int j = n-1; j >= 0; j--) {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                if (j + i * i <= n) {
                    int result = dp[j + i * i];
                    if (result != Integer.MAX_VALUE) {
                        ans = Math.min(1 + result, ans);
                    }
                }
            }
            dp[j] = ans;
        }
        return dp[0];
    }
}

class Solution1 {
    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n, 0, dp);
    }

    private int solve(int n, int sum, int[] dp) {
        if (sum > n)
            return Integer.MAX_VALUE;
        if (sum == n) {
            return 0;
        }
        if (dp[sum] != -1)
            return dp[sum];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = solve(n, sum + i * i, dp);
            if (result != Integer.MAX_VALUE) {
                ans = Math.min(1 + result, ans);
            }
        }
        return dp[sum] = ans;
    }
}