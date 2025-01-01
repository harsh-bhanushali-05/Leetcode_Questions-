class Solution {
    public int maxScore(String s) {
        int zero[] = new int[s.length()];
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                count++;
            }
            zero[i] = count;
        }
        int ans = 0;
        count = 0; 
        for(int i = s.length()-1 ; i>=0 ; i--){
            if(count+zero[i] > ans && i != s.length()-1){
                ans = count + zero[i];
            }
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return ans;
    }
}