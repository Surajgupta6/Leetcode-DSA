class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> graph = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            graph.get(redEdges[i][0]).add(new int[]{redEdges[i][1],0});
        }
        for(int i=0;i<blueEdges.length;i++){
            graph.get(blueEdges[i][0]).add(new int[]{blueEdges[i][1],1});
        }
        int distance=0;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        result[0]=0;
        queue.offer(new int[]{0,-1});
        boolean visited[][]=new boolean[n][2];
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int node = curr[0];
                int lastColor = curr[1];
                for (int[] neighbour : graph.get(node)) {
                    int v = neighbour[0];
                    int color = neighbour[1];
                    if(lastColor==color) continue;
                    if (visited[v][color]) {
                        continue;
                    }
                    visited[v][color] = true;
                    if (result[v] == -1) {
                        result[v] = distance + 1;
                    }
                    queue.offer(new int[]{v, color});
                }
            }
            distance++;    
        }
        return result;
    }
}