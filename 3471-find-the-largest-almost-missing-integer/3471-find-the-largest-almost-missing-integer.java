class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        if (k == 1) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (hm.get(nums[i]) == 1) {
                    max = Math.max(max, nums[i]);
                }
            }

            return max;
        }
        if (k == n) {
            int max = -1;
            for (int i = 0; i < n; i++)
                max = Math.max(nums[i], max);
            return max;
        }
        int max = -1;
        if (hm.get(nums[0]) == 1) {
            max = Math.max(max, nums[0]);
        }
        if (hm.get(nums[n - 1]) == 1) {
            max = Math.max(max, nums[n - 1]);
        }
        return max;
    }
}