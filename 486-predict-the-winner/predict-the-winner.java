class Solution {
    public int f(int i , int j , int chance , int nums[] , HashMap<String , Integer> map ){
        if(j < i ){
            return 0;
        }
        String key = i + ":" + j + ":" + chance;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(chance == 1 ){ 
            int first = f(i+1 , j , (chance + 1) %2 , nums , map ); 
            int last = f(i , j-1 , (chance +1 )%2 , nums , map ) ; 
            map.put(key , Math.min(first ,last));
            return Math.min(first , last); 
        }
        int first = f(i+1 , j , (chance + 1) %2 , nums , map )+nums[i]; 
        int last = f(i , j-1 , (chance +1 )%2 , nums , map ) + nums[j]; 
        map.put(key , Math.max(first ,last));
        return Math.max(first ,last);
    }
    public boolean predictTheWinner(int[] nums) {
        int ans = f(0 , nums.length-1 , 0 ,nums , new HashMap<>()); 
        System.out.println(ans);
        int sum = 0; 
        for(int i: nums){
            sum+=i;
        }
        if(sum-ans <= ans){
            return true;
        }
        return false;
    }
}