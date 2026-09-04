class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0,candidates,target,current,result,0);
        return result;
    }
    private void backtrack(int start,int[] candidates,int target,List<Integer> current,List<List<Integer>> result,int sum){
        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i-1]==candidates[i]) continue;
            current.add(candidates[i]);
            sum+=candidates[i];
            backtrack(i+1,candidates,target,current,result,sum);
            sum-=candidates[i];
            current.remove(current.size()-1);
        }
    }
}