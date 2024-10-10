class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));
        int maxWidth = 0;
        int minIndex = indices[0]; 
        for (int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, indices[i] - minIndex);
            minIndex = Math.min(minIndex, indices[i]);
        }
        return maxWidth;
    }
}