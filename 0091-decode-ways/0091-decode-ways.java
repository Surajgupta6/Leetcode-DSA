class Solution {
    int count;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(s,0,dp);
    }
    private int dfs(String s, int idx,int[] dp) {
        if (idx == s.length()) {
            return 1;
        }
        if(s.charAt(idx)=='0') return 0;
        if (dp[idx]!=-1) return dp[idx];
        int count = dfs(s, idx + 1,dp);
        if (idx + 1 < s.length()) {
            int two = Integer.parseInt(s.substring(idx, idx + 2));
            if (two >= 10 && two <= 26) { 
                count += dfs(s, idx + 2, dp);
            }
        }
        dp[idx] = count; 
        return count;
    }
}