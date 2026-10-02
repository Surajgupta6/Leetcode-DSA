class Solution {
    public int islandPerimeter(int[][] grid) {
        int boundary = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    boundary += dfs(grid,i,j);
                    return boundary;
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[row].length || grid[row][col]==0){
            return 1;
        }
        if(grid[row][col]==-1) return 0;
        grid[row][col] = -1;
        return dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row + 1, col) + dfs(grid, row, col - 1);
    }
}