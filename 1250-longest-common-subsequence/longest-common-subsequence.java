class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] =new int[text1.length()+1][text2.length()+1];
        for(int i[] : dp)
            Arrays.fill(i , 0 );
        String a = text1;
        String b = text2;
        for(int i =1 ; i < a.length()+1 ; i ++){
            for(int j = 1; j<b.length()+1 ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}