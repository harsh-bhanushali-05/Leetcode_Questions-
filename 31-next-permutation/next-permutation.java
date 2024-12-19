class Solution {
    public void nextPermutation(int[] nums) {
        int max = 0; 
        for(int i = nums.length -1 ; i >=0 ; i--){
            max = Math.max(max , nums[i]); 
            if(max > nums[i]){
                // we have found the element 
                // find the smallest greater element 
                int exchange = -1 ; 
                for(int j = i+1 ; j < nums.length ; j++){
                    if(nums[j] > nums[i] && (exchange == - 1 || nums[exchange] > nums[j])){
                        exchange = j ; 
                    }
                }
                // we found the element index to change with 
                int temp= nums[i]; 
                nums[i] = nums[exchange]; 
                nums[exchange] = temp;
                Arrays.sort(nums , i+1 , nums.length); 
                return;
            }
        }
        Arrays.sort(nums); 
        return; 
    }
}