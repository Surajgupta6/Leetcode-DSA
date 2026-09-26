class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            hm.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        int previdx=0;
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            if(s.charAt(i)=='('){
                previdx=i;
                while(i<s.length() && s.charAt(i)!=')'){
                    i++;
                }
                String key = s.substring(previdx + 1, i);
                if (hm.containsKey(key)) {
                    sb.append(hm.get(key));
                } else {
                    sb.append("?");
                }
            }
            else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}