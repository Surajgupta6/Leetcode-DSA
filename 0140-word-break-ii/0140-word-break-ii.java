class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backtrack(s,"",wordDict,0,result);
        return result;
    }
    private void backtrack(String s,String current,List<String> wordDict,int idx,List<String> result){
        if (idx == s.length()) {
            result.add(current.trim());
            return;
        }
        for(int i=0;i<wordDict.size();i++){
            int len = wordDict.get(i).length();
            if(idx+len <= s.length() && wordDict.get(i).equals(s.substring(idx,idx+len))){
                backtrack(s,current + " " + wordDict.get(i),wordDict,idx+len,result);
            }
        }
    }
}