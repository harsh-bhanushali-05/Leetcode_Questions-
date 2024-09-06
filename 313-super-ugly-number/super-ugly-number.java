class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long dp[] = new long[primes.length];
        Arrays.fill(dp, 1);
        long ans[] = new long[n + 1];
        ans[1] = 1;
        for (int i = 2; i < ans.length; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (min > ans[(int) dp[j]] * primes[j]) {
                    min = ans[(int) dp[j]] * primes[j];
                }
            }
            for (int j = 0; j < primes.length; j++) {
                if (min == ans[(int) dp[j]] * primes[j]) {
                    dp[j]++;
                }
            }
            ans[i] = min;
        }
        return (int)ans[ans.length - 1];
    }
}