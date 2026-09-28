class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] t=new Boolean[s.length()];
        return backtrack(s,wordDict,0,t);
    }
    private boolean backtrack(String s,List<String> wordDict,int idx,Boolean[] t){
        if(s.length()<=idx){
            return true;
        }
        if(t[idx]!=null) return t[idx];
        for(int i=0;i<wordDict.size();i++){
            int len=wordDict.get(i).length();
            if(idx+len <= s.length() && wordDict.get(i).equals(s.substring(idx,idx+len))){
                if (backtrack(s, wordDict, idx + len, t)) {
                    return t[idx] = true;
                }
            }
        }
        return t[idx]=false;
    }
}