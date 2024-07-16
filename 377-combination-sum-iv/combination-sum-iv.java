class Solution {
    public int f(int target , int i , int arr[] , int dp[][]){
        if(target < 0 )return 0;
        if(target == 0 )return 1;
        if( i == arr.length )return 0;
        if(dp[i][target]!=-1)return dp[i][target];
        int take = f(target - arr[i] , 0, arr,dp);
        int not = f(target , i+1 , arr,dp);
        return dp[i][target]=take + not;
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[][] = new int[nums.length][target+1];
        for(int x[] : dp)
            Arrays.fill(x,-1);
        return f(target , 0 , nums,dp );
    }
}