class Solution {
    public int f(int arr[] , int i , int amt , int dp[][]){
        if(amt == 0 )return 0;
        if(i == arr.length)return (int)1e9;
        if(amt<0) return(int)1e9;
        if(dp[i][amt]!=-1)return dp[i][amt];
        int take = f(arr , i , amt-arr[i] ,dp)+1;
        int not = f(arr ,i+1 , amt ,dp);
        return dp[i][amt]= Math.min(take , not);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int x[]:dp)
            Arrays.fill(x , -1 );
        int ans=f(coins , 0 , amount , dp );
        if(ans>(int)1e8)return -1;
        return ans;
    }
}