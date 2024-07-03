class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0 ;
        HashMap<Integer , Integer> map = new HashMap<>();
        int i ; 
        for( i = 0 ; i < k ; i++){
            sum=sum+(long)nums[i];
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 )+1);
        }   
        long ans = 0 ;
        for(; i<nums.length ;i++){
            System.out.println(sum + " "+ans);
            if(map.size() == k){
                ans = Math.max(ans , sum );
            }
            sum = sum-(long)nums[i-k] + (long)nums[i];
            map.put(nums[i-k] , map.getOrDefault(nums[i-k],1)-1);
            if(map.get(nums[i-k]) == 0){
                map.remove( nums[i-k]);
            }
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        if(map.size() == k){
            ans = Math.max(ans , sum );
        }
        return ans;
    }
}