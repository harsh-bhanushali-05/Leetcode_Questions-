class Solution {
    class pair{
        int x;
        int y;
        int time; 
        pair(int x , int y , int time ){
            this.x=x;
            this.y=y;
            this.time= time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int ans = 0 ;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.time - b.time);
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2 )
                    pq.offer(new pair(i , j , 0 )); // adding the rotten orange to the queue 
            }
        }
        while(pq.isEmpty()==false){
            pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int time = curr.time; 
            ans = Math.max(ans , time);
            int row[] = {1,0,-1,0};
            int col[] = {0 ,1 , 0 , -1 };
            for(int i = 0 ; i < 4 ; i++){
                int newx = row[i] + x;
                int newy = col[i] + y;
                if(newx < 0 || newx >= grid.length || newy < 0 || newy >=grid[0].length )continue;
                if(grid[newx][newy] == 1 ){
                    // this is a fresh orange 
                    pq.offer(new pair(newx , newy , time+1));
                    grid[newx][newy] = 2;
                }
            }
        }
        for(int i[] : grid){
            for(int j : i ){
                if(j == 1 )return -1;
            }
        }
        return ans;
    }
}                                             