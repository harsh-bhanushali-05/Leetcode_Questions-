class Solution {
    public int f(int i , int arr[] , int k, int limit , int dp[][]){
        if(i == arr.length)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        if(k < limit){
            // we can still do the trade 
            if(k%2==0){
                // we can buy or leave 
                int buy = f(i+1 , arr , k+1 , limit ,dp)- arr[i]; // we bought the current stock 
                int leave = f(i +1 , arr , k , limit,dp);
                return  dp[i][k] = Math.max(buy , leave );
            }
            else{
                // we can either sell the stock or leave 
                int sell = f(i+1 , arr , k+1 , limit ,dp) + arr[i]; 
                int leave = f(i+1 , arr , k , limit , dp  );
                return  dp[i][k] = Math.max(sell , leave );
            }
        }
        else{
            return 0;
        }
    }
    public int maxProfit(int k, int[] prices) {
        // even is buy odd is sell 
        int dp[][] = new int[prices.length+1][k*2+1];
        for(int i[] : dp )
            Arrays.fill(i , -1 );
        return f(0 , prices , 0 , k*2 , dp);
    }
}