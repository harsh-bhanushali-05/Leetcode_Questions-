class Solution {
    public int f(int i , String s , int dp[] ){
        if(s.length() <= i ){
            return 1; 
        }
        if(s.charAt(i) == '0'){
            return dp[i] = 0;
        }
        if(dp[i]!= -1 ){
            return dp[i];
        }
        int one = f(i+1 , s ,dp  );
        int two = 0; 
        if(i!= s.length()-1){
            // this is not the last element 
            if(Integer.parseInt(s.substring(i , i+2))<=26){
                // this is pickable 
                two = f(i+2 , s ,dp);
            }
        }
        return dp[i] = one + two; 
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp , -1 );
        return f(0 , s , dp );
    }
}