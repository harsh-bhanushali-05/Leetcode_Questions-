class Solution {
    public int f(int i , int prices[] , int s , int dp[][]){
        if(i == prices.length)return 0;
        if(dp[i][s] !=-1)return dp[i][s];
        if(s == 1 ){
            // we can sell the stock 
            int take = f(i+1 , prices , 0 ,dp ) + prices[i];
            int not = f(i+1 , prices , 1 ,dp );
            return  dp[i][s]= Math.max(take , not );
        }
        else{
            int take = f(i+1 , prices , 1 , dp ) - prices[i];
            int not = f(i+1 , prices , 0, dp  );
            return  dp[i][s] = Math.max(take , not );
        }
    }
    public int maxProfit(int[] prices) {
        // buy or sell infi times 
        int dp[][] = new int[prices.length][2];
        for(int i [] : dp )
            Arrays.fill(i , -1 );
        return f(0 , prices , 0 , dp );
    }
}