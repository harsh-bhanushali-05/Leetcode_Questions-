class Solution {
    public int f(int x , int y , int m , int n , int dp[][]){
        if(x == m && y == n )return 1;
        if(x<0 || x> m || y<0 || y> n )return 0;
        if(dp[x][y]!=-1)return dp[x][y];
        return dp[x][y]= f(x+1,y,m,n, dp ) + f(x , y+1 , m,n ,dp );
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i[] : dp)
            Arrays.fill(i , -1 );
        return f(0 , 0 , m-1 , n-1 , dp );
    }
}