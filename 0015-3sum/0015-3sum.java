class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> ans = new ArrayList<>();
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    left++;
                    right--;
                    // if(finalList.contains(ans)) continue;
                    finalList.add(ans);
                } else if (-nums[i] < nums[left] + nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return finalList;
    }
}