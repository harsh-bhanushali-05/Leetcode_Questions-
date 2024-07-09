class Solution {
    class disjoint{
        int parent[];
        int rank[];
        disjoint(int n ){
            parent = new int[n+1];
            for(int i = 0 ; i < n+1 ; i++)
                parent[i] = i;
            rank = new int[n+1];
            Arrays.fill(rank , 0 );
        }
        public int up(int i){
            if(i == parent[i])return i;
            return parent[i] = up(parent[i]);
        }
        public void union(int u ,int v ){
            int pu = up(u);
            int pv = up(v);
            if(pv==pu)return;
            if(rank[pu] == rank[pv]){
                rank[pu]++;
                parent[pv] = pu;
            }
            else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }
            else{
                parent[pu] = pv;
            }
        }
        public boolean same(int u , int v ){
            // if(parent[u]==parent[v])return true;
            int pu = up(u);
            int pv = up(v);
            return pu==pv;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        disjoint obj = new disjoint(edges.length);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < edges.length ; i++){
            if(obj.same(edges[i][0] , edges[i][1])){
                System.out.println("hello");
                list.add(edges[i][0]);
                list.add(edges[i][1]);
            }
            else{
                obj.union(edges[i][0] , edges[i][1]);
            }
        }
        int arr[] = new int[list.size()];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}