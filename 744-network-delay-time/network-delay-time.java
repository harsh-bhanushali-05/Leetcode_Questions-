class Solution {
    class Node{
        int node; 
        int wt; 
        Node(int node , int wt ){
            this.node = node; 
            this.wt = wt; 
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer , List<Node>> map = new HashMap<>(); 
        k--;
        for(int i[] : times ){
            i[0]--; 
            i[1]--; 
            if(map.containsKey(i[0]) == false){
                map.put(i[0] , new ArrayList<>());
            }
            map.get(i[0]).add(new Node(i[1] , i[2]));
        }
        int dist[] = new int[n];
        Arrays.fill(dist , (int)1e9);
        dist[k] = 0 ; 
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
        pq.offer(new Node(k , 0 ));
        while(pq.isEmpty()==false){
            Node curr = pq.poll(); 
            for(Node nbr : map.getOrDefault(curr.node, new ArrayList<>())){
                if(dist[nbr.node] > dist[curr.node] + nbr.wt){
                    dist[nbr.node] = dist[curr.node] + nbr.wt;
                    pq.offer(new Node(nbr.node , dist[nbr.node]));
                }
            }
        }
        int ans = 0;
        for(int i : dist ){
            ans = Math.max(i , ans );
        }
        if(ans >= (int)1e8){
            return -1;
        }
        return ans;
    }
}