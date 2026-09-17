class Solution {
    public String frequencySort(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] freq = new int[62];
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                freq[s.charAt(i)-'A']++;
            }
            else if(Character.isLowerCase(s.charAt(i))){
                freq[s.charAt(i)-'a'+26]++;
            }
            else{
                freq[s.charAt(i)-'0'+52]++;
            }
        }
        for(int i=0;i<freq.length;i++){
            pq.offer(new int[]{i,freq[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int top[] = pq.poll();
            char ch;
            if(top[0]<26){
                ch=(char)('A'+top[0]);
            }
            else if(top[0]<52){
                ch=(char)('a'+top[0]-26);
            }
            else{
                ch=(char)('0'+top[0]-52);
            }
            for(int i=0;i<top[1];i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}