class Solution {
    public int findSubstringInWraproundString(String s) {
        // Array to store the maximum length of valid substring ending with each character ('a' to 'z')
        int[] maxLength = new int[26];
        
        // Track the length of the current contiguous valid substring
        int currentLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check if the current character is contiguous to the previous one
            // Condition 1: Difference is exactly 1 (e.g., 'a' -> 'b')
            // Condition 2: Wraparound from 'z' to 'a'
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                currentLength++;
            } else {
                // If not contiguous, reset length to 1
                currentLength = 1;
            }
            
            // Get the index for the current character (0 for 'a', 25 for 'z')
            int index = s.charAt(i) - 'a';
            
            // Update the maximum length found so far ending with this specific character
            maxLength[index] = Math.max(maxLength[index], currentLength);
        }
        
        // The total number of unique valid substrings is the sum of the max lengths
        int totalUniqueSubstrings = 0;
        for (int length : maxLength) {
            totalUniqueSubstrings += length;
        }
        
        return totalUniqueSubstrings;
    }
}