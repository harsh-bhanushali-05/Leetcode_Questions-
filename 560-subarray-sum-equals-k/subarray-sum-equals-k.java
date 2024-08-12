class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>(); // this is the sum , freq of that freq 
        int sum = 0; 
        var count = 0;
        for(int i : nums ){
            sum+=i ; 
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            if(sum == k ){
                count++;
            }
            map.put(sum , map.getOrDefault(sum , 0 )+1 );
        }
        return count;
    }
}