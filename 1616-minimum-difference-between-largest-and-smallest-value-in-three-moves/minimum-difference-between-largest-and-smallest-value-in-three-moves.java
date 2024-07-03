class Solution {
    public int f(int arr[] , int s , int e , int k ){
        if(s>=arr.length || e<0) return 0;
        if(s>e)return 0;
        if(k==0){
            return arr[e]-arr[s];
        }
        return Math.min(f(arr , s+1 ,e , k-1) , f(arr , s , e-1 , k-1)); 
    }
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return f(nums , 0 , nums.length-1 , 3);
    }
}