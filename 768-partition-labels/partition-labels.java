class Solution {
    public boolean chk( HashMap<Character, Integer> map, HashMap<Character, Integer> freq){
        for(char i : map.keySet()){
            if(map.get(i) < freq.getOrDefault(i,0)){
                return false;
            }
        }
        return true;
    }
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character , Integer > freq = new HashMap<>();
        for(char c: s.toCharArray())
            freq.put(c , freq.getOrDefault(c , 0 )+1);
        int curr = 0;
        List < Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(chk(map , freq) && curr!=0){
                list.add(curr);
                curr = 0;
                map = new HashMap<>();
            }
            map.put( s.charAt(i) , map.getOrDefault(s.charAt(i) , 0 )+1);
            curr++;
        }
        list.add(curr);
        return list;
    }
}