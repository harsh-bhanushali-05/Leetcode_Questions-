class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int x = 0;
        for(int i : nums ){
            ans+=x;
            x= Math.max(i , x );
        }
        return ans;
    }
}