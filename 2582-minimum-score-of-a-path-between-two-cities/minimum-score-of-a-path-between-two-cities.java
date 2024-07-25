class Solution {
    class pair{
        int node; 
        int wt; 
        pair(int node , int wt ){
            this.node=node;
            this.wt=wt;
        }
    }
    public int f(int node , HashMap<Integer , List< pair>> map , int vis[]){
        if(vis[node] == 1 )return (int)1e9;
        int min = (int)1e9;
        vis[node]=1;
        for(pair nbr : map.get(node)){
            min = Math.min(min ,  nbr.wt );
            min  = Math.min(f(nbr.node , map , vis) , min);
        }
        return min;
    }
    public int minScore(int n, int[][] roads) {
        // int dist[] = new int[n];
        HashMap<Integer , List<pair>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put( i , new ArrayList<>());
        }
        for(int i [] : roads){
            map.get(i[0]-1).add(new pair(i[1]-1 , i[2]));
            map.get(i[1]-1).add(new pair(i[0]-1 , i[2]));
        }
        int dist[] = new int[n];
        Arrays.fill(dist , 0 );
        return f(0 , map , dist);
    }
}