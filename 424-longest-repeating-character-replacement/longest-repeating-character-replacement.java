import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int maxFreq = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(currentChar));
            while ((j - i + 1) - maxFreq > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++; // Shrink the window from the left
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}