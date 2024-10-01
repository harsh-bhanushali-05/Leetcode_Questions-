class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String , Integer > map = new HashMap<>();
        for(int i = 0 ; i < s.length()-9 ; i++){
            map.put(s.substring(i , i+10)  , map.getOrDefault(s.substring(i , i+10) ,0)+ 1 );
        }
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) > 1 ){
                list.add(key);
            }
        }
        return list;
    }
}