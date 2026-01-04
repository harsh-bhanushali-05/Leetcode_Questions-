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
        for(int i : nums){
            ans+=f(i);
        }
        return ans;
    }
}