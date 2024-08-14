class Solution {
    public void addStrings(String s , int i , int j , HashSet<String> set){
        for(int e=i+1;e<j;e++){
            String a= s.charAt(i)+""+s.charAt(e)+""+s.charAt(j);
            set.add(a);
        }
    }
    public int countPalindromicSubsequence(String s) {
        int i  = 0;
        int j =s.length()-1;
        HashSet < String > set =new HashSet<>();
        HashSet<Character> done = new HashSet<>();
        for(i = 0; i<s.length();i++){
            while(i<j && done.contains(s.charAt(i))==false){
                if(s.charAt(i)==s.charAt(j)){
                    addStrings(s,i,j,set);
                    break;
                }
                j--;
            }
            done.add(s.charAt(i));
            j=s.length()-1;
        }
        return set.size();
    }
}