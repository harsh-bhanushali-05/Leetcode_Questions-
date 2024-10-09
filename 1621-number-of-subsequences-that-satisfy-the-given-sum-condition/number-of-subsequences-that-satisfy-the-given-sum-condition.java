import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        long ans = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        
        // Precompute powers of 2 up to nums.length using modulo to avoid repeated calculations
        int[] powerOfTwo = new int[nums.length];
        powerOfTwo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % mod;
        }
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + powerOfTwo[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        
        return (int) ans;
    }
}