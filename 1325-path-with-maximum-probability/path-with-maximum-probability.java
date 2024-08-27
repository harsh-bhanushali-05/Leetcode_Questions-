class Solution {
    class Node{
        int node; 
        double wt;
        Node(int node , double wt ){
            this.node=node;
            this.wt=wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double arr[] = new double[n];
        Arrays.fill(arr , 0);
        HashMap<Integer , List <Node>> map = new HashMap<>();
        for(int i = 0 ; i < edges.length ; i++){
            if(map.containsKey(edges[i][0]) == false){
                map.put(edges[i][0] , new ArrayList<>());
            }
            if(map.containsKey(edges[i][1]) == false){
                map.put(edges[i][1] , new ArrayList<>());
            }
            map.get(edges[i][0]).add(new Node(edges[i][1] , succProb[i]));
            map.get(edges[i][1]).add(new Node(edges[i][0] , succProb[i]));
        }
        // hashmap is made 
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start_node);
        arr[start_node] = 1;
        while(q.isEmpty() == false){
            int curr = q.poll();
            for(Node nbr : map.getOrDefault(curr , new ArrayList<>())){
                if(nbr.wt*arr[curr] > arr[nbr.node]){
                    System.out.println("HEY");
                    arr[nbr.node] = nbr.wt*arr[curr];
                    q.offer(nbr.node);
                }
            }
        }
        return arr[end_node];
    }
}