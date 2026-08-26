class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int right = 0;
        int countOne = 0;
        String resultStr = "";
        int result = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (s.charAt(right) == '1') {
                countOne++;
            }    
            right++;
            if (countOne == k) {
                while (left < right && s.charAt(left) == '0')
                    left++;

                int length=right-left;
                String current = s.substring(left,right);

                if(length < result){
                    result = length;
                    resultStr=current;
                }
                else if(result==length){
                    if (current.compareTo(resultStr) < 0) {
                        resultStr = current;
                    }
                }
                countOne--;
                left++;
            }
        }
        return resultStr;
    }
}