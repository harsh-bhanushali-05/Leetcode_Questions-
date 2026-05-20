class Solution {
    public String pushDominoes(String dominoes) {
        int left[] = new int[dominoes.length()]; 
        int l = -1; 
        for(int i = dominoes.length() -1 ; i>=0 ; i--){
            if(dominoes.charAt(i) == 'L'){
                l = i ; 
            }
            if(dominoes.charAt(i) == 'R'){
                l = -1; 
            }
            if(l == -1 ){
                left[i] = -1 ; 
            }
            else{
                left[i] = l - i ; 
            }
        }
        int right[] = new int[dominoes.length()];
        l = -1; 
        for(int i = 0; i<dominoes.length()  ; i++){
            if(dominoes.charAt(i) == 'R'){
                l = i ; 
            }
            if(dominoes.charAt(i) == 'L'){
                l = -1; 
            }
            if(l == -1 ){
                right[i] = -1 ; 
            }
            else{
                right[i] = i - l ; 
            }
        }
        String ans = "";
        for(int i = 0 ; i < dominoes.length() ; i++){
            // System.out.println(left[i] + " " +right[i]);
            String curr= ".";
            if(left[i] == -1 && right[i] != -1 ){
                curr = "R";
            }
            if(left[i] != -1 && right[i] == -1){
                curr = "L";
            }
            if(left[i] != -1 && right[i]!= -1 ){
                if(left[i] < right[i]){
                    curr = "L";
                }
                if(left[i] > right[i]){
                    curr = "R";
                }
            }
            ans+=curr;
        }
        return ans;
    }
}