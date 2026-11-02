class Solution {
    public int minMoves2(int[] nums) {

        // failed Approach
        // int sum = 0;
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     sum+=nums[i];
        // }
        // int min = sum/n;
        // int result = 0;
        // for(int i=0;i<n;i++){
        //     result+=Math.abs(nums[i]-min);
        // }
        // return result;


        // using Sorting 

        Arrays.sort(nums);
        int n = nums.length;
        int min;
        if(n%2==0){
            min=nums[(((n/2)-1)+((n/2)+1))/2];
        }
        else{
            min=nums[n/2];
        }
        int result = 0;
        for(int i=0;i<n;i++){
            result+=Math.abs(nums[i]-min);
        }
        return result;
    }
}