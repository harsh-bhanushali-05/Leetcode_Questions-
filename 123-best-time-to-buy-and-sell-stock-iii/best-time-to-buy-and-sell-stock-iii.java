class Solution {
    public int f(int t , int arr[] , int i , int dp[][] ){
        if(i == arr.length){
            return 0;
        }
        if( t < 4 && dp[i][t] !=-1){
            return dp[i][t];
        }
        if(t == 0 || t==2){
            // we are buy 
            int buy = f(t+1 , arr,i+1, dp ) - arr[i];
            int not = f(t , arr , i+1 , dp );
            return dp[i][t] = Math.max(buy , not);
        }
        if(t==1 || t==3){
            // we can sell the stock 
            int sell = f(t+1 , arr , i+1, dp )+arr[i];
            int not = f(t , arr, i+1, dp );
            return dp[i][t] = Math.max(sell , not);
        }
        return 0;
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][4];
        for(int i[] : dp)
            Arrays.fill(i , -1);
        return f(0 , prices , 0 , dp );
    }
}