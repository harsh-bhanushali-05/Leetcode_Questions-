class Solution {
    public void f(int i , int j , char arr[][] , int vis[][]){
        if(i < 0 || j < 0 || i>= arr.length || j >=arr[0].length || arr[i][j] == '0'|| vis[i][j]==1){
            return;
        } 
        vis[i][j] = 1;
        f(i +1 , j , arr , vis);
        f(i , j +1, arr , vis);
        f(i - 1 , j , arr , vis);
        f(i , j-1 , arr , vis);
    }
    public int numIslands(char[][] grid) {
        int vis[][]= new int[grid.length][grid[0].length];
        for(int i[] : vis ){
            Arrays.fill(i , -1);
        }
        int ans = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && vis[i][j]!=1){
                    ans++;
                    f(i , j , grid , vis);
                }
            }
        }
        return ans;
    }
}