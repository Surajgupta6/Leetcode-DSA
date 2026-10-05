class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> sk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sk.push('(');
            }
            else if(s.charAt(i)==')'){
                if(sk.peek()=='('){
                    sk.pop();
                    sk.push('1');
                }
                else{
                    int count=0;
                    while(!sk.isEmpty() && sk.peek()!='('){
                        count+=sk.pop()-'0';
                    }
                    sk.pop();
                    count*=2;
                    sk.push((char)('0'+count));
                }
            }
        }
        int ans = 0;

        while (!sk.isEmpty()) {
            ans += sk.pop() - '0';
        }

        return ans;
    }
}