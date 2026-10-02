class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int start = nums[i];
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            if(start==nums[j]){
                list.add(""+start);
                i=j+1;
            }
            else{
                list.add(start+"->"+nums[j]);
                i=j+1;
            }
        }
        return list;
    }
}