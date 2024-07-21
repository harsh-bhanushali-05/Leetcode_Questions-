class Solution {
    public boolean doesAliceWin(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0 ; i < s.length() ; i++){
            if(set.contains(s.charAt(i)))return true;
        }
        return false;
    }
}