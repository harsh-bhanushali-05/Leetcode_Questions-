class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        // Convert integers to strings
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        // Sort the array with a custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Build the final result
        StringBuilder sb = new StringBuilder();
        for (String num : numStrs) {
            sb.append(num);
        }

        return sb.toString();
    }
}