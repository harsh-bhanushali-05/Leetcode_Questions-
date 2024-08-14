class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int j = s.length()-1;
            while(i<j && set.contains(s.charAt(i)) == false ){
                if(s.charAt(i) == s.charAt(j) && set.contains(s.charAt(i)) == false){
                    HashSet<Character> done = new HashSet<>();
                    for(int k = i+1 ; k < j ; k++){
                        if(done.contains(s.charAt(k)) == false){
                            done.add(s.charAt(k));
                            ans++;
                        }
                        done.add(s.charAt(k));
                    }
                    set.add(s.charAt(i));
                }
                j--;
            }
        }
        return ans;
    }
}