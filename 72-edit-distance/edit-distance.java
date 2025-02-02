class Solution {
    public int f(int i, int j, String a, String b, int dp[][]) {
        if (j == b.length()) {
            if (i == a.length()) {
                return 0;
            }
            return a.length() - i;
        }
        if (i == a.length()) {
            return b.length() - j;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = f(i + 1, j + 1, a, b, dp);
        }
        int insert = f(i, j + 1, a, b, dp) + 1;
        int delete = f(i + 1, j, a, b, dp) + 1;
        int replace = f(i + 1, j + 1, a, b, dp) + 1;
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        // insert -> i , j+1
        // delete -> i+1 , j
        // replace -> i+1 , j+1
        // return the min of the two
    }

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return f(0, 0, word1, word2, dp);
    }
}