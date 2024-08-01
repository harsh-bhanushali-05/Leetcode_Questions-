class Solution {
    public int f(String str, int i , int tick, int dp[][]){
        if(i == str.length())return 0;
        if(dp[i][tick]!=-1)return dp[i][tick];
        if(tick==1){
            if(str.charAt(i)=='b'){
                return dp[i][tick] = f(str , i+1 , tick,dp);
            }
            else{
                return dp[i][tick] = f(str,i+1,tick ,dp)+1;
            }
        }
        else{
            if(str.charAt(i)=='a'){
                return dp[i][tick] = f(str , i+1 , tick ,dp);
            }
            else{
                return dp[i][tick]=  Math.min(f(str , i+1 , 0 ,dp)+1 , f(str , i+1 , 1,dp));
            }
        }
    }
    public int minimumDeletions(String s) {
        int dp[][] = new int[s.length()][2];
        for(int i[] : dp )
            Arrays.fill(i,-1);
        return f(s , 0 , 0 ,dp);
    }
}