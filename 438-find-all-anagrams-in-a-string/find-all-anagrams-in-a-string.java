class Solution {
    // Function to check if two HashMaps are equal
    private boolean chk(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (char key : map2.keySet()) {
            if (!map1.getOrDefault(key, 0).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        // Base case
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        // Frequency map for characters in p
        HashMap<Character, Integer> mapp = new HashMap<>();
        for (char c : p.toCharArray()) {
            mapp.put(c, mapp.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the first window of characters in s
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        // Check the first window
        if (chk(map, mapp)) {
            ans.add(0);
        }

        // Sliding window technique
        for (int i = p.length(); i < s.length(); i++) {
            // Remove the character that is sliding out of the window
            char toRemove = s.charAt(i - p.length());
            if (map.get(toRemove) == 1) {
                map.remove(toRemove);
            } else {
                map.put(toRemove, map.get(toRemove) - 1);
            }

            // Add the new character in the window
            char toAdd = s.charAt(i);
            map.put(toAdd, map.getOrDefault(toAdd, 0) + 1);
            if (chk(map, mapp)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }
}