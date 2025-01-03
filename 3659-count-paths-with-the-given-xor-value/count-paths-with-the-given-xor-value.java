class Solution {
    int mod = (int) 1e9 + 7;
    public int f(int i, int j, int k, int[][] arr, int val, Integer[][][] memo) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return ((val ^ arr[i][j]) == k) ? 1 : 0;
        }
        if (i >= arr.length || j >= arr[0].length) {
            return 0;
        }
        if (memo[i][j][val] != null) {
            return memo[i][j][val];
        }
        int temp = val;
        val ^= arr[i][j];
        int ans = 0;
        ans = (ans + f(i + 1, j, k, arr, val, memo)) % mod; // Move down
        ans = (ans + f(i, j + 1, k, arr, val, memo)) % mod; // Move right
        memo[i][j][temp] = ans;
        return ans;
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
        Integer[][][] memo = new Integer[grid.length][grid[0].length][16];
        return f(0, 0, k, grid, 0, memo);
    }
}