class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1; // Start with at least one partition
        int start = nums[0]; // Start of the first partition
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                ans++; 
                start = nums[i]; 
            }
        }       
        return ans;
    }
}