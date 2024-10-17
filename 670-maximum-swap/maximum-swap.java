class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10]; // To store the last occurrence of each digit (0-9)
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // Try to find the first place where we can swap to get a larger number
        for (int i = 0; i < digits.length; i++) {
            // Check from digit 9 to current digit+1 to find a larger digit to swap
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap digits[i] with digits[last[d]]
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    // Return the integer after the swap
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        // Return the original number if no swap makes it larger
        return num;
    }
}