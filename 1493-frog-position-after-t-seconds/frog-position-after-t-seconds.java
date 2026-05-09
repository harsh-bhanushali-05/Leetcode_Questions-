class Solution {
    class Node{
        int node; 
        int time; 
        double prob; 
        Node(int node , int time , double prob ){
            this.node = node ; 
            this.time = time; 
            this.prob = prob; 
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> list = new ArrayList<>(); 
        for(int i = 0; i < n ; i++){
            List<Integer> temp = new ArrayList<>(); 
            list.add(new ArrayList<>(temp)); 
        }
        for(int i[] : edges ){
            list.get(i[0]-1).add(i[1]-1);
            list.get(i[1]-1).add(i[0]-1);
        }
        list.get(0).add(0);
        Queue<Node> q = new ArrayDeque<>(); 
        q.offer(new Node(0 , 0 , 1));
        int vis[] = new int[n]; 
        vis[0] = 1; 
        target--;
        while(q.isEmpty() == false){
            Node curr = q.poll(); 
            System.out.println(curr.node + " " + curr.time + " " + curr.prob+" "+ list.get(curr.node).size());

            if(list.get(curr.node).size() == 1 ){
                if(curr.node == target && curr.time <= t ){
                    return curr.prob; 
                }
                if(curr.node == target){
                    return 0.0;
                }
                continue; 
            }
            double new_prob = curr.prob/(list.get(curr.node).size()-1); 
            int new_time = curr.time +1; 
            for(int nbr : list.get(curr.node)){
                if(vis[nbr] == 1 ){
                    continue; 
                }
                if(nbr == target ){
                    if(new_time == t ){
                        return new_prob; 
                    }
                    if(list.get(nbr).size()==1 && new_time <= t ){
                        return new_prob; 
                    }
                    return 0;
                }
                vis[nbr] = 1 ;
                q.offer(new Node(nbr , new_time , new_prob));
            }
        }
        return 0;
    }
}