class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean result = check(piles,mid,h);
            if (result) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] piles, int speed, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}