class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance=0;
        int start_index=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            balance+=diff;
        }
        if(balance<0) return -1;
        balance=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            balance+=diff;
            if(balance<0){
                balance=0;
                start_index=i+1;
            }
        }
        return start_index;
    }
}