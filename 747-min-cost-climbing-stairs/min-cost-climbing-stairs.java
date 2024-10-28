class Solution {
    public int f(int i , int nums[] ,int dp[] ){
        if(nums.length <= i ){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int one = f(i + 2 , nums, dp );
        int two = f(i + 1 , nums ,dp );
        return dp[i] = Math.min(one + nums[i], two + nums[i]);
    }
    public int minCostClimbingStairs(int[] cost) {
        // what is the min cost. 
        // start at 0 or 1 
        int dp[] = new int[cost.length];
        Arrays.fill(dp , -1 );
        int zero = f(0 , cost ,dp);
        Arrays.fill(dp , -1 );
        int one = f(1 , cost , dp );
        return Math.min(zero , one );

        // this is the memoization code 
    }
}