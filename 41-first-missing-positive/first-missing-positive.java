class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0 )continue;
            if(ans!=nums[i]){
                return ans;
            }
            while(i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }
            ans++;
        }
        return (nums[nums.length-1]+1) <=0 ? 1 : nums[nums.length-1]+1;
    }
}