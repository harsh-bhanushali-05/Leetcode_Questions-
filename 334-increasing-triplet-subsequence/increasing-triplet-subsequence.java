class Solution {
    public boolean increasingTriplet(int[] nums) {
        // int i , j , k -> i , j , k update. 
        // 1,2,3 -> if(curr < i ) update i if j is not filled 
        int  i  = Integer.MAX_VALUE;
        int  j  = Integer.MAX_VALUE;
        for(int curr  : nums ){
            if(i >=curr){
                i = curr;
            }
            else if( curr > i && j == Integer.MAX_VALUE){
                j = curr;
            }
            else if(curr > j){
                return true;
            }
            else if(curr < i && j == Integer.MAX_VALUE){
                i = curr;
            }
            else if( i < curr && curr < j){
                j = curr;
            }
        }
        return false;
    }
}