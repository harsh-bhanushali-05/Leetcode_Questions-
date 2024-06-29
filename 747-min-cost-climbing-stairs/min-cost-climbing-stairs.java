class Solution {
    public int f(int i , int cost[] , int dp[]){
        if(i >=cost.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int one = f(i+1 , cost , dp );
        int two = f(i+2 , cost, dp );
        return dp[i] = Math.min(one ,two)+cost[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        int x = f(0, cost,dp);
        Arrays.fill(dp,-1);
        int y = f(1 , cost ,dp);
        return Math.min( x, y);
    }
}