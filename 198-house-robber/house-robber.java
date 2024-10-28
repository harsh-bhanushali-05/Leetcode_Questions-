class Solution {
    public int rob(int[] nums) {
        int dp[]= new int[nums.length+2];
        Arrays.fill(dp , 0 );
        for(int i = nums.length-1 ; i >= 0 ; i--){
            dp[i] = Math.max(dp[i+2] + nums[i] , dp[i+1]);
        }
        return dp[0];
    }
}
// this is the memoization solution for our questions 