class Solution {
    public int maxProfit(int k, int[] prices) {
        // even is buy odd is sell 
        int dp[][] = new int[prices.length+1][(k*2)+1];
        for(int i[] : dp )
            Arrays.fill(i , 0);
        int x = k;
        for(int i = prices.length-1 ; i>=0 ; i--){
            for( k = (x*2)-1 ; k >= 0 ; k--){
                if(k%2==0){
                    int buy = dp[i+1][k+1] - prices[i];
                    int sell = dp[i+1][k];
                    dp[i][k]= Math.max(buy , sell );
                }
                else{
                    int buy = dp[i+1][k+1] + prices[i];
                    int sell = dp[i+1][k];
                    dp[i][k] = Math.max(buy , sell );
                }
            }
        }
        return dp[0][0];
    }
}