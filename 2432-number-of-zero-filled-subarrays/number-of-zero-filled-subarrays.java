class Solution {
    public long zeroFilledSubarray(int [] nums) {
        // write the number of subarrays with '0'
        // 4 -> 4 3 2 1 
        HashMap<Long, Long> map = new HashMap<>(); // size , freq 
        long size = 0;
        for(int i : nums ){
            if(i != 0){
                map.put(size, map.getOrDefault(size, 0L) + 1L);
                size = 0;
            }
            if(i == 0 ){
                size++;
            }
        }
        map.put(size, map.getOrDefault(size, 0L) + 1L);
        long ans = 0;
        for(long i : map.keySet()){
            ans += (i * (i + 1) / 2) * map.get(i);
        }
        return ans;
    }
}