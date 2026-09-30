class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        return solve(triangle,0,0,dp);
    }
    private int solve(List<List<Integer>> triangle,int idx,int level,int[][] dp){
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(idx);
        }
        if(dp[level][idx]!=Integer.MAX_VALUE) return dp[level][idx];
        return dp[level][idx]=triangle.get(level).get(idx)+Math.min(solve(triangle,idx,level+1,dp),solve(triangle,idx+1,level+1,dp));
    }
}
