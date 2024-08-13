class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer , Integer > map = new HashMap<>(); 
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i]-1 , 0 )+1 );
        }
        int max = 0;
        for(int i : map.keySet()){
            max = Math.max(map.get(i) , max);
        }
        return max;
    }
}