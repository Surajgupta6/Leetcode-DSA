class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddMin=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2!=0){
                oddMin=Math.min(oddMin,nums1[i]);
            }
        }
        if(oddMin==Integer.MAX_VALUE) return true;
        boolean flag=false;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                if(nums1[i]-oddMin<1){
                    flag=true;
                }
            }
        }
        return flag?false:true;
    }
}