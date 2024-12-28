class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2]; // Include virtual balloons with value 1 at both ends
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2]; // DP table

        // Fill the DP table
        for (int length = 1; length <= n; length++) { // Range size
            for (int i = 1; i <= n - length + 1; i++) { // Start of the range
                int j = i + length - 1; // End of the range
                for (int last = i; last <= j; last++) { // Last balloon to burst in range [i, j]
                    int cost = arr[i - 1] * arr[last] * arr[j + 1]
                            + dp[i][last - 1] // Coins from the left subarray
                            + dp[last + 1][j]; // Coins from the right subarray
                    dp[i][j] = Math.max(dp[i][j], cost);
                }
            }
        }

        return dp[1][n]; // Maximum coins for the range [1, n]
    }
}