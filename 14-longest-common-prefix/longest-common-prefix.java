class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        while(true){
            if(strs[0].length() <= ans.length())break;
            char need = strs[0].charAt(ans.length());
            boolean flag = true;
            for(int i = 1 ; i < strs.length;i++){
                if(strs[i].length() <= ans.length() || strs[i].charAt(ans.length()) != need){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                break;
            }
            ans+=need; 
        }
        return ans;
    }
}