class Solution {
    public int f(int i , int j , int arr[][] , int dp[][]){
        if(arr.length <= i || arr[0].length <= j )return (int)1e9; 
        if(i == arr.length-1 && j == arr[0].length -1 )return dp[i][j] = arr[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int right = f(i , j+1 , arr , dp);
        int down = f(i+1 , j , arr , dp);
        return dp[i][j] = Math.min(right , down )+arr[i][j];
    }
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i[] : dp){
            Arrays.fill(i , -1);
        }
        return f(0 , 0 , grid , dp);
    }
}