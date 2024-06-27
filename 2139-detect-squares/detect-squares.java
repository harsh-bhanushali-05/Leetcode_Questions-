class DetectSquares {
    class point{
        int x; 
        int y; 
        point(int x , int y ){
            this.x=x;
            this.y=y;
        }
        @Override 
        public boolean equals(Object o){
            if(this==o)return true;
            point p = (point)o;
            return this.x == p.x && this.y==p.y;
        }
        @Override
        public int hashCode() {
            return 1;
        }
    }
    HashMap<point , Integer> map;
    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        point temp = new point(point[0] , point[1]);
        map.put(temp , map.getOrDefault(temp,0)+1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0 ;
        for(point temp : map.keySet()){
            if(Math.abs(x-temp.x) == Math.abs(y-temp.y) && x!=temp.x && y!=temp.y){
                // this is the diagonal same 
                // (x,y) , (temp.x , temp.y) , (temp.x , y ) , (x ,temp.y)
                point p1 = new point(temp.x , y );
                point p2 = new point(x , temp.y);
                ans+=(map.getOrDefault(temp , 0) * map.getOrDefault(p1 , 0)*map.getOrDefault(p2 , 0));
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */