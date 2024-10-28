class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j ){
            int mid = (j -i )/2+i;
            if(mid%2==1)mid--;
            if(nums[mid] == nums[mid+1]){
                i = mid+2;
            }
            else{
                j = mid;
            }
        }
        return nums[i];
    }
}