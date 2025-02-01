class Solution {
    public int f(int i, int j , int grid[][] , int vis[][]){
        if(i < 0 || i >= grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 ){
            return 1;
        }
        if(vis[i][j] == 1){
            return 0;
        }
        vis[i][j] = 1;
        int row[] = {0,1,0,-1};
        int col[] = {1,0,-1,0};
        int ans = 0;
        for(int a = 0 ; a<4 ; a++){
            ans+=f(i+row[a] , j+col[a] , grid , vis );
        }
        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    int vis[][] = new int[grid.length][grid[0].length];
                    for(int k[] : vis ){
                        Arrays.fill(k , 0 );
                    }
                    return f(i , j , grid , vis);
                }
            }
        }        
        return 0;
    }
}