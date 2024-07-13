class Solution {
    public int minCost(int n, int[] cuts) {
        int arr[]=new int[cuts.length+2];
        for(int i=0;i<cuts.length;i++)
            arr[i+1]=cuts[i];
        arr[0]=0;
        arr[arr.length-1]=n;
        Arrays.sort(arr);
        int dp[][]=new int[cuts.length+2][cuts.length+2];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],0);

        for(int i=cuts.length;i>0;i--){
            for(int j=1;j<=cuts.length;j++){
                if(i>j)continue;

                int min=Integer.MAX_VALUE;
                    for(int k=i;k<=j;k++){
                        int ans=arr[j+1]-arr[i-1]+dp[i][k-1]+dp[k+1][j];
                        min=Math.min(min,ans);
                    }
                dp[i][j]=min;
            }   
        }
        
        return dp[1][cuts.length];
    }
}// this is the tabulation solution 