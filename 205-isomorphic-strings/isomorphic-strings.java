class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        HashMap<Character, Character> map = new HashMap<>(); // s -> t map hai
        HashMap<Character, Character> m = new HashMap<>(); // s -> t map hai
        for(int i = 0 ; i < s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) , t.charAt(i));
            }
            if(m.containsKey(t.charAt(i))==false){
                m.put(t.charAt(i) , s.charAt(i));
            }
            if(t.charAt(i) != map.get(s.charAt(i)) || s.charAt(i)!= m.get(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}