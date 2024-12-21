class Solution {
    class bomb{
        long x;
        long y;
        long i;
        long r;
        bomb(long i , long x  , long y , long r ){
            this.i=i;
            this.x=x;
            this.y=y;
            this.r=r;
        }
    }
    public boolean f(bomb a , bomb b){
        long dx = (a.x - b.x) ;
        long dy = (b.y-a.y);
        long d= dx*dx+dy*dy;
        long r = (a.r*a.r);
        return d<=r;
     }
    public int maximumDetonation(int[][] bombs) {
        int dist[][] = new int [bombs.length][bombs.length];
        for(int i[] : dist)
            Arrays.fill(i , (int)1e9);
        for(int i = 0 ; i < dist.length ; i++){
            for(int j =0 ; j < dist.length ; j++){
                bomb a = new bomb(i , bombs[i][0] ,  bombs[i][1] , bombs[i][2]);
                bomb b = new bomb(j , bombs[j][0] ,  bombs[j][1] , bombs[j][2]);
                if(f(a,b)){
                    dist[i][j] = 0 ;
                }
                else{
                System.out.println("false");
                }
            }
        }
        for(int via = 0 ; via < dist.length ; via++){
            for(int i = 0 ; i < dist.length ; i++){
                for(int j = 0; j < dist.length ; j++){
                    dist[i][j] = Math.min(dist[i][j] , dist[i][via]+dist[via][j]);
                }
            }
        }
        int ans =0;
         for(int i = 0 ; i < dist.length ; i++){
            int curr= 0 ;
            for(int j =0 ; j < dist.length ; j++){
                if(dist[i][j]<(int)1e9)curr++;
            }
            ans = Math.max(curr , ans);
        }
        return ans;
    }
}