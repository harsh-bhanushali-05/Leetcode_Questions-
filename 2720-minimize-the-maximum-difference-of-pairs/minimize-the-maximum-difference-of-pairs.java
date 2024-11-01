class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFormPairs(nums, p, mid)) {
                right = mid; // Try for a smaller max difference
            } else {
                left = mid + 1; // Increase the max difference
            }
        }
        
        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;    
        for (int i = 1; i < nums.length && count < p; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; // Skip to the next pair
            }
        }
        
        return count >= p;
    }
}