class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        solve(n,str,0,0,result);
        return result;
    }
    private void solve(int n,StringBuilder s,int openCount,int closeCount,List<String> result){
        if(s.length()==n*2 && openCount==closeCount){
            result.add(s.toString());
            return;
        }
        if (openCount < n) {
            s.append("(");
            solve(n, s, openCount + 1, closeCount, result);
            s.deleteCharAt(s.length() - 1);
        }
        if (closeCount < openCount) {
            s.append(")");
            solve(n, s, openCount, closeCount + 1, result);
            s.deleteCharAt(s.length() - 1);
        }
    }
}