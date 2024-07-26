class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         int dist[][] = new int[n][n];
        for(int i [] : dist)
            Arrays.fill(i , (int)1e9);
        for(int i = 0 ; i < n ; i++)
            dist[i][i]=0;
        for(int arr[]:edges){
            dist[arr[0]][arr[1]] = arr[2];
            dist[arr[1]][arr[0]] = arr[2];
        }
        for(int via = 0; via < n ; via++){
            for(int i = 0 ; i < n ; i++){
                for(int j =0;j< n ; j++){
                    if(dist[i][j] > dist[i][via] + dist[via][j]){
                        dist[i][j] = dist[i][via] + dist[via][j] ;
                    }
                } 
            }
        }
        int node = -1;
        int ans = (int)1e9;
        for(int i = 0 ; i < dist.length ; i++){
            int curr =0;
            for(int j = 0 ; j < dist.length ; j++){
                if(dist[i][j] <=distanceThreshold )curr++;
            }
            if(curr <= ans){
                ans = curr; 
                node = i;
            }
        }
        return node;
    }
}