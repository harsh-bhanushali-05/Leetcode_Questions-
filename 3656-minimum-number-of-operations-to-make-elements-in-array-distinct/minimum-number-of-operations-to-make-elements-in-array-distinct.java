class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>(); 
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums ){
            map.put(i , map.getOrDefault(i , 0 )+1);
            if(map.get(i) > 1){
                set.add(i);
            }
        }
        int remove = 0 ; 
        int ans = 0;
        while(set.isEmpty() == false){
            // remove 3 values 
            for(int j = remove ; j < remove+3 && j < nums.length ; j++){
                map.put(nums[j] , map.getOrDefault(nums[j] , 1 )-1);
                if(set.contains(nums[j]) && map.get(nums[j]) == 1 ){
                    set.remove(nums[j]);
                }
            }
            ans++;
            remove+=3;
        }
        return ans;
    }
}