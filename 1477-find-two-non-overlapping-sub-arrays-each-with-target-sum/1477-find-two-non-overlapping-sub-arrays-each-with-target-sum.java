class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int minSublen[] = new int[arr.length];
        Arrays.fill(minSublen,Integer.MAX_VALUE);
        int i=0,j=0;
        int bestMinLen=0;
        int lenMinBefore=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        int sum=0;
        while(j<arr.length){
            sum+=arr[j];
            while(i<=j && sum>target){
                sum-=arr[i++];
            }
            
            if(sum==target){
                int len=j-i+1;
                if(i > 0 && minSublen[i-1]!=Integer.MAX_VALUE){
                    result=Math.min(result,len+minSublen[i-1]);
                }
                lenMinBefore=Math.min(lenMinBefore,len);
            }
            minSublen[j]=lenMinBefore;
            j++;
        }
        return result==Integer.MAX_VALUE ? -1 :result;
    }
}