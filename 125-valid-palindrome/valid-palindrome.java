class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); 
        int i = 0 ; 
        int j = s.length() -1 ; 
        while(i < j ){
            char chari = s.charAt(i);
            char charj = s.charAt(j);
            System.out.println(chari + " " + charj );
            if(!Character.isDigit(chari) && !Character.isLetter(chari)){
                i++;
                continue;
            }
            if(!Character.isDigit(charj) && !Character.isLetter(charj)){
                j--;
                continue;
            }
            if(chari != charj){
                return false;
            }
            i++; 
            j--;
        }
        return true;
    }
}