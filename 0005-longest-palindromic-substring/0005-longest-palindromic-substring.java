class Solution {
    int start=0;
    int end=0;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<2){
            return s;
        }
        findLongest(s.toCharArray(),0);
        return s.substring(start,end+1);
    }
    private void findLongest(char[] s,int m){
        if(s.length - m < (end-start)/2){
            return;
        }
        int i=m;
        int j=m;

        while(j<s.length-1 && s[j]==s[j+1]){
            j++;
        }
        m=j;
        while(i-1>=0 && j+1<s.length && s[i-1]==s[j+1]){
            i--;
            j++;
        }
        if (end - start < j - i) {
            start = i;
            end = j;
        }
        findLongest(s, m + 1);
    }
}