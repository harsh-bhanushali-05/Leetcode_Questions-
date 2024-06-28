class Solution {
    public boolean palindrome(String str ){
        for(int i = 0 ; i < str.length()/2 ; i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1))return false;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans="";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j =s.length(); j >=i+1; j--){
                if(palindrome(s.substring(i,j))){
                    if(ans.length()<s.substring(i,j).length()){
                        ans = s.substring(i,j);
                    }
                    break;
                }
            }
        }   
        return ans;
    }
}