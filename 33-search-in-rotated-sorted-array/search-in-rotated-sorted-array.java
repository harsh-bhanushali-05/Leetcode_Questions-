class Solution {
    public int search(int[] nums, int target) {
        int i = 0; 
        int j = nums.length-1;
        while(i <= j ){
            int mid = (j-i)/2+i;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] >= nums[i]){
                // left is sorted 
                if(target >= nums[i] && target <= nums[mid]){
                    // it is in the left part 
                    j= mid-1;
                }
                else{
                    i = mid+1;
                }
            }else{
                // right part of the array is sorted 
                if(nums[mid]<= target && nums[j]>= target ){
                    i = mid+1;
                }
                else{
                    j = mid-1; 
                }
            }
        }
        return -1; 
    }
}