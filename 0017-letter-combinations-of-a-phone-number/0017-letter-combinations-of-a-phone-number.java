class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,char[]> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        hm.put('2',new char []{'a','b','c'});
        hm.put('3',new char []{'d','e','f'});
        hm.put('4',new char []{'g','h','i'});
        hm.put('5',new char []{'j','k','l'});
        hm.put('6',new char []{'m','n','o'});
        hm.put('7',new char []{'p','q','r','s'});
        hm.put('8',new char []{'t','u','v'});
        hm.put('9',new char []{'w','x','y','z'});
        backtrack(0,digits,hm,new StringBuilder(),result);
        return result;
    }
    private void backtrack(int i,String digits,Map<Character,char[]> hm,StringBuilder current,List<String>result){
        if(i==digits.length()){
            result.add(current.toString());
            return;
        }
        for(char ch:hm.get(digits.charAt(i))){
            current.append(ch);
            backtrack(i+1,digits,hm,current,result);
            current.deleteCharAt(current.length()-1);
        }
    }
}