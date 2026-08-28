class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        if(s.length()<=10){
            return list;
        }
        set.add(s.substring(0,10));
        for(int i =10;i<s.length();i++){
            String sub = s.substring(i-9,i+1);
            if(set.contains(sub)){
                if(!list.contains(sub)){
                list.add(sub);
                }
                continue;
            }
            else{
                set.add(sub);
            }
        }
        return list;
    }
}