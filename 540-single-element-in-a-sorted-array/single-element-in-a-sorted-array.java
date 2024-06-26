class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0 ;
        int e = nums.length -2; 
        int mid = (e-s)/2+s;
        while(s<=e){
            if(mid%2==1){
                mid--;
            }
            else{
                if(nums[mid] == nums[mid+1]){
                    s = mid+2;
                }
                else{
                    e = mid-1;
                }
                 mid = (e-s)/2+s;
            }
        }
        return nums[s];
    }
}