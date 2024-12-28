class Solution {
    public int f(int i , int j , int arr[], int dp[][]){
        if(j< i)return 0 ;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int last = i ; last<= j ; last++){
            int cost = (arr[i-1] * arr[j+1] * arr[last]) + f(i , last-1 ,arr, dp )+f( last+1 , j , arr, dp );
            ans = Math.max(ans , cost);
        }
        return dp[i][j] =  ans;
    }
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length+2];
        arr[0] = 1; 
        arr[arr.length-1] = 1; 
        for(int i = 0 ; i< nums.length ; i++){
            arr[i+1] =nums[i];
        }
        int dp[][] = new int[arr.length][arr.length];
        for(int i[] : dp )
            Arrays.fill(i , -1);
        return f(1, nums.length , arr , dp );
    }
}