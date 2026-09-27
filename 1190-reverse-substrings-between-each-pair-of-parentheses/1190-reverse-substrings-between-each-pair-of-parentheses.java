class Solution {
    public String reverseParentheses(String s) {
        Stack<String> sk = new Stack<>();
        String curr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sk.push(curr);
                curr = "";
            } else if (s.charAt(i) == ')') {
                String lat = new StringBuilder(curr).reverse().toString();
                String old = sk.pop();
                curr = old + lat;
            } else {
                curr += s.charAt(i);
            }
        }
        return curr;
    }
}