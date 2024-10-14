class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer > map = new HashMap<>();
        int i = 0 ; 
        int j = 0 ;
        int ans = 0;
        while(j < nums.length){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0 )+1);
            while(map.get(nums[j]) > k){
                map.put(nums[i] , map.get(nums[i])-1 );
                i++;
            }
            j++;
            ans = Math.max(ans , j - i );
        }
        return ans;
    }
}