class Solution {
    public int f(int i , int nums[] , int dp[]){
        if(nums.length <= i ){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int take = f(i+2 , nums, dp )+nums[i];
        int not = f(i+1 , nums ,dp);
        return dp[i]=Math.max(take , not );
    }
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp , -1 );
        return f(0 , nums , dp );
    }
}
// this is the memoization solution for our questions 