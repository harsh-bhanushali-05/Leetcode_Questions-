class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        // there should be atleast 2 bandned words 
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(String str : bannedWords){
            set.add(str);
        }
        for(String str : message){
            if(set.contains(str))
                count++;
        }
        return count>=2;
    }
}