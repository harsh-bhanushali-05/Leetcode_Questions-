import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        // Step 1: Create an array of indices and sort it based on the values in nums
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        int maxWidth = 0;
        int minIndex = indices[0]; // Initialize the minimum index

        // Step 2: Traverse the sorted indices to find the maximum width ramp
        for (int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, indices[i] - minIndex);
            minIndex = Math.min(minIndex, indices[i]);
        }

        return maxWidth;
    }
}