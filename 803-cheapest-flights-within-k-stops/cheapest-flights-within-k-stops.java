class Solution {
    class pair{
        int node; 
        int wt;
        pair(int node , int wt ){
            this.node = node;
            this.wt =wt;
        }
    }
    class tuple{
        int node;
        int wt;
        int stops;
        tuple(int node , int wt , int stops ){
            this.node = node;
            this.wt=wt;
            this.stops= stops ;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<pair>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i = 0 ; i < flights.length ; i++){
            map.get(flights[i][0]).add(new pair(flights[i][1] , flights[i][2]));
        }
        Queue<tuple> pq = new ArrayDeque<>();
        int dist[] = new int[n];
        Arrays.fill(dist , (int) 1e9);
        dist[src] = 0;
        pq.offer(new tuple(src , 0 , 0 ));
        while(pq.isEmpty()==false){
            tuple temp = pq.poll();
            if(temp.stops>k)continue;
            for(pair p : map.get(temp.node)){
               if(dist[p.node] > temp.wt + p.wt){
                    dist[p.node] = temp.wt + p.wt;
                    pq.offer(new tuple(p.node , dist[p.node] , temp.stops+1));
               }
            }
        }
        return dist[dst]>(int)1e8?-1:dist[dst];
    }
}