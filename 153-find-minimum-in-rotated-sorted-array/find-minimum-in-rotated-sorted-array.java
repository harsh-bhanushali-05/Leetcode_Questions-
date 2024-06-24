class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e= nums.length-1;
        int mid = (e-s)/2+s;
        while(s<=e){
            if(nums[s] <=nums[mid]){
                // left part of the array is sorted 
                ans = Math.min(ans , nums[s]);
                s=mid+1;
            }
            else{
                ans = Math.min(ans , nums[mid]);
                e=mid-1;
            }
            mid = (e-s)/2+s;
        }
        return ans;
    }
}