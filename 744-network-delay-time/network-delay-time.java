class Solution {
    class pair{
        int node; 
        int wt; 
        pair(int node , int wt ){
            this.node = node; 
            this.wt = wt;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            pair temp = (pair)obj;
            return temp.wt ==wt && temp.node == node;
        }
        public int hashCode() {
            return Objects.hash(node, wt);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        Arrays.fill(dist , (int)1e9);
        dist[0]=0;
        HashMap<Integer , ArrayList<pair>> map = new HashMap<>(); 
        for(int i = 0 ; i<=n ; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i = 0 ; i < times.length ; i++){
            map.get(times[i][0]).add(new pair(times[i][1] , times[i][2]));
        }
        dist[k]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.offer(new pair(k,0));
        while(pq.isEmpty()==false){
            pair temp = pq.poll();
            for(pair p : map.get(temp.node)){
                int totalwt = dist[temp.node] + p.wt;
                if(dist[p.node] > totalwt){
                    dist[p.node] = totalwt;
                    pq.offer(new pair( p.node , totalwt));
                }
            }
        }
        int ans = 0 ;
        for(int i : dist){
            System.out.println(i);
            ans = Math.max(i , ans);
        }
        return ans>(int)1e8?-1: ans;
    }
}