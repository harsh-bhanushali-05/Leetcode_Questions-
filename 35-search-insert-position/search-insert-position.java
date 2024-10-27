class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0 ;
        int j = nums.length-1;
        while(i <= j ){
            int mid = (j-i)/2+i;
            if(nums[mid] == target ){
                while(mid >=0 && nums[mid] == target ){
                    mid--;
                }
                return mid+1;
            }
            else if(nums[mid] < target ){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return j+1;
    }
}