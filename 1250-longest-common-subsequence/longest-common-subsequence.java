class Solution {
    public int f(int i , int j , String a , String b , int dp[][]){
        if(i >=a.length() || j>=b.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = f(i+1 , j+1 , a,b,dp)+1;
        return  dp[i][j] = Math.max(f(i+1 ,j , a, b,dp) , f(i , j+1 , a, b,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] =new int[text1.length()][text2.length()];
        for(int i[] : dp)
            Arrays.fill(i , -1 );
        return f(0,0,text1 , text2 , dp );
    }
}