class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        int[] end = new int[26]; 
        boolean[] isValid = new boolean[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,0);
        Arrays.fill(isValid,false);
        List<String> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx = s.charAt(i)-'a';
            if(start[idx]==-1){
                start[idx]=i;
            }
            end[idx]=i;
        }
        for(int c=0;c<26;c++){
            if(start[c]==-1) continue;
            boolean valid = true;
            for(int i=start[c];i<=end[c];i++){
                int idx = s.charAt(i) - 'a';
                if(start[idx]<start[c]){
                    valid=false;
                    break;
                }
                end[c]=Math.max(end[c],end[s.charAt(i)-'a']);
            }
            if (valid) {
                isValid[c] = true;
            }
        }
        int lastTakenStart=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int c = s.charAt(i)-'a';
            if(!isValid[c]) continue;
            if(i==start[c] && end[c]<lastTakenStart){
                result.add(s.substring(i,end[c]+1));
                lastTakenStart=i;
            }
        }
        return result;
    }
}