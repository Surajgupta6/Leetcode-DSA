class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if ((long)nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        List<Integer> partial = new ArrayList<>();
                        partial.add(nums[i]);
                        partial.add(nums[j]);
                        partial.add(nums[left]);
                        partial.add(nums[right]);
                        answer.add(partial);
                        left++;
                        right--;
                    } else if ((long)nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return answer;
    }
}