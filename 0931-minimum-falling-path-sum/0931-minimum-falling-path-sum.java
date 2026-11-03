class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int[][] dp;
        for (int i = 0; i < matrix.length; i++) {
            dp = new int[matrix.length][matrix[0].length];
            for(int[] arr:dp){
                Arrays.fill(arr,Integer.MAX_VALUE);
            }
            result = Math.min(result, solve(matrix, 0, i,dp));
        }
        return result;
    }

    private int solve(int[][] matrix, int row, int col,int[][] dp) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        int left = solve(matrix, row + 1, col - 1,dp);
        int right = solve(matrix, row + 1, col,dp);
        int down = solve(matrix, row + 1, col + 1,dp);

        return dp[row][col] = matrix[row][col] + Math.min(down,Math.min(left,right));
    }
}