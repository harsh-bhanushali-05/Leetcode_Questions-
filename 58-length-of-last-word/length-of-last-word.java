class Solution {
    public int lengthOfLastWord(String s) {
        String arr []=s.split(" ");
        String ans = "";
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].trim() !=""){
                ans = arr[i].trim();
            }
        }
        return ans.length();
    }
}