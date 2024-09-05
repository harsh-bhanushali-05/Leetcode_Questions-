class Solution {
    public int f(int i , int  j, int prices[] , int dp[][]){
        if( j >= prices.length){
            return 0;
        }
        if(dp[i][j]!=-1 )return dp[i][j];
        if( j > i ){
            int pick = f(i+1 , i+(i+2) , prices , dp )+prices[i];
            int not = f(i+1 , j , prices , dp );
            return dp[i][j] = Math.min(pick , not );
        }
        else{
            return dp[i][j] = f(i+1 , i+(i+2) , prices , dp )+prices[i];
        }
    }
    public int minimumCoins(int[] prices) {
        // i for the element we are thinking of taking or leaving and j is to represent till where have we bought 
        // i>=j then buying is complusory else pick not pick
        int dp[][] = new int[prices.length][prices.length];
        for(int i [] : dp )
            Arrays.fill(i , - 1);
        return f(0 , 0 , prices , dp );
    }
}