class Solution {
    public int f(int i , int j , String a , String b ,int dp[][]){
        if(a.length() <= i || b.length() <= j ){
            return 0; 
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = f(i+1 , j+1 , a, b,dp )+a.charAt(i);
        }
        else{
            int skip_a = f(i+1 , j , a , b,dp); 
            int skip_b = f(i, j+1 , a , b,dp); 
            return dp[i][j] = Math.max(skip_a , skip_b);
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int total = 0; 
        int dp[][] = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length() ; i++){
            total+=s1.charAt(i);
        }
        for(int i = 0; i < s2.length() ; i++){
            total+=s2.charAt(i);
        }
        for(int i[] :dp){
            Arrays.fill(i , -1);
        }
        int curr = f(0 , 0 , s1 , s2 ,dp); 
        return total - curr*2;
    }
}