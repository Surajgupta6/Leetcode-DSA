class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long sum=0;
        int half=nums.length/2;
        for(int i=0;i<half;i++){
            sum-=nums[i];
        }
        for(int j=half;j<nums.length;j++){
            sum+=nums[j];
        }
        return sum;
    }
}