class Solution {
    public int f(int n , int req , int screen , int dp[][] ){
        if(req == screen){
            return 0;
        }
        if(req < screen )return (int)1e9;
        if(req < n )return (int)1e9;
        if( dp[n][screen]  !=-1)return  dp[n][screen] ;
        // paste condition -> 
        int paste = (int)1e9;
        int copy = (int)1e9;
        if(n>0){
            paste = f(n , req , screen+n , dp)+1;
        }
        if(n != screen )
            copy = f(screen , req , screen , dp )+1;
        return dp[n][screen] = Math.min(copy , paste );
    }
    public int minSteps(int n) {
        // either copy the whole thing or paste it.
        int dp[][] = new int[n+1][n+1];
        for(int i[] : dp){
            Arrays.fill(i , -1);
        } 
        return f(0 , n ,1 , dp );
    }
}