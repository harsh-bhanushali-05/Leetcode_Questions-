class Solution {
    public int[] leftRightDifference(int[] nums) {
     int left[] = new int[nums.length];
     int sum =0;
     for(int i = 0 ; i < nums.length ; i++){
        left[i] = sum;
        sum+=nums[i];
    }   
    sum =0;
    for(int i = nums.length -1 ; i >=0 ; i--){
        left[i]-=sum;
        left[i] = Math.abs(left[i]);
        sum+=nums[i];
    }
    return left;
    }
}