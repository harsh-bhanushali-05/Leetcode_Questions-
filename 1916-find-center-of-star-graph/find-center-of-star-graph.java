class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < edges.length ; i++){
            map.put(edges[i][0] , map.getOrDefault(edges[i][0] , 0 )+1 );
            map.put(edges[i][1] , map.getOrDefault(edges[i][1] , 0 )+1 );
        }
        for(int i : map.keySet()){
            if(map.get(i)==edges.length)return i;
        }
        return -1;
    }
}