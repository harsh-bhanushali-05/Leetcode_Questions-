class Solution {
    public int waysToSplitArray(int[] nums) {
        //  left and total
        // left = [10, 14 , 6 , 13] total = 13 ... last index is not considered 10 , 14 
        long left[] = new long[nums.length]; 
        long curr = 0;
         for(int i = 0 ; i < left.length ; i++){
            curr+=nums[i];
            left[i] = curr;
         } 
         int ans = 0 ; 
         for(int i = 0 ; i < left.length-1 ; i++){
            if(left[left.length-1] - left[i] <=left[i]){
                ans++;
            }
         }
         return ans;
    }
}