class Solution {
    public boolean isSubsequence(String s, String p, boolean[] removed) {
        int j = 0; // Index for string p
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[] removed = new boolean[s.length()];
            
            // Mark characters as removed up to index mid
            for (int i = 0; i <= mid; i++) {
                removed[removable[i]] = true;
            }
            
            if (isSubsequence(s, p, removed)) {
                left = mid + 1; // Try removing more characters
            } else {
                right = mid; // Try removing fewer characters
            }
        }
        
        return left;
    }
}