class Solution1 {
    public int minFallingPathSum(int[][] matrix) {  // Bottom-UP
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < n; i++) {
            dp[m-1][i]=matrix[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int down = dp[i+1][j];

                if(j > 0){
                    left = dp[i+1][j-1];
                }
                if(j < n-1){
                    right = dp[i+1][j+1];
                }
                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }
        }        
        for (int i = 0; i < matrix.length; i++) {
            result = Math.min(result,dp[0][i]);
        }
        return result;
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {  // Top-Down 
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix.length; i++) {
            result = Math.min(result, solve(matrix, 0, i, dp));
        }
        return result;
    }

    private int solve(int[][] matrix, int row, int col, int[][] dp) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        int left = solve(matrix, row + 1, col - 1, dp);
        int right = solve(matrix, row + 1, col, dp);
        int down = solve(matrix, row + 1, col + 1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
    }
}