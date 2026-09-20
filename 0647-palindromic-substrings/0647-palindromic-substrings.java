class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        find(arr, 0);
        return count;
    }

    private void find(char[] s, int center) {

        if (center >= s.length) {
            return;
        }
        expand(s, center, center); // odd length
        expand(s, center, center + 1);  // even length
        find(s, center + 1);
    }

    private void expand(char[] s, int left, int right) {

        if (left < 0 || right >= s.length) {
            return;
        }
        if (s[left] != s[right]) {
            return;
        }
        count++;
        expand(s, left - 1, right + 1);
    }
}