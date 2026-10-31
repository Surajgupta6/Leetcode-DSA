class Solution {
    int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        dp[m - 1][n - 1][0] = 1;
        dp[m - 1][n - 1][1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                if (grid[i][j] == 1) {
                    dp[i][j][0] = (i+1<m)?dp[i + 1][j][1]:0;
                    dp[i][j][1] = (j+1<n)?dp[i][j+1][0]:0;
                } else {
                    int down = (j+1<n)?dp[i][j+1][0]:0;
                    int right = (i+1<m)?dp[i + 1][j][1]:0;
                    int ans = (right + down) % MOD;
                    dp[i][j][0]=ans;
                    dp[i][j][1]=ans;
                }
            }
        }
        return grid[0][0]==1?0:dp[0][0][0];
    }
}

class Solution1 {
    int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(grid, 0, 0, -1, dp);
    }

    private int solve(int[][] grid, int row, int col, int dir, int[][][] dp) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        if (row >= grid.length || col >= grid[0].length)
            return 0;

        if (dir != -1 && dp[row][col][dir] != -1) {
            return dp[row][col][dir];
        }

        int ans = 0;
        if (grid[row][col] == 1) {
            if (dir == 0) {
                ans = solve(grid, row + 1, col, 1, dp);
            }
            if (dir == 1) {
                ans = solve(grid, row, col + 1, 0, dp);
            }
            return ans;
        } else {
            ans = (solve(grid, row, col + 1, 0, dp) + solve(grid, row + 1, col, 1, dp)) % MOD;
        }
        if (dir != -1) {
            dp[row][col][dir] = ans;
        }
        return ans;
    }
}