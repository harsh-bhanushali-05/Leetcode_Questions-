class Solution {
    public int f(int i, int m, int[] arr, boolean flag , int dp[][][]) {
        // Base case when all stones are taken
        if (i >= arr.length) {
            return 0;
        }
        if(dp[i][m][flag?1:0]!= -1)return dp[i][m][flag?1:0];
        int ans;
        if (flag) {
            ans = Integer.MIN_VALUE; // Maximize for Alice
        } else {
            ans = Integer.MAX_VALUE; // Minimize for Bob
        }
        for (int x = 1; x <= 2 * m && (i + x) <= arr.length; x++) {
            int stone = arr[i + x - 1] - (i == 0 ? 0 : arr[i - 1]);
            if (flag) {
                ans = Math.max(ans, stone + f(i + x, Math.max(m, x), arr, !flag , dp ));
            } else {
                ans = Math.min(ans, f(i + x, Math.max(m, x), arr, !flag , dp ));
            }
        }
        return  dp[i][m][flag?1:0] = ans;
    }
    public int stoneGameII(int[] piles) {
        int[] arr = new int[piles.length];
        int sum = 0;
        int index = 0;
        for (int i : piles) {
            sum += i;
            arr[index] = sum;
            index++;
        }
        int dp[][][] = new int[piles.length+1][piles.length+1][2];
        for(int i[][] : dp ){
            for(int j[]:i ){
                Arrays.fill(j , -1);
            }
        }
        return f(0, 1, arr, true , dp );
    }
}
