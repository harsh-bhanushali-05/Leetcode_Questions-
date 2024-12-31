class Solution {
    HashMap<String , Integer> map = new HashMap<>(); 
    public int f(String curr , HashSet<String> set , int i , String s ){
        if(i == s.length()){
            // the string is over 
            if(set.contains(curr))return 0;
            return curr.length();
        }
        String key = curr+"#"+Integer.toString(i);
        if(map.containsKey(key))return map.get(key);
        if(curr == ""){
            // this is a new String 
            int take = f(curr+s.charAt(i) , set , i+1 , s );
            int not = f(curr, set , i+1 , s )+1;
            map.put(key ,  Math.min(take , not));
            return Math.min(take , not );
        }
        else{
            if(set.contains(curr)){
                // we can split the string here 
                int split = f("" , set , i , s);
                int not = f(curr+s.charAt(i) , set , i+1 , s );
                map.put(key ,  Math.min(split , not));
                return Math.min(split , not );
            }
            else{
                int not = f(curr+s.charAt(i) , set , i+1 , s );
                map.put(key ,  not );
                return not;
            }
        }
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(); 
        for(String str : dictionary){
            set.add(str);
        }
        return f("" , set, 0 , s );
    }
}