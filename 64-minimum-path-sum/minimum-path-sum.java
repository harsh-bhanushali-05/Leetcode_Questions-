class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length+1][grid[0].length+1];
        for(int i[] : dp){
            Arrays.fill(i , (int)1e9);
        }
        dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        for(int i = grid.length-1 ; i>=0 ; i--){
            for(int j = grid[0].length-1 ; j>=0 ; j--){
                if(i == grid.length-1 && j == grid[0].length-1)continue;
                dp[i][j] = Math.min(dp[i][j+1] , dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}