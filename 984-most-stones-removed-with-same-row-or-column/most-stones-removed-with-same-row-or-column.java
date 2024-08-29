class Solution {
    public void dfs(HashSet<int[]> vis , int arr[] , int stones[][]){
        vis.add(arr);
        for(int i[] : stones ){
            if(vis.contains(i) == false ){
                if(i[0] == arr[0] || i[1] == arr[1])
                    dfs(vis , i , stones);
            }
        }
    }
    public int removeStones(int[][] stones) {
        HashSet<int[]> vis = new HashSet<>();
        int n = 0;
        for(int i[] : stones ){
            if(vis.contains(i) == false){
                dfs(vis , i , stones );
                n++;
            }
        }
        return stones.length - n ;
    }
}