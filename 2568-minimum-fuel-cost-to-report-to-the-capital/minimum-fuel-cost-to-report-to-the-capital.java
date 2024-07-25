class Solution {
    long ans = 0;
    public int children(HashMap <Integer , List<Integer>> map , int node , int vis[] , int k ){
        if(vis[node] == 1)return 0;
        int child = 0;
        vis[node] = 1;
        for(int nbr : map.get(node)){
            child+= children(map , nbr , vis , k );
        }
        if(node == 0 )return child+1;
        ans+=(long)Math.ceil(child/k)+1;
        return child+1;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < roads.length +1 ; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i [] : roads){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        int vis[] = new int[map.size()];
        Arrays.fill(vis , 0);
        children(map , 0 , vis , seats);
        return ans;
    }
}