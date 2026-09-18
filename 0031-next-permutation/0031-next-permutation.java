class Solution {
    public void nextPermutation(int[] nums) {
        int x=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                x=i-1;
                break;
            }
        }
        if(x==-1){
            for(int i=0;i<nums.length/2;i++){
                int temp=nums[i];
                nums[i]=nums[nums.length-1-i];
                nums[nums.length-1-i]=temp;
            }
        }
        else{
            int swap_index=x;
            for(int i=nums.length-1;i>=x+1;i--){
                if(nums[i] > nums[x]){
                    swap_index=i;
                    break;
                }
            }
            swap(nums,x,swap_index);
            reverse(nums,x+1,nums.length-1);
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}