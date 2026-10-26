class Solution {
    public int countIslands(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && dfs(grid,i,j)%k==0){
                    count++;
                }
            }
        }
        return count;
    }
    private long dfs(int[][] grid,int row,int col){
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0 || grid[row][col]==0) return 0;
        long result = 0;
        result+= grid[row][col];
        grid[row][col]=0;
        result+= dfs(grid,row+1,col) + dfs(grid,row,col+1) + dfs(grid,row-1,col) + dfs(grid,row,col-1);
        return result;
    }
}