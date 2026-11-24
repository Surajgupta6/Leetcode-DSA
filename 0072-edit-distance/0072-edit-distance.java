class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Base case: word1 is exhausted
        for(int j = 0; j <= n; j++) {
            prev[j] = n - j;
        }
        //Use for bottom up of memo
        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 0; i <= m; i++) {
        //     dp[i][n] = m - i;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[m][i] = n - i;
        // }

        // Optimal with O(n) Space
        for (int i = m - 1; i >= 0; i--) {
            curr[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                if (word2.charAt(j) == word1.charAt(i)) {
                    curr[j] = prev[j+1];
                } else {
                    int replace = 1 + prev[j + 1];
                    int delete = 1 + prev[j];
                    int insert = 1 + curr[j + 1];
                    curr[j] = Math.min(delete, Math.min(insert, replace));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[0];
    }



    // Memo
    // private int solve(String word1,String word2,int idx1,int idx2,Integer[][] dp){
    //     if(idx1 == word1.length()) return word2.length() - idx2;
    //     if(idx2 == word2.length()) return word1.length() - idx1;
    //     if(dp[idx1][idx2]!=null){
    //         return dp[idx1][idx2];
    //     }
    //     if(word2.charAt(idx2)==word1.charAt(idx1)){
    //         return solve(word1,word2,idx1+1,idx2+1,dp);
    //     }
    //     int replace = 1 + solve(word1,word2,idx1+1,idx2+1,dp);
    //     int delete = 1 + solve(word1,word2,idx1+1,idx2,dp);
    //     int insert = 1 + solve(word1,word2,idx1,idx2+1,dp);
    //     return dp[idx1][idx2] = Math.min(delete,Math.min(insert,replace));
    // }
}