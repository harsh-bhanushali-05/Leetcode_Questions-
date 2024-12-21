class Solution {
    public int f(int x , int y , int grid[][] , int vis[][] ){
        if(x<0 || y<0 || x>=grid.length || y>= grid[0].length || grid[x][y] == 0)return 0;
        if(vis[x][y]==1)return 0;
        vis[x][y] = 1;
        int row[] = {1,0,-1,0};
        int col[] = {0,1,0,-1};
        int ans = 0 ;
        for(int a = 0 ;a < row.length ; a++){
            ans = Math.max(f(x+row[a] , y+col[a] , grid , vis),ans);
        }
        vis[x][y] = 0;
        return ans+grid[x][y];
    } 
    public int getMaximumGold(int[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        int max =0;
        for(int i = 0 ;i < grid.length ; i++){
            for(int j = 0 ;j < grid[0].length ; j++){
                if(grid[i][j] !=0 && vis[i][j] == 0 ){
                    for(int q []: vis)
                        Arrays.fill(q , 0);
                    max = Math.max(f(i , j, grid , vis), max);
                }
            }
        }
        return max;
    }
}