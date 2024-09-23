class Solution {
    public boolean f(int nums[] , int i ){
        if(i == 0 ){
            if(nums.length == 1 )return nums[0]==0;
            if(nums[1]==1 || nums[0] == 1 )return false;
            return true;
        }
        else if(i == nums.length-1){
            if(nums[i-1] == 1 ||nums[i] == 1)return false;
            return true;
        }
        if(nums[i] ==1 || nums[i+1] == 1 || nums[i-1] == 1 )return false;
        return true;
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 1 is the occupied 0 is free 
        // 0 0 0 can be used. 
        int ans = 0;
        for(int i = 0 ; i < flowerbed.length ; i++){
            if(f(flowerbed , i )){
                ans++;
                i++;
            }
        }
        return ans>=n;
    }
}