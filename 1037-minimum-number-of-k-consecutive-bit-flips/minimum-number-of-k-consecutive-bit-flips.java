class Solution {
  public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int flip = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            // Adjust the flip state for the current index
            if (i >= k) {
                flip ^= isFlipped[i - k];
            }

            // If the current bit needs to be flipped to 1
            if ((nums[i] ^ flip) == 0) {
                // If flipping from this index is not possible
                if (i + k > n) {
                    return -1;
                }

                // Record the flip
                isFlipped[i] = 1;
                flip ^= 1;
                ans++;
            }
        }

        return ans;
    }
}