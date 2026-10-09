class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for(int i=0;i<grid.length && !found;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i,j});
                    grid[i][j]=2;
                    found=true;
                    break;
                }
            }
        }
        int[][] dir = {{ 1, 0 },{ -1, 0 },{ 0, 1 },{0, -1 } };
        while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length) continue;
                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });
                    }
                }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int length=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] node=queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length) continue;
                    if (grid[nr][nc]==1){
                        return length;
                    }
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            length++;
        }
        return -1;
    }
}