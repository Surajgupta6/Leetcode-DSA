class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> sk = new Stack<>();
        sk.push(-1);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sk.push(i);
            }
            else{
                sk.pop();
                if(sk.isEmpty()) sk.push(i);
                else result=Math.max(result, i - sk.peek());
            }
        }
        return result;
    }
}