class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int naming = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    map.put(naming, bfs(grid,i,j,naming));
                    naming++;
                }
            }
        }
        int result = 0;
        int[][] dirs = {{ 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int size = 1;
                    for (int[] dir : dirs) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                            continue;
                        }
                        int islandId = grid[nr][nc];
                        if (islandId > 1 && set.add(islandId)) {
                            size += map.get(islandId);
                        }
                    }
                    result = Math.max(result, size);
                }
            }
        }
        if (result == 0) {
            return m * n;
        }
        return result;
    }
    private int bfs(int[][] grid,int row,int col, int naming) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        grid[row][col]=naming;
        int counter=1;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 0)
                    continue;
                if (grid[nr][nc] == 1) {
                    grid[nr][nc] = naming;
                    counter++;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return counter;
    }
}