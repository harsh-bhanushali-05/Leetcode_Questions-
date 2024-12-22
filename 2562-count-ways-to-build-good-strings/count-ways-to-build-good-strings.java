class Solution {
    public long f(int low , int high , int zero , int one , int curr , long dp[] ){
        int MOD = (int)1e9 + 7;
        if(curr > high )return 0; 
        if(dp[curr] !=-1)return dp[curr];
        long ans = 0; 
        if(curr >= low ){
            ans++;
        }
        ans+= (f(low , high , zero , one , curr+one ,dp)% MOD+f(low , high , zero , one , curr+zero,dp)% MOD)% MOD;
        return dp[curr] = ans;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = (int)1e9 + 7;
        long dp[] = new long[high+1 + zero + one +2];
        // Arrays.fill(dp , -1 );
        Arrays.fill(dp , 0 );
        // return (int)(f(low , high , zero , one , 0 , dp)% MOD);
        for(int i = high ; i >= 0 ; i--){
            dp[i] = (dp[i+zero] + dp[i+one] )%MOD;
            if(i <= high && i >=low){
                dp[i]++;
            } 
        }
        return (int)(dp[0]%MOD);
    }
}