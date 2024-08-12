class Solution {
    public void sortColors(int[] nums) {
        // lets have three pointers -> i j k 
        // j is the one traversing till we dont reach k 
        // k marks the start of 2, i is the end of the 1 and j is the current element that we are evaluating 
        // 
        int i = 0 ;
        int j = 0 ; 
        int k = nums.length-1;
        while(j <= k ){
            if(nums[j] == 1 ){
                j++;
                continue; 
            }
            if(nums[j] == 0){
                nums[j] = nums[i];
                nums[i] = 0 ;
                i++;
                j++;
                continue; 
            }
            else{
                nums[j]= nums[k];
                nums[k] = 2;
                k--;
            }
        }
    }
}