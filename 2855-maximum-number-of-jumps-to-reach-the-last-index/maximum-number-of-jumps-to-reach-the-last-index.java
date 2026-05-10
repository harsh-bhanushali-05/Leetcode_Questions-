class Solution {
    public int f(int i , int nums[] , int k , int dp[] ){
        if(i == nums.length-1 ){
            return 0;
        }
        if(dp[i]!= -1 ){
            return dp[i];
        }
        int ans = Integer.MIN_VALUE; 
        for(int j = i+1 ; j < nums.length ; j++){
            if(Math.abs(nums[i]-nums[j]) <= k ){
                int curr = f(j , nums , k ,dp ) ;
                if(curr!= Integer.MIN_VALUE ){
                    ans = Math.max(curr+1 , ans);
                }
            }
        }
        return dp[i] = ans;
    }
    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length]; 
        Arrays.fill(dp , - 1);
        int ans = f(0 , nums , target , dp );
        return ans > Integer.MIN_VALUE ? ans : -1 ;
    }
}