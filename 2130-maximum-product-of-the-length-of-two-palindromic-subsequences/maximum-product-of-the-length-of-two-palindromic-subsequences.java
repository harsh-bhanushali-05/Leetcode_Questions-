class Solution {
    public boolean isPalindrome(String str ){
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i ))return false;
        }
        return true;
    }
    public int f(String one , String two , int i , String str){
        if(i == str.length()){
            if(isPalindrome(one) && isPalindrome(two)){
                return one.length() * two.length();
            }
            return -1;
        }
        // take in the string 1 case 
        int t1 = f(one+str.charAt(i) , two , i+1 , str );
        int t2 = f(one , two+str.charAt(i) , i+1 , str );
        int t3 = f(one , two , i+1 , str );
        return Math.max(t1 , Math.max(t2, t3));
    }
    public int maxProduct(String s) {
        return f("" , "" , 0 , s);
    }
}