class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int maxL=1;
        int idx=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j = i+L-1;
                if(s.charAt(i)==s.charAt(j) && L==2){
                    dp[i][j]=true;
                    maxL=2;
                    idx=i;
                }
                else if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(j-i+1>maxL){
                        maxL=j-i+1;
                        idx=i;
                    }
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return s.substring(idx,idx+maxL);
    }
}