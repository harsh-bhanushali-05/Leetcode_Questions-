class Solution {
    public int findNumberOfLIS(int[] nums) {
        int arr[] = new int[nums.length]; 
        int freq[] = new int[nums.length];
        Arrays.fill(freq , 1);
        for(int i = 0 ; i < nums.length ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[prev] < nums[i]){
                    int curr = arr[prev]+1;
                    if(curr == arr[i]){
                        freq[i]+=freq[prev];
                    }else if(curr > arr[i]){
                        freq[i] = freq[prev]; 
                        arr[i] = curr; 
                    }
                }
            }
        }
        int ans = 0; 
        for(int i = 0 ; i < nums.length ; i++){
            System.out.println(nums[i] + " " + arr[i] + "  "+ freq[i]);
            ans = Math.max(ans , arr[i]);
        }
        int ret = 0; 
        for(int i = 0 ; i < nums.length ; i++){
            if(arr[i] == ans) { 
                ret+=freq[i];
            }
        }
        System.out.println(ans);
        return ret;
    }
}