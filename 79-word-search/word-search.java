class Solution {
    public boolean dfs(char [][] arr , int i , int j , int vis[][] , String str , int index ){
        if(index == str.length())return true;
        if(i <0|| j<0 || i>= arr.length || j>=arr[0].length )return false;
        if(vis[i][j]==1)return false;
        if(arr[i][j] != str.charAt(index))return false;
        vis[i][j]=1;
        int row[] = {1,0,-1,0};
        int col[] = {0,1,0,-1};
        for(int a = 0; a<4 ;a++){
            if(dfs(arr , i+row[a] , j+ col[a] , vis,str,index+1))return true;
        }
        vis[i][j]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int vis[][] = new int[board.length][board[0].length];
        for(int i =0 ; i< board.length ; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                for(int arr[] : vis)
                    Arrays.fill(arr , 0 );
                if(dfs(board , i , j , vis, word , 0  ))return true;
                }                
            }
        }
        return false;
    }
}