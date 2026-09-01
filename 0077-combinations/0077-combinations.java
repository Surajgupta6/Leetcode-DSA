class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int start,int n,int k,List<Integer> current,List<List<Integer>> result){
        if(k==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=n-k+1;i++){
            current.add(i);
            backtrack(i+1,n,k-1,current,result);
            current.remove(current.size()-1);
        }
    }
}