class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') dp[i]=0;
            else{
                dp[i]=dp[i+1];
                if(i<n-1){
                    int two = Integer.parseInt(s.substring(i, i + 2));
                    if (two >= 10 && two <= 26) { 
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        return dp[0];
    }
}