class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i=0;
        int j=0;
        int sum=0;
        int ans=0;
        while(i<nums.length){
            if(j>=nums.length){
                j=i+1;
                i++;
                sum=0;
                continue;
            }
            sum+=nums[j];
            if(sum==goal){
                ans++;
                j++;
            }
            else if(sum>goal){
                i++;
                j=i;
                sum=0;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}