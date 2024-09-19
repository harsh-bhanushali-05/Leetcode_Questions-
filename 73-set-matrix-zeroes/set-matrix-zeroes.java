class Solution {
    public void setZeroes(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        boolean firstColZero = false;

        // Step 1: Mark the first row and column if they should be zero.
        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true; // Mark if the first column should be zero
            }
            for (int j = 1; j < cols; j++) { // Start from 1 to avoid overwriting the first column
                if (arr[i][j] == 0) {
                    arr[i][0] = 0; // Mark the row to be zero
                    arr[0][j] = 0; // Mark the column to be zero
                }
            }
        }

        // Step 2: Set the elements to zero based on marks in the first row and column
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 3: Handle the first row separately
        if (arr[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                arr[0][j] = 0;
            }
        }

        // Step 4: Handle the first column separately
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                arr[i][0] = 0;
            }
        }
    }
}