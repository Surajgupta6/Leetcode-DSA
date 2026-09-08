class Solution {
    int count=0;
    public int countArrangement(int n) {
        dfs(1, n, new boolean[n]);
        return count;
    }

    private void dfs(int idx, int n, boolean[] visited) {
        if (idx > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if ((idx%i == 0 || i%idx == 0) && !visited[i - 1]){
                visited[i - 1] = true;
                dfs(idx+1, n,  visited);
                visited[i - 1] = false;
            }
        }
    }
}