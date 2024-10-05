class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int arr[] = new int[26];
        int mat = 0;
        
        // Fill the frequency array for s1 and the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        
        // Count the mismatched positions after the first window
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) mat++;
        }
        
        // Sliding window over the rest of s2
        for (int i = s1.length(); i < s2.length(); i++) {
            if (mat == 0) return true; // If no mismatches, we found a valid permutation
            
            // Character going out of the window (i - s1.length())
            int outgoingCharIndex = s2.charAt(i - s1.length()) - 'a';
            if (arr[outgoingCharIndex] == 0) mat++; // Was balanced, now unbalanced
            arr[outgoingCharIndex]++;
            if (arr[outgoingCharIndex] == 0) mat--; // Now balanced again
            
            // Character coming into the window
            int incomingCharIndex = s2.charAt(i) - 'a';
            if (arr[incomingCharIndex] == 0) mat++; // Was balanced, now unbalanced
            arr[incomingCharIndex]--;
            if (arr[incomingCharIndex] == 0) mat--; // Now balanced again
        }
        
        // Final check for the last window
        return mat == 0;
    }
}