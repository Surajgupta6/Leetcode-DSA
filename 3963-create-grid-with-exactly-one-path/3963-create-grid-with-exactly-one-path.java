class Solution {
    public String[] createGrid(int m, int n) {
        char[][] result = new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(result[i],'#');
        }
        for(int i=0;i<m;i++){
            result[i][0]='.';
        }
        for(int j=0;j<n;j++){
            result[m-1][j]='.';
        }
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(result[i][j]);
            }
            ans[i]=sb.toString();
        }
        return ans;
    }
}