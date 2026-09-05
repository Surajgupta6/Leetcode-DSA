class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int minValue=Integer.MAX_VALUE;
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxValue=Math.max(maxValue,nums[i]);
            max[i]=maxValue;
        }
        for(int i=nums.length-1;i>=0;i--){
            minValue=Math.min(minValue,nums[i]);
            min[i]=minValue;
        }
        for(int i=0;i<nums.length;i++){
            if(max[i]-min[i]<=k) return i;
        }
        return -1;
    }
}