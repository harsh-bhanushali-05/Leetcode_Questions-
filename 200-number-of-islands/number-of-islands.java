class Solution {
    public void dfs(char grid[][] , int i , int j , int vis[][]){
        if(i < 0 || j<0 || i>=grid.length || j>=grid[0].length )return;
        if(vis[i][j]==1)return;
        if(grid[i][j] == '0')return;
        vis[i][j] = 1 ;
        int row[] = {1,0,-1,0};
        int col[] = {0,1,0,-1};
        for(int a = 0;a<4;a++){
            dfs(grid , i+row[a] , col[a]+j , vis);
        }
    }
    public int numIslands(char[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        for(int i[]:vis)
            Arrays.fill(i , 0 );
        int ans = 0 ;
        for(int i = 0 ; i< vis.length ; i++){
            for(int j = 0 ; j<vis[0].length ; j++){
                if(grid[i][j] == '1' && vis[i][j] ==0 ){
                    dfs(grid , i , j , vis );
                    ans++;
                }
            }
        }
        return ans;
    }
}