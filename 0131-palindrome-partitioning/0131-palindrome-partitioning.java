class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        partition(s,0,new ArrayList<>(),result);
        return result;
    }
    private void partition(String s,int start,List<String> path,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(check(s,start,i)){
                path.add(s.substring(start,i+1));
                partition(s,i+1,path,result);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean check(String s,int st,int end){
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}