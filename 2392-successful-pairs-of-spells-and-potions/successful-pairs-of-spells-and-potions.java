import java.util.Arrays;

class Solution {
    // Helper function to count successful pairs for a single spell
    public int f(int spell, int[] potions, long success) {
        int low = 0;
        int high = potions.length - 1;
        int ans = potions.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Cast to long to prevent overflow in multiplication
            if ((long) potions[mid] * spell >= success) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        // Return the count of successful pairs for this spell
        return potions.length - ans;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            result[i] = f(spells[i], potions, success);
        }
        return result;
    }
}