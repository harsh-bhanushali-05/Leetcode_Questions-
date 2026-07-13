class Solution {
    public int trap(int[] height) {
        // right and left ka min - the current hieght 
        int right[] = new int[height.length]; 
        int left[] = new int[height.length];
        int max = 0; 
        for(int i = 0 ; i < height.length ; i++){
            left[i] = max;
            max = Math.max(max , height[i]);
        }
        max = 0; 
        for(int i = height.length-1 ; i >=0 ; i--){
            right[i] = max;
            max = Math.max(max , height[i]);
        }
        int ans = 0;
        for(int i = 0 ; i < height.length ; i++){
            ans+=Math.max(0 , Math.min(left[i],right[i]) - height[i]) ;
        }
        return ans;
    }
}