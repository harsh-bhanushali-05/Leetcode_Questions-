class Solution {
    public void nextPermutation(int[] nums) {
        int max = -1;
        for(int i = nums.length-1 ; i>=0 ; i--){
            if(nums[i] < max ){
                // change this element 
                int flip = Integer.MAX_VALUE;
                int index = -1;
                for(int j = i+1 ; j < nums.length ; j++){
                    if(nums[j] > nums[i] && flip > nums[j]){
                        flip = nums[j];
                        index = j;
                    }
                }
                nums[index] = nums[i];
                nums[i] = flip;
                Arrays.sort(nums , i+1 , nums.length);
                return;
            }
            max = Math.max(max , nums[i]);
        }
        Arrays.sort(nums);
    }
}