class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int i=2;
        while(i<nums.length){
            if(l1.get(l1.size()-1)>l2.get(l2.size()-1)){
                l1.add(nums[i]);
            }
            else{
                l2.add(nums[i]);
            }
            i++;
        }
        int[] result = new int[nums.length];
        int z=0;
        for(int j=0;j<l1.size();j++){
            result[z]=l1.get(j);
            z++;
        }
        for(int j=0;j<l2.size();j++){
            result[z]=l2.get(j);
            z++;
        }
        return result;
    }
}