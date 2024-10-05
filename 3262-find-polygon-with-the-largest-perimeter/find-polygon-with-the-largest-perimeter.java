class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum[] = new long[nums.length];
        long curr = 0;
        for(int i = 0; i < nums.length ; i++){
            sum[i] = curr;
            curr+=nums[i];
        }
        long  ans = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(sum[i] > nums[i]){
                ans = Math.max(sum[i]+nums[i] , ans );
            }
        }
        return ans;
    }
}