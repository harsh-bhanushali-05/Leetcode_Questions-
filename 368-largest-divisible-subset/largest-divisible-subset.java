class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        
        // Step 1: Sort the array so we only have to check nums[i] % nums[prev] == 0
        Arrays.sort(nums);
        
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        // Every element is a valid subset of length 1 by itself
        Arrays.fill(dp, 1); 
        
        int maxLen = 1;
        int lastIndex = 0;
        
        // Step 2: Fill DP and Hash arrays
        for (int i = 0; i < n; i++) {
            hash[i] = i; // Initialize with its own index
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev; // Remember the path
                }
            }
            
            // Track the maximum length and the index where it ends
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        
        // Step 3: Reconstruct the subset using the hash array
        List<Integer> result = new ArrayList<>();
        result.add(nums[lastIndex]);
        
        while (hash[lastIndex] != lastIndex) { // While there is a previous element
            lastIndex = hash[lastIndex];
            result.add(nums[lastIndex]);
        }
        
        // Optional: The list is constructed backwards, so reverse it if you want ascending order
        Collections.reverse(result); 
        return result;
    }
}