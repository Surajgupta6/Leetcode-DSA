class Solution {
    int result=Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result=Math.max(result,dfs(matrix,i,j,dp));
            }
        }
        return result;
    }
    private int dfs(int[][] matrix,int row,int col,int[][] dp){
        result = 1;
        if(dp[row][col]!=0) return dp[row][col];
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            result=Math.max(result,1+dfs(matrix, row + 1, col,dp));
        }
        if (col + 1 < matrix[0].length && matrix[row][col+1] > matrix[row][col]) {
            result=Math.max(result,1+dfs(matrix, row , col + 1,dp));
        }
        if (col -1 >= 0 && matrix[row][col-1] > matrix[row][col]) {
            result=Math.max(result,1+dfs(matrix, row , col - 1,dp));
        }
        if (row -1 >=0 && matrix[row-1][col] > matrix[row][col]) {
            result=Math.max(result,1+dfs(matrix, row -1 , col ,dp));
        }
        dp[row][col]=result;
        return result;
    }
}