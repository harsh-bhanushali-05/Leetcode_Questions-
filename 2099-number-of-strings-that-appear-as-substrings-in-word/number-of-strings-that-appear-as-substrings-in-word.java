class Solution {
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> set = new HashSet<>(); 
        for(int i = 0 ; i< word.length(); i++){
            for(int j = i ; j <= word.length() ; j++){
                // System.out.println(word.substring(i , j ));
                set.add(word.substring(i , j ));
            }
        }
        int ans = 0 ;
        for(String w : patterns){
            if(set.contains(w)){
                ans++;
            }
        }
        return ans; 
    }
}