class Solution {
    public int f(int arr[][] , int i , int j , int vis[][]){
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0)return 0;
        if(arr[i][j]==0)return 0;
        if(vis[i][j]==1)return 0;
        vis[i][j] = 1;
        int row[]= {1,0,-1,0};
        int col[] = {0,1,0,-1};
        int ans =1;
        for(int a = 0;a<4;a++){
            ans+=f(arr , i+row[a] , j+col[a] , vis);
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        for(int i[] : vis)
            Arrays.fill(i , 0 );
        int ans = 0 ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 && vis[i][j] ==0){
                    ans = Math.max(ans , f(grid , i , j , vis));
                }
            }
        }
        return ans;
    }
}