class Solution {
    public boolean f(int curr, int mask, int dp[], int max, int total) {
        if (dp[mask] != -1) {
            return dp[mask] == 1;
        }

        for (int i = 1; i <= max; i++) {
            if ((mask & (1 << (i - 1))) == 0) {
                if (curr + i >= total) {
                    dp[mask] = 1;
                    return true;
                }

                int nextMask = mask | (1 << (i - 1));
                if (!f(curr + i, nextMask, dp, max, total)) {
                    dp[mask] = 1;
                    return true;
                }
            }
        }

        dp[mask] = 0;
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;

        int dp[] = new int[1 << maxChoosableInteger];
        Arrays.fill(dp, -1);

        return f(0, 0, dp, maxChoosableInteger, desiredTotal);
    }
}
