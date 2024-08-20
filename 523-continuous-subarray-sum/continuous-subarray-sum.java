import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        // To handle cases where a valid subarray starts from index 0
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }
}
