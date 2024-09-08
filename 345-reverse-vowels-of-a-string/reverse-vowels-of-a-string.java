class Solution {
    public String reverseVowels(String s) {
        // reverse the vowels of the string 
        char a[] = new char[s.length()];
        String change = "";
        for(int i = 0 ; i < s.length() ; i++){
            a[i] = s.charAt(i);
            if(a[i] == 'a' ||a[i] == 'e' ||a[i] == 'i' ||a[i] == 'o' ||a[i] == 'u'|| a[i] == 'A' || a[i] == 'E' ||a[i] == 'I' ||a[i] == 'O' ||a[i] == 'U'){
                change = a[i]+change;
            }
        }
        int index = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(a[i] == 'a' ||a[i] == 'e' ||a[i] == 'i' ||a[i] == 'o' ||a[i] == 'u'|| a[i] == 'A' ||a[i] == 'E' ||a[i] == 'I' ||a[i] == 'O' ||a[i] == 'U'){
                a[i] =change.charAt(index);
                index++;
            }
        }   
        String ans = "";
        for(char c : a){
            ans+=c;
        }
        return ans;
    }
}