class Solution {
    public int f(int i , int j , String a , String b , int dp[][] ){
        if(i>=a.length()){
            // word 1 is over return all the characters of j left 
            return b.length()-j;
        }
        if(j>=b.length()){
            // all the characters of b are done we need to delete the character of a now 
            return a.length() - i;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = f(i+1 , j+1 , a,b , dp);
        }
        else{
            return dp[i][j] = 1 + Math.min(f(i , j +1 , a, b , dp) , Math.min(f(i+1 , j ,a , b ,dp) , f(i+1 , j+1 ,a , b ,dp)));
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i[] : dp ){
            Arrays.fill(i , -1 );
        }
        return f(0 , 0 , word1 , word2 , dp );
    }
}