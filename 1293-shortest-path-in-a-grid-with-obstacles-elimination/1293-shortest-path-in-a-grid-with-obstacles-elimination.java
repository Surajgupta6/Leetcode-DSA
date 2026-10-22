class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int cost = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, -1);
        }
        int[] start = new int[] { 0, 0, k };
        int[][] dir = { { 0, 1 }, { -1, 0 }, { 1, 0 }, { 0, -1 } };
        queue.offer(start);
        visited[0][0] = k;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] top = queue.poll();
                int r = top[0];
                int c = top[1];
                int remain = top[2];
                if (r == m - 1 && c == n - 1)
                    return cost;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                        continue;
                    int newRemain = remain - grid[nr][nc];
                    if (newRemain < 0)
                        continue;
                    if (newRemain <= visited[nr][nc])
                        continue;
                    visited[nr][nc] = newRemain;
                    queue.offer(new int[] { nr, nc, newRemain });
                }
            }
            cost++;
        }
        return -1;
    }
}