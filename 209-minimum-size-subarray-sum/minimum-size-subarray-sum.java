class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans  = Integer.MAX_VALUE;
        int i = 0 ;
        int sum = 0 ;
        int j = 0;
        while(j < nums.length){
            sum+=nums[j];
            j++;
            while(sum >= target ){
                ans = Math.min(ans , j-i);
                sum-=nums[i];
                i++;
            }
        }
        // while(sum >= target ){
        //     ans = Math.min(ans , j-i);
        //     sum-=nums[i];
        //     i++;
        // }
        return ans == Integer.MAX_VALUE ? 0 : ans ;        
    }
}