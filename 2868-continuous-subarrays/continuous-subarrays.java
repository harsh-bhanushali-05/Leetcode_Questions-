import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minDeque = new LinkedList<>(); // To store indices of potential minimums
        Deque<Integer> maxDeque = new LinkedList<>(); // To store indices of potential maximums
        int i = 0; // Left boundary of the sliding window
        long ans = 0;

        for (int j = 0; j < nums.length; j++) {
            // Maintain deque for minimum
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.addLast(j);

            // Maintain deque for maximum
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);

            // Adjust the left pointer if the difference between max and min exceeds 2
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] >= 3) {
                i++; // Move the left pointer
                // Remove elements outside the current window
                if (minDeque.peekFirst() < i) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() < i) {
                    maxDeque.pollFirst();
                }
            }

            // Add the number of valid subarrays ending at j
            ans += (j - i + 1);
        }

        return ans;
    }
}