class Solution {
    public int index(int nums[] , int target ,int direction ){
        int i = 0 ; 
        int j = nums.length-1; 
        int ans = -1 ; 
        while(i <= j ){
            int mid = i + (j-i)/2;
            if(nums[mid] == target ){
                ans = mid; 
                if(direction == 1 ){
                    i = mid+1 ;
                }else{
                    j = mid-1; 
                }
            }
            else if(nums[mid] < target ){
                i = mid+1;
            }
            else{
                j = mid-1; 
            }
        }
        return ans; 
    }
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2]; 
        arr[0] = index(nums , target , 0 );
        arr[1] = index(nums , target , 1 );
        return arr;
    }
}