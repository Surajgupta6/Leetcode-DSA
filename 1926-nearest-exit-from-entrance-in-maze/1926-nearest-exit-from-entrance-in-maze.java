class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr<0 || nc<0 || nr>=maze.length || nc>=maze[0].length) continue;
                    if (maze[nr][nc] == '.') {
                        maze[nr][nc] = '+';
                        if(nr==0 || nr==maze.length-1 || nc==0 || nc==maze[0].length-1) return length+1;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            length++;
        }
        return -1;
    }
}