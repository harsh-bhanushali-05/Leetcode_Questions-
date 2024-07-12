class Solution {
    class tuple{
        int x;
        int y;
        int wt;
        tuple(int x , int y , int wt){
            this.x=x;
            this.y=y;
            this.wt=wt;
        }
    }
    public int swimInWater(int[][] grid) {
        int row[] = {1,0,-1,0};
        int col[] = {0,-1,0,1};
        int dist[][] = new int[grid.length][grid[0].length];
        for(int i[]:dist)
            Arrays.fill(i ,(int)1e9);
        Queue<tuple> q = new ArrayDeque<>();
        dist[0][0]=grid[0][0];
        q.offer(new tuple(0,0,grid[0][0]));
        while(q.isEmpty()==false){
            tuple temp = q.poll();
            for(int a = 0 ; a < 4 ; a++){
                int nx = temp.x+row[a];
                int ny = temp.y+col[a];
                // add chks 
                if(nx<0 || nx>=grid.length || ny<0 || ny>=grid.length )continue;
                if(dist[nx][ny] > Math.max(temp.wt , grid[nx][ny])){
                    dist[nx][ny] = Math.max(temp.wt , grid[nx][ny]);
                    q.offer(new tuple(nx , ny , Math.max(temp.wt , grid[nx][ny])));
                }
            }
        }
        return dist[grid.length-1][grid.length-1];
    }
}