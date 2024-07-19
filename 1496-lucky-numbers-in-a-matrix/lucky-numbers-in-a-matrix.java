class Solution {
    public List<Integer> luckyNumbers (int[][] arr) {
        List<Integer> row = new ArrayList<>(); // row is the arr.length stores min so assigned max 
        List<Integer> col = new ArrayList<>(); // col is the arr[0].length 
        for(int i = 0 ; i < arr.length ; i++){
            row.add(Integer.MAX_VALUE);
        }
        for(int i = 0 ; i < arr[0].length ; i++){
            col.add(Integer.MIN_VALUE);
        }

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                row.set(i, Math.min(row.get(i), arr[i][j]));
                col.set(j, Math.max(col.get(j), arr[i][j]));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(row.get(i).intValue() == col.get(j).intValue() ){
                    ans.add(row.get(i));
                }
            }
        }
        return ans;
    }
}