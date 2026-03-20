class Solution {
    Map<Long, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        return solve((long) n);
    }

    private int solve(long n) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int res;
        if (n % 2 == 0) {
            res = 1 + solve(n / 2);
        } else {
            // We use long so (n + 1) doesn't overflow Integer.MAX_VALUE
            res = 1 + Math.min(solve(n + 1), solve(n - 1));
        }

        memo.put(n, res);
        return res;
    }
}