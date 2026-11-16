class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int length = 0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int longestStreak = 1;
                int currentNum = num;
                while(hs.contains(currentNum+1)){
                    longestStreak++;
                    currentNum++;
                }
                length = Math.max(longestStreak,length);
            }
        }
        return length;
    }
}