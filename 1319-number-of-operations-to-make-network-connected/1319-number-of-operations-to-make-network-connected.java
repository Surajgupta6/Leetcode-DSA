class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                Queue<Integer> queue = new LinkedList<>();
                component++;
                queue.offer(i);
                visited[i]=true;
                while(!queue.isEmpty()){
                    int top=queue.poll();
                    for(int neigh:graph.get(top)){
                        if(!visited[neigh]){
                            queue.offer(neigh);
                            visited[neigh]=true;
                        }
                    }
                }
            }
        }
        return component-1;
    }
}