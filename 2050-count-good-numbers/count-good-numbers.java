class Solution {
    int MOD = (int)1e9 + 7;

    // Function to perform modular exponentiation
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long even = modPow(5, (n + 1) / 2, MOD); // Count of even positions
        long odd = modPow(4, n / 2, MOD);        // Count of odd positions
        long ans = (even * odd) % MOD;
        return (int) ans;
    }
}