class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int pos=0;
        int count=0;
        for(int num1: nums){
            if(num1==target){
                count++;
            }
            if(num1<target){
                pos++;
            }
        }
        while(count>0){
            list.add(pos++);
            count--;
        }
        return list;
    }
}