class Solution {
    static final int DRAW = 0;
    static final int MOUSE = 1;
    static final int CAT = 2;
    private List<int[]> parents(int[][] graph, int m, int c, int t) {
        List<int[]> res = new ArrayList<>();
        if (t == 0) {
            for (int pc : graph[c]) {
                if (pc != 0) res.add(new int[]{m, pc, 1});
            }
        } else {
            for (int pm : graph[m]) {
                res.add(new int[]{pm, c, 0});
            }
        }
        return res;
    }
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] dp = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        // Initialize degrees
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][0] = graph[m].length; // mouse moves
                degree[m][c][1] = graph[c].length; // cat moves
                for (int nei : graph[c]) {
                    if (nei == 0) degree[m][c][1]--;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        // Terminal states
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                dp[0][i][t] = MOUSE;
                q.offer(new int[]{0, i, t, MOUSE});

                if (i != 0) {
                    dp[i][i][t] = CAT;
                    q.offer(new int[]{i, i, t, CAT});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int m = cur[0], c = cur[1], t = cur[2], res = cur[3];

            for (int[] prev : parents(graph, m, c, t)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];
                if (dp[pm][pc][pt] != DRAW) continue;

                if (pt == 0 && res == MOUSE || pt == 1 && res == CAT) {
                    dp[pm][pc][pt] = res;
                    q.offer(new int[]{pm, pc, pt, res});
                } else {
                    degree[pm][pc][pt]--;
                    if (degree[pm][pc][pt] == 0) {
                        dp[pm][pc][pt] = (pt == 0 ? CAT : MOUSE);
                        q.offer(new int[]{pm, pc, pt, dp[pm][pc][pt]});
                    }
                }
            }
        }

        return dp[1][2][0];
    }
}