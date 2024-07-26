class Solution {
    public long f(int i , int nums[] , int prev , long dp[][] ){
        if(i==nums.length )return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        if(prev ==1 ){
            // last operation was ADD
            return dp[i][prev]= Math.max(f(i+1 , nums , 1, dp )+nums[i] , f(i+1 , nums , 0, dp ) -nums[i]);
        }
        return dp[i][prev]= nums[i] + f(i+1 , nums , 1, dp  );
    }
    public long maximumTotalCost(int[] nums) {
        long dp[][] =new long[nums.length][2];
        for(long i[] : dp )
            Arrays.fill(i , -1);
        return f(0 , nums , 0 , dp );   
    }
}