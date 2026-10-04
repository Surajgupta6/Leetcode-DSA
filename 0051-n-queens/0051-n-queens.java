class Solution {
     public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();  
        char[][] nQueens = new char[n][n]; 
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        solve(n, output, nQueens, 0);
        return output;
    }
    private boolean isSafe(int n, char[][] nQueens, int row, int col) {
        for(int i=0;i<n;i++){
            if(nQueens[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j >=0;i--,j--){
            if(nQueens[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j < n;i--,j++){
            if(nQueens[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    private void solve(int n, List<List<String>> output, char[][] nQueens, int row) {
        if(row==n){
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(n,nQueens,row,i)){
                nQueens[row][i]='Q';
                solve(n,output,nQueens,row+1);
                nQueens[row][i]='.';                
            }
        }
    }
}