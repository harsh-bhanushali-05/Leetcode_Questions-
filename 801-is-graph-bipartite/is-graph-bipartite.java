class Solution {
    public boolean f(int node , HashMap<Integer, List<Integer>> map , HashSet<Integer> a , HashSet<Integer> b , int i) {
        // i = 1 then set a ; i = 2 then set b 
        if(a.contains(node) && i==1)return true;
        if(a.contains(node) && i==2)return false;
        if(b.contains(node) && i==2)return true;
        if(b.contains(node) && i==1)return false;
        if(i==1){
            a.add(node);
        }
        else{
            b.add(node);
        }
        for(int nbr : map.get(node)){
            if(f(nbr , map , a , b , i==1?2:1) == false)return false ;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i=0; i < graph.length ; i++){
            if(map.containsKey(i)==false){
                map.put(i , new ArrayList<>());
            }
            for(int nbr : graph[i])
            map.get(i).add(nbr);
        }
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        for(int i = 0 ; i < graph.length ; i++){
            if(a.contains(i)==false && b.contains(i)==false){
                if(f(i , map , a, b,1)==false)return false;
            }
        }
        return true;
    }
}