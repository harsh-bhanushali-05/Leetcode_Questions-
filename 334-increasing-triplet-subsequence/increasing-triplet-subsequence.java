class Solution {
    public boolean increasingTriplet(int[] nums) {
        // find the increasing triplet 
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int index = 0;
        while(index < nums.length){
            if(i == Integer.MAX_VALUE || i > nums[index]){
                i = nums[index];
            }
            else if( i < nums[index] && j > nums[index]){
                j = nums[index];
            }
            else if(nums[index] > j )return true;
            index++;
        }
        return false;
    }
}