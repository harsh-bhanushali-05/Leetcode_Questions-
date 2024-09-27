class Solution {
    public boolean isValidSudoku(char[][] board) {
        // each row // each col // each 3x3 box 
        HashMap<Integer , HashSet<Character>> row = new HashMap<>();
        HashMap<Integer , HashSet<Character>> col = new HashMap<>();
        HashMap<String  , HashSet<Character>> box = new HashMap<>();
        for(int i  = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == '.')continue;
                if(row.getOrDefault(i , new HashSet<>()).contains(board[i][j]))return false;
                if(col.getOrDefault(j , new HashSet<>()).contains(board[i][j]))return false;
                if(box.getOrDefault(Integer.toString(i/3) + "#" + Integer.toString(j/3), new HashSet<>() ).contains(board[i][j]))return false;
                if(row.containsKey(i)==false){
                    row.put(i , new HashSet<>());
                }
                if(col.containsKey(j) == false){
                    col.put(j , new HashSet<>());
                }
                if(box.containsKey(Integer.toString((i/3)) + "#" + Integer.toString((j/3))) == false ){
                    box.put(Integer.toString(i/3) + "#" + Integer.toString(j/3 ),new HashSet<>());
                }
                row.get(i).add(board[i][j]);
                box.get(Integer.toString((i/3)) + "#" + Integer.toString((j/3))).add(board[i][j]);
                col.get(j).add(board[i][j]);
            }
        }
        return true;  
    }
}