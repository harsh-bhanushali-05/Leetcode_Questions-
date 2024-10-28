class Solution {
    public int longestSquareStreak(int[] nums) {
        // after sorting 
        Arrays.sort(nums);
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = nums.length-1 ; i >=0 ; i--){
            map.put(nums[i] , map.getOrDefault(nums[i] * nums[i] , 0 )+1);
            ans = Math.max(map.get(nums[i]) , ans);
        }
        if(ans < 2)return -1;
        return ans;
    }
}