class Solution {
    public boolean f(int i , int j , String s , int count ){
        if(i == j )return true;
        if(j < i )return true;
        if(s.charAt(i) == s.charAt(j)){
            return f(i+1 , j-1 , s , count );
        }
        else{
            if(count == 1 )return false;
            return f(i+1 , j , s , count+1) || f(i , j-1 , s , count +1);
        }
    }
    public boolean validPalindrome(String s) {
        return f(0 , s.length()-1 , s , 0 );
    }
}