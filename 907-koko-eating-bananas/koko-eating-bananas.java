class Solution {
    public long f(int mid , int arr[]){
        long time = 0 ;
        for(int i : arr){
            if(i%mid==0){
                time+=(i/mid); 
            }
            else{
                time+=(i/mid)+1;
            }
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int end = piles[0];
        int s =1;
        for(int i :piles){
            end=Math.max(i,end);
        }
        int ans = Integer.MAX_VALUE;
        int mid = (end-s)/2+s;
        while(s<=end){
            long time=f(mid , piles);
            if(time <= (long)h ){
                // he can finish all the piles of banana 
                ans= mid; 
                end=mid-1;
            }
            else{
                s=mid+1;
            }
            mid = (end-s)/2+s;
        }
        return ans;
    }
}