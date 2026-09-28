class Solution {
    public int maxDepth(String s) {
        int height=0;
        Stack<Character> sk = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sk.push('(');
                height=Math.max(height,sk.size());
            }
            else if(s.charAt(i)==')'){
                sk.pop();
            }
        }
        return height;
    }
}