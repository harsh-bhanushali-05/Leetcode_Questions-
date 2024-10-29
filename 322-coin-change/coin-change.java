class Solution {
    public int f(int arr[] , int i , int target , int dp[][]){
        if(target == 0 )return 0;
        if(target < 0 || i >= arr.length)return (int)1e9;
        if(dp[i][target] !=-1)return dp[i][target];
        int take = f(arr , i , target - arr[i],dp )+1;
        int not = f(arr , i+1 , target ,dp );
        return dp[i][target]= Math.min(take , not );
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i[]: dp)
            Arrays.fill(i , -1 );
        int ans = f(coins,0 , amount , dp );
        if(ans >= (int)1e8)return -1;
        return ans;
    }
}