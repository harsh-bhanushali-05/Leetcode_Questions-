class Solution {
   public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long dist[][] = new long[26][26];
        for(long i[] : dist)
            Arrays.fill(i , (long)1e9);
        
        for(int i = 0 ; i < 26 ; i++){
            dist[i][i] = 0;
        }
        
        for(int i = 0 ; i < original.length ; i++ ){
            dist[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], dist[original[i] - 'a'][changed[i] - 'a'] );
        }
        
        for(int via = 0 ; via < 26 ; via++){
            for(int i = 0 ; i < 26 ; i++){
                for(int j = 0; j < 26; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        
        long ans = 0;
        for(int i = 0 ; i < source.length() ; i++){
            if(dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'] >= (long)1e9) return -1;
            ans += dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        
        return ans;
    }
}