class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1]; 
        for(int i = text1.length()-1 ; i >= 0 ; i--){
            for(int j = text2.length()-1 ; j>= 0 ; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
                }
            }
        }
        // print the longest string as well 
        String ans = "";
        int i = dp.length-2; 
        int j = dp[0].length-2; 
        while(i >= 0 && j >= 0 ){
            if(text1.charAt(i) == text2.charAt(j)){
                ans+=text1.charAt(i);
                i--; 
                j--; 
            }else{
                if(j == 0 ){
                    i--; 
                }
                else if( i == 0 ){
                    j--; 
                }else if(dp[i][j-1] > dp[i-1][j]){
                    j--; 
                }else{
                    i--;
                }
            }
        }
        // answer is the ulta of the correct answer 
        System.out.println(ans);
        return dp[0][0];
    }
    public String reverse(String s){
        StringBuilder str = new StringBuilder(s);
        str.reverse(); 
        return str.toString(); 
    }
    public int longestPalindromeSubseq(String s) {
        // this is the longest subsequence -> same code with the reverse of that particular string 
        return longestCommonSubsequence(s , reverse(s));
    }
}