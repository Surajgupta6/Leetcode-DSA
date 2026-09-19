class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double[] dist = new double[n];
        dist[start_node]=1;
        List<List<double []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double w=succProb[i];
            adj.get(u).add(new double[]{v,w});
            adj.get(v).add(new double[]{u,w});
        }
        pq.offer(new double[]{1,start_node});
        while(!pq.isEmpty()){
            double[] top=pq.poll();
            double probability = top[0];
            int node = (int) top[1];
            if (probability < dist[node]) continue;
            for(double[] neighbour:adj.get(node)){
                int nextNode = (int) neighbour[0]; 
                double edgeProbability = neighbour[1]; 
                double newProbability = probability * edgeProbability;
                if(dist[nextNode] < newProbability){
                    dist[nextNode]=newProbability;
                    pq.offer(new double[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist[end_node];
    }
}