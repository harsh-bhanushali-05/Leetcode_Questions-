class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums[0]^0;
        for(int i = 1 ; i < nums.length ; i++){
            xor = xor ^ nums[i]^ i ;
        }
        xor = xor^nums.length;
        return xor;
    }
}