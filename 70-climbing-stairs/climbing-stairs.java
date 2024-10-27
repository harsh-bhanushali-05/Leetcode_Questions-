class Solution {
    public int f(int n , int target , int dp[]){
        if( n == target )return 1;
        if(n > target )return  0;
        if(dp[n]!=-1)return dp[n];
        int one = f(n+1 , target , dp );
        int two = f(n+2 , target , dp );
        return dp[n] = one + two;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n];
        Arrays.fill(dp , -1 );
        return f(0 , n , dp );
    }
}