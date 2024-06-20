class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff[] = new int[gas.length];
        int gs = 0;
        int cs = 0 ;
        for(int i = 0; i < gas.length ; i++){
            gs+=gas[i];
            cs+=cost[i];
            diff[i] = gas[i] - cost[i];
        }
        if(gs<cs)return -1;
        int ans = 0;
        int total = 0 ;
        for(int i=0; i < gas.length; i++){
            total+=diff[i];
            if(total < 0 ){
                total=0;
                ans=i+1;
                continue;
            }
        }
        return ans;
    }
}