class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0 ; 
        int j = nums.length-1; 
        if(nums.length == 1 ){
            return 0; 
        }
        while(i<=j){
            int mid = i + (j-i)/2;
            if(mid == 0 && nums[mid] > nums[mid+1]){
                return mid; 
            }
            else if(mid == nums.length-1 && nums[mid] > nums[mid-1]){
                return mid; 
            }
            else if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid] < nums[mid+1]){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return -1;
    }
}