class Solution {
    public int f(int i , int nums[] , int target , int dp[]){
        if(i == nums.length-1){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int ans = Integer.MIN_VALUE;
        for(int j = i+1 ; j < nums.length ; j++){
            if(Math.abs(nums[j] - nums[i]) <= target){
                ans = Math.max(ans , f(j , nums , target, dp)+1);
            }
        }
        return dp[i] = ans;
    }
    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , -1 );
        int ans = f(0, nums , target , dp );
        return ans <0? -1: ans ;   
    }
}