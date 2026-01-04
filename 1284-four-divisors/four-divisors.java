class Solution {
    public int f(int curr){
        int count = 0; 
        int sum =0; 
        for(int i = 1 ; i <=curr ; i++){
            if(curr%i==0){
                count++;
                sum+=i; 
                if(count>4)break;
            }
        }
        if(count==4)return sum; 
        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0; 
        HashMap<Integer , Integer > map = new HashMap<>(); 
        for(int i : nums){
            if(map.containsKey(i)){
                ans+=map.get(i);
                continue;
            }
            int curr = f(i); 
            map.put(i , curr);
            ans+=curr;
        }
        return ans;
    }
}