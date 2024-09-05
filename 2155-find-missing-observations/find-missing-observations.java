class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i : rolls)
            sum += i;
        
        int m = rolls.length;
        int totalSum = (n + m) * mean; // Total required sum of all dice
        int missingSum = totalSum - sum; // Sum we need from missing n dice
        
        // If the missing sum is impossible to distribute with values between 1 and 6
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, missingSum / n); // Fill with the base average
        
        int remainder = missingSum % n; // Distribute the remainder
        for (int i = 0; i < remainder; i++) {
            ans[i]++;
        }
        
        return ans;
    }
}