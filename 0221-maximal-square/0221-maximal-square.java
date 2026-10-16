class Solution {
    int maxSide=0;
    public int maximalSquare(char[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        int dp[][] = new int [m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int right = dp[i+1][j];
                int down = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                if(matrix[i][j]=='1'){
                int side=1+Math.min(right,Math.min(down,diagonal));
                maxSide=Math.max(side,maxSide);
                dp[i][j]=side;
                }
            }
        }
        return maxSide*maxSide;
    }
}