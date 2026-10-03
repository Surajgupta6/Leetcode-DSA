class Solution {
    private int[] rank;
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(findPar(u)==findPar(v)) return edge;
            union(u,v);
        }
        return new int[0];
    }
    private int findPar(int node){
        if(node==parent[node]) return node;
        int ulp=findPar(parent[node]);
        parent[node]=ulp;
        return parent[node];
    }
    private void union(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u==ulp_v) return ;
        if(rank[u]<rank[v]){
            parent[ulp_u]=ulp_v;
        }
        else if(rank[ulp_v]<rank[ulp_u]){
            parent[ulp_v]=ulp_u;
        }
        else{
            parent[ulp_v]=ulp_u;
            int rankv=rank[ulp_u];
            rank[ulp_u]=rankv+1;
        }
    }
}