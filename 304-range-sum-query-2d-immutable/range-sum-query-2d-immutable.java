class NumMatrix {
    int arr[][];
    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0; j < arr[0].length ; j++){
                arr[i][j] = matrix[i][j];
                if(i > 0 )arr[i][j]+=arr[i-1][j];
                if(j > 0 )arr[i][j]+=arr[i][j-1];
                if(i>0 && j>0) arr[i][j]-=arr[i-1][j-1]; 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = arr[row2][col2];
        
        if (row1 > 0) {
            ans -= arr[row1 - 1][col2];
        }
        
        if (col1 > 0) {
            ans -= arr[row2][col1 - 1];
        }
        
        if (row1 > 0 && col1 > 0) {
            ans += arr[row1 - 1][col1 - 1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */