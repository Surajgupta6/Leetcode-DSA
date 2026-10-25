class Solution {
    public int closedIsland(int[][] grid) {
        int closedIslands = 0 ;
        int m= grid.length;
        int n=grid[0].length;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }
    private boolean dfs(int[][] grid,int row,int col){
        if(row<0 || col<0 || col>=grid[0].length || row>=grid.length || grid[row][col] == 1 || grid[row][col] == 2) return true;
        if((row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1) && grid[row][col]==0){
            return false;
        }
        grid[row][col]=2;
        boolean right = dfs(grid,row+1,col);
        boolean down = dfs(grid,row,col+1);
        boolean left = dfs(grid,row-1,col);
        boolean up = dfs(grid,row,col-1);
        return right && down && up && left ;
    }
}