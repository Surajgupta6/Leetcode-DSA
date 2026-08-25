class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int i=1;
        while(i<=101){
            if(!hs.contains(k*i)) return k*i;
            i++;
        }
        return -1;
    }
}