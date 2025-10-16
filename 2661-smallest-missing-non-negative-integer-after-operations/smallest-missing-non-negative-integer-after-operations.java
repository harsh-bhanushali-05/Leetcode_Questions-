class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer , Integer> map = new HashMap<>(); 
        for(int i : nums ){
            i=i%value;
            while(i < 0 ){
                i = i+value;
            }
            map.put(i%value, map.getOrDefault(i%value, 0)+1);
        }
        int ans = 0;
        while(map.isEmpty()==false){
            int req = ans%value;
            if(map.getOrDefault(req , 0) >= 1){
                ans++;
                map.put(req%value, map.getOrDefault(req%value, 1)-1);
                if(map.get(req%value) == 0 ){
                    map.remove(req%value);
                }
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}