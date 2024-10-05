class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans[][] = new int[nums.length/3][3];
        for(int i = 0 ; i < nums.length; i+=3){
            int curr = nums[i];
            if(nums[i+2] - nums[i] > k)return new int[0][0];
            ans[i/3][i%3] = nums[i];
            ans[i/3][(i+1)%3] = nums[i+1];
            ans[i/3][(i+2)%3] = nums[i+2];
        }
        return ans;
    }
}