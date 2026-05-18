class Solution {
    public void f(int arr[] , HashMap<Integer , List<Integer>> map ){
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i])==false)
                map.put(arr[i] , new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }
    class Node{
        int node , dist; 
        Node(int node , int dist){
            this.node = node; 
            this.dist = dist; 
        }
    }
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(); 
        f(arr , map );
        Queue<Node> q = new ArrayDeque<>(); 
        q.offer(new Node(0 , 0 )); // this is the first index 
        int vis[] = new int[arr.length]; 
        vis[0] = 1 ; 
        while(q.isEmpty() == false){
            Node curr = q.poll(); 
            if(curr.node == arr.length-1 ){
                return curr.dist; 
            }
            // +1 chk 
            if(curr.node+1 != arr.length && vis[curr.node+1] == 0 ){
                q.offer(new Node(curr.node+1 , curr.dist+1));
                 vis[curr.node+1] = 1; 
            }
            // -1 chk 
            if(curr.node-1 >=0 && vis[curr.node-1] == 0 ){
                q.offer(new Node(curr.node -1 , curr.dist+1 ));
                 vis[curr.node-1] = 1; 
            }
            // all other nodes chk 
            for(int index : map.get(arr[curr.node])){
                if(vis[index] == 0){
                    vis[index] = 1; 
                    q.offer(new Node(index , curr.dist+1)); 
                }
                map.put(arr[curr.node] , new ArrayList<>());
            }
        }
        return -1 ; 
    }
}