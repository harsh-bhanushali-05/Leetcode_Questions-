class Solution {
    class pair{
        int node; 
        int wt;
        pair(int node , int wt ){
            this.node=node;
            this.wt=wt;
        }
    }
    public int f(int vis[] , int i , Map<Integer , List<pair>> map ){
        int ans  = 0;
        vis[i]=1;
        for(pair nbr : map.get(i)){
            if(vis[nbr.node]!=1){
                ans+=nbr.wt;
                ans+=f(vis , nbr.node , map);
            }
        }
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer , List<pair>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
            map.put(i , new ArrayList<>());
        for(int i[] : connections){
            map.get(i[0]).add(new pair(i[1] , 1 ));
            map.get(i[1]).add(new pair(i[0] , 0 ));
        }
        int vis[] = new int[n];
        Arrays.fill(vis , 0);
        return f(vis , 0 , map);
    }
}