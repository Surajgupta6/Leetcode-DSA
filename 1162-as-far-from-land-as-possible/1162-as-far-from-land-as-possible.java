class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int cost = -1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    queue.offer(new int[] { i, j });
                }
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] curr = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int r = curr[0] + dir[i][0];
                    int c = curr[1] + dir[i][1];
                    if (r < 0 || c < 0 || c >= n || r >= n)
                        continue;
                    if (grid[r][c] == 0) {
                        grid[r][c] = 1;
                        queue.offer(new int[] { r, c });
                    }
                }
            }
            cost++;
        }
        return cost;
    }
}