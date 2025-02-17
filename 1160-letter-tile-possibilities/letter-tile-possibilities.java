class Solution {
    HashSet<String> set = new HashSet<>(); 
    public void f( String curr , String str ){
        if(str.length() == 0 ){
            set.add(curr);
            return;
        }
        if(curr!="")
            set.add(curr);
        for(int i = 0 ; i < str.length(); i++){
            f(curr+str.charAt(i) , str.substring(0 , i) + str.substring(i+1 , str.length()));
        }
    }
    public int numTilePossibilities(String tiles) {
        // this function only makes for the curr values 
        f("",tiles ); 
        return set.size(); 
    }
}