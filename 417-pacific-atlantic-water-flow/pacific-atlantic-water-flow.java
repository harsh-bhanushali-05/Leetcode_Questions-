class Solution {
    public void dfs(int i , int j , int vis[][] , int arr[][]){
        if( i < 0 || i >= vis.length || j < 0 || j >= arr[0].length ){
            return;
        }
        vis[i][j] = 1;
        int row[] = {1,0,-1,0};
        int col[] = {0,1,0,-1};
        for(int a = 0 ; a <4 ; a++){
            int newx = i + row[a];
            int newy = j + col[a];
            if(newx < 0 || newy < 0 || newx>= arr.length || newy>=arr[0].length)continue;
            if(arr[newx][newy] >= arr[i][j] && vis[newx][newy] == -1){
                dfs(newx , newy , vis , arr );
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int vis[][] = new int[heights.length][heights[0].length];
        for(int i[] : vis ){
            Arrays.fill(i , -1 );
        }
        for(int i = 0 ; i < heights.length ; i ++){
            dfs(i , 0 , vis , heights );
        }
        for(int i = 0 ; i < heights[0].length ; i++){
            dfs(0 , i , vis , heights );
        }
        int bis[][] = new int[heights.length][heights[0].length];
        for(int i[] : bis ){
            Arrays.fill(i , -1 );
        }
        for(int i = 0 ; i < heights.length ; i ++){
            dfs(i , heights[0].length-1 , bis , heights );
        }
        for(int i = 0 ; i < heights[0].length ; i++){
            dfs(heights.length-1 , i , bis , heights );
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                if(bis[i][j] == 1 && vis[i][j] == 1 ){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    list.add(new ArrayList<>(sub));
                }
            }
        }
        return list;
    }
}