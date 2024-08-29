class Solution {
    public int totalSteps(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int max = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[i] = Math.max(ans[i] + 1, ans[st.pop()]);
            }
            st.push(i);
            max = Math.max(max, ans[i]);
        }
        
        return max;
    }
}