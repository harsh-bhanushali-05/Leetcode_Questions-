class Solution {
    public boolean chk(int a[] , int []b){
        for(int i = 0 ;i < 26 ; i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())return false;
        // permutation -> same letters in a different way 
        int one[] = new int[26];
        int two[] = new int[26];
        // s1 shud be between s2 
        for(int i = 0 ; i < 26 ; i++){
            one[i] = 0;
            two[i] = 0;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            one[s1.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            two[s2.charAt(i)-'a']++;
        }
        for(int i = s1.length() ; i < s2.length() ; i++){
            if(chk(two , one )){
                return true;
            }
            two[s2.charAt(i)-'a']++;
            two[s2.charAt(i-s1.length())-'a']--;
        }
        if(chk(one , two )){
            return true;
        }
        return false;
    }
}