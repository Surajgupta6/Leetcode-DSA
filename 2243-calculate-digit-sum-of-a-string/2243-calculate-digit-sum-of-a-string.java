class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int prev = 0;
            int sum=0;
            while (i < s.length()) {
                if (prev + k == i) {
                    sb.append(sum);
                    prev = i;
                    sum=0;
                } else {
                    sum += s.charAt(i) - '0';
                    i++;
                }
            }
            if (prev < i) {
                sb.append(sum);
            }
            s=sb.toString();
        }
        return s;
    }
}