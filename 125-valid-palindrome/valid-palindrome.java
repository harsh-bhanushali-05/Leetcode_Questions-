class Solution {
    public boolean isPalindrome(String s) {
        int i = 0 ;
        int j = s.length()-1;
        while(i<j){
            while(i < s.length() && Character.isLetterOrDigit(s.charAt(i)) == false){
                i++;
            }
            while(j >= 0 && Character.isLetterOrDigit(s.charAt(j)) == false){
                j--;
            }
            if(j == 0 || i  == s.length() )break;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))return false;
            i++;
            j--;
        }
        return true;
    }
}