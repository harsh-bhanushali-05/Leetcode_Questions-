class NumMatrix {
    HashMap<Integer , List<Integer>> map;
    public NumMatrix(int[][] matrix) {
        map = new HashMap<>();
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(map.containsKey(i) == false){
                    map.put(i , new ArrayList<>());
                    map.get(i).add(0);
                }
                map.get(i).add(map.get(i).get(map.get(i).size()-1)+matrix[i][j]);
            }   
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0; 
        for(int i = row1 ; i <= row2 ; i++){
            sum+=(map.get(i).get(col2+1) - map.get(i).get(col1));
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */