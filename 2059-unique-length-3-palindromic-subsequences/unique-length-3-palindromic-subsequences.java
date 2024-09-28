class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character , List<Integer>> map = new HashMap<>();
        for(int i = 0 ;i < s.length() ; i++){
            if(map.containsKey(s.charAt(i)) == false){
                map.put(s.charAt(i) , new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        HashSet<String> set = new HashSet<>();
        for(char key : map.keySet()){
            int start = map.get(key).get(0);
            int end = map.get(key).get(map.get(key).size()-1);
            for(int i = start+1 ; i < end ; i++){
                set.add(key + Character.toString(s.charAt(i))+ key );
            }
        }
        return set.size();
    }
}