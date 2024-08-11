class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int s = 0; 
        int e = nums.length -1 ;
        int mid = (e-s)/2+s;
        while(s<e){
            if(nums[mid] > mid ){
                s = mid+1;
            }
            else{
                e = mid - 1;
            }
            mid = (e-s)/2+s;
        }
        return nums[s];
    }
}