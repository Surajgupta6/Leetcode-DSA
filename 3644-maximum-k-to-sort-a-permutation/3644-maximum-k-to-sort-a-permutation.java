class Solution {
    public int sortPermutation(int[] nums) {
        int result=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                if(result==-1){
                    result=nums[i];
                }
                result&=nums[i];
            }
        }
        return result==-1?0:result;
    }
}