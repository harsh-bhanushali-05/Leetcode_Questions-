class Solution {
    List<String> list = new ArrayList<>();
    public void f(String s , int i , String curr ){
        if(i == s.length()){
            list.add(curr);
            return;
        }
        if(Character.isLetter(s.charAt(i))){
            f(s, i+1 , curr+Character.toLowerCase(s.charAt(i)));
            f(s, i+1 , curr+Character.toUpperCase(s.charAt(i)));
        }
        else{
            f(s, i+1 , curr+s.charAt(i));
        }
    }
    public List<String> letterCasePermutation(String s) {
        f(s , 0 , "");
        return list;
    }
}