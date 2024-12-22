class Solution {
    public int f(int a , int b , int nums[] , int arr[] , int dp[][]){
        if(nums.length<= a || b >= arr.length)return 0;
        if(dp[a][b]!=-1)return dp[a][b];
        if(nums[a] == arr[b]){
            return dp[a][b] = f(a+1 , b+1 , nums , arr , dp)+1;
        }
        return dp[a][b] = Math.max(f(a+1 , b , nums , arr ,dp ) , f(a , b+1 , nums ,arr,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][]= new int[nums1.length][nums2.length];
        for(int i[] : dp ){
            Arrays.fill(i , -1);
        }
        return f(0 , 0 , nums1 , nums2 , dp);
    }
}




























































