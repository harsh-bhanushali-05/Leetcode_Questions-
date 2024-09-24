class Solution {
    public boolean wordPattern(String pattern, String s) {
        // keep 2 hashmaps and find out 
        HashMap<Character , String> a = new HashMap<>();
        HashMap<String , Character> b = new HashMap<>();
        String arr[] = s.split(" ");
        
        // Check if lengths don't match
        if(pattern.length() != arr.length) return false;

        // Iterate through the pattern and string array
        for(int i = 0; i < arr.length ; i++){
            char currentChar = pattern.charAt(i);
            String currentWord = arr[i];

            // If both pattern and string word are not in the hashmaps
            if(!a.containsKey(currentChar) && !b.containsKey(currentWord)){
                // Add them to the hashmaps
                a.put(currentChar, currentWord);
                b.put(currentWord, currentChar);
            }
            // If mismatch in pattern mapping
            else if((a.containsKey(currentChar) && !a.get(currentChar).equals(currentWord)) || 
                    (b.containsKey(currentWord) && b.get(currentWord) != currentChar)){
                return false;
            }
        }
        return true;
    }
}