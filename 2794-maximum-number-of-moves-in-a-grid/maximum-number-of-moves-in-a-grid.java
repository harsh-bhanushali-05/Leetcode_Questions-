class Solution {
    public int f(int i , int j , int arr[][],int dp[][] ){
        if(i< 0 || i >=arr.length || j <0 || j >= arr[0].length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = 0;
        if(i-1 >= 0 && j+1 < arr[0].length && arr[i][j] < arr[i-1][j+1]){
            ans = Math.max(ans , 1+f(i-1 , j+1 , arr,dp));
        }
        if(j+1 < arr[0].length && arr[i][j] < arr[i][j+1]){
            ans = Math.max(ans , 1+f(i , j+1 , arr,dp));
        }
        if(i+1 < arr.length && j+1<arr[0].length && arr[i][j] < arr[i+1][j+1]){
            ans = Math.max(ans , 1+f(i+1 , j+1 , arr,dp));
        }
        return dp[i][j] = ans;
    }
    public int maxMoves(int[][] grid) {
        int ans = 0;
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i [] : dp ){
            Arrays.fill(i , -1 );
        }
        for(int i = 0  ; i < grid.length ; i++ ){
            ans = Math.max(ans ,  f(i , 0 , grid , dp));
        }
        return ans;
    }
}