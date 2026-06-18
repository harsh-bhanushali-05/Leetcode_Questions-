class Solution {
    class Node{ 
        int i , j , time; 
        Node(int i , int j , int time ){
            this.i= i ; 
            this.j = j; 
            this.time = time; 
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>(); 
        for(int i =0;i<grid.length;i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2 ){
                    q.offer(new Node(i , j , 0 ));
                }
            }
        }
        int row[] = {1,0,-1,0};
        int col[] = {0 , -1 , 0 , 1 };
        int time = 0 ; 
        while(q.isEmpty()==false){
            Node curr = q.poll(); 
            for(int a = 0 ; a < 4 ; a++){
                int rowx= curr.i + row[a];
                int colx = curr.j + col[a]; 
                if(rowx < 0 || colx< 0 || rowx>= grid.length || colx >= grid[0].length ){
                    continue;
                }
                if(grid[rowx][colx] == 1 ){
                    q.offer(new Node(rowx , colx , curr.time+1));
                    time = Math.max(time , curr.time+1);
                    grid[rowx][colx] = 2;
                }
            }
        }
        boolean list =Arrays.stream(grid)
                       .flatMapToInt(Arrays::stream)
                       .anyMatch(val -> val == 1);
        if(list){
            return -1; 
        }
        return time;
    }
}