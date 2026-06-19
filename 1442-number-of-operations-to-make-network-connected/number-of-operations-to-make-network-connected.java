class Solution {
    class disjoint{
        int parent[]; 
        int rank[]; 
        disjoint(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }
        int ulimate_parent(int n ){
            if(n == parent[n]){
                return n;
            }
            return parent[n] = ulimate_parent(parent[n]);
        }
        boolean same(int u , int v ){
            int up = ulimate_parent(u);
            int vp = ulimate_parent(v); 
            return up==vp;
        }
        void union(int a , int b ){
            int ap = ulimate_parent(a);
            int bp = ulimate_parent(b);
            if(rank[ap] < rank[bp]){
                parent[ap] = bp;
            }
            else if(rank[bp] < rank[ap]){
                parent[bp] = ap;
            }else{
                rank[bp]++;
                parent[ap]=bp;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int r = 0; 
        disjoint dj = new disjoint(n);
        for(int co[] : connections){
            if(dj.same(co[0] , co[1])){
                r++;
            }
            else{
                dj.union(co[0] , co[1]);
            }
        }
        HashSet<Integer> set = new HashSet<>(); 
        for(int p : dj.parent){
            set.add(dj.ulimate_parent(p));
            // System.out.println(p);
        }
        if(set.size() -1 > r){
            return -1;
        }
        return set.size() -1;
    }
}