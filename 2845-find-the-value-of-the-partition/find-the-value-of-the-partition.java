class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length -1 ; i++){
            max = Math.min(max , nums[i+1] - nums[i]);
        }
        return max;
    }
}