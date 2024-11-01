class Solution {
    public int findMin(int[] nums) {
        int i = 0 ;
        int j = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(i<=j){
            int mid = (j-i)/2+i;
            if(nums[i] <= nums[mid]){
                ans = Math.min(ans , nums[i]);
                i=mid+1;
            }
            else{
                ans = Math.min(ans , nums[mid]);
                j = mid-1;
            }
        }
        return ans;
    }
}