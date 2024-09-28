class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>(); // sum , freq 
        int sum = 0;
        map.put(0 , 1 );
        int count = 0 ;
        for(int i : nums ){
            sum+=i;
            if(map.containsKey(sum - k )){
                count+=map.get(sum-k);
            }
            map.put(sum , map.getOrDefault(sum , 0 )+1);
        }
        return count;
    }
}