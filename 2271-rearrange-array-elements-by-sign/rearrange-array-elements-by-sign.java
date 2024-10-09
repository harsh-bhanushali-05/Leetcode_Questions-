class Solution {
    public int[] rearrangeArray(int[] nums) {
        int x = 0;
        int arr[] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] >=0 ){
                arr[x] = nums[i];
                x+=2;
            }
        }
        x = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0 ){
                arr[x] = nums[i];
                x+=2;
            }
        }
        return arr;
    }
}