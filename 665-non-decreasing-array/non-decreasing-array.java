class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int max = Integer.MIN_VALUE;
            int count = 0;
            int index = 0;
            for(int j : nums ){
                if(index == i ){
                    index++;
                    continue;
                }
                if(j < max ){
                    count++;
                    if(count == 1)break;
                }
                max = Math.max(max , j );
                index++;
            }
            if(index == nums.length)return true;
        }
        return false;
    }
}