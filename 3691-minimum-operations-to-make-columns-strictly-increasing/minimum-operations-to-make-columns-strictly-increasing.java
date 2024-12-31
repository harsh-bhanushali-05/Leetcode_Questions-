class Solution {
    public int minimumOperations(int[][] grid) {
        int ans = 0 ;
        for(int i =1 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] <= grid[i-1][j]){
                    int curr = grid[i][j];
                    grid[i][j] = grid[i-1][j]+1;
                    ans+=(grid[i][j] - curr);
                }
            }
        }
        return ans;
    }
}