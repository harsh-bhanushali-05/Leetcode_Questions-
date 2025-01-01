class Solution {
    public String answerString(String word, int numFriends) {
        // get the largest character 
        if(numFriends == 1 )return word;
        int ans = 0;
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) - 'a' > ans ){
                ans = word.charAt(i)-'a';
                // index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) - 'a' == ans){
                list.add(i);
            }
        }
        List<String> ret = new ArrayList<>();
        for(int index : list){
            if(index >= numFriends-1){
                ret.add(word.substring(index , word.length()));
            }
            else{
                ret.add( word.substring(index , word.length()-numFriends+index+1));
            }
        }
        Collections.sort(ret);
        return ret.get(ret.size()-1);
    }
}