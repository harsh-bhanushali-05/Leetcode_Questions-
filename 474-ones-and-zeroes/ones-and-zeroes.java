class Solution {
    public int f(int i , int arr[][] , int m , int n , int dp[][][] ){
        if(i == arr.length){
            return 0; 
        }
        if(dp[i][m][n] != 0){
            return dp[i][m][n];
        }
        if(arr[i][0] <= m && arr[i][1] <= n  ){
            // we can pick this item 
            int pick = f(i+1 , arr , m-arr[i][0] , n-arr[i][1] , dp )+1;
            int not = f(i+1 , arr , m , n , dp);
            return dp[i][m][n] = Math.max(pick , not );
        }
        else{
            return dp[i][m][n] = f(i+1 , arr , m , n ,dp);
        }
    }
    public int[][] makearr(String strs[] ){
        int arr[][] = new int[strs.length][2]; 
        for(int i = 0 ; i < strs.length; i++){
            for(char c : strs[i].toCharArray()){
                arr[i][c-'0']++;
            }
        }
        return arr;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int arr[][] = makearr(strs);
        return f(0 , arr , m , n , new int[arr.length][m+1][n+1]);
    }
}