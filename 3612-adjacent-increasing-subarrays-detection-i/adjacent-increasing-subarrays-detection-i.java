class Solution {
    public boolean f(List<Integer> nums , int i , int k  ){
        int curr = nums.get(i); 
        for(int j = 1; j<k ; j++){
            if(curr >= nums.get(i+j)){
                return false;
            }
            curr = nums.get(i+j);
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int curr = 0; 
        int last = -1; 
        // if(k ==1 && nums.size() >1)return true;
        for(int i = 0 ; i <= nums.size()-(k*2); i++){
            boolean first = f(nums , i , k); 
            boolean second = f(nums , i+k , k );
            if(first && second )return true;
        }
        return false;
    }
}