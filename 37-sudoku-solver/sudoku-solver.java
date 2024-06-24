class Solution {
    public boolean f(HashMap<Integer, HashSet<Integer>> row, HashMap<Integer, HashSet<Integer>> col, HashMap<String, HashSet<Integer>> mat, int i, int j, char[][] board) {
        if (i == 9) return true;
        if (j == 9) return f(row, col, mat, i + 1, 0, board);
        if (board[i][j] != '.') return f(row, col, mat, i, j + 1, board);

        // Calculate the key for the 3x3 subgrid
        String key = Integer.toString(i / 3) + Integer.toString(j / 3);
        for (int a = 1; a <= 9; a++) {
            if (!row.get(i).contains(a) && !col.get(j).contains(a) && !mat.get(key).contains(a)) {
                board[i][j] = (char) (a + '0');
                row.get(i).add(a);
                col.get(j).add(a);
                mat.get(key).add(a);
                if (f(row, col, mat, i, j + 1, board)) return true;
                board[i][j] = '.';
                row.get(i).remove(a);
                col.get(j).remove(a);
                mat.get(key).remove(a);
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        // 9 row sets and 9 col sets and 9 subgrid sets
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
        HashMap<String, HashSet<Integer>> mat = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat.put(Integer.toString(i) + Integer.toString(j), new HashSet<>());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                row.get(i).add(num);
                col.get(j).add(num);
                String key = Integer.toString(i / 3) + Integer.toString(j / 3);
                mat.get(key).add(num);
            }
        }
        f(row, col, mat, 0, 0, board);
    }
}