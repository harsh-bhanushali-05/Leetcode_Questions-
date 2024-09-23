class Solution {
    public int numUniqueEmails(String[] emails) {
        // is ignored and + ke badh is ignored 
        HashSet<String> set = new HashSet<>();
        for(String str : emails){
            String curr = "";
            for(int i = 0 ; i < str.length() ; i++){
                if(str.charAt(i) == '@'){
                    curr+=str.substring(i, str.length());
                    break;
                }
                if(str.charAt(i) == '.'){
                    continue;
                }
                if(str.charAt(i) == '+'){
                    while(str.charAt(i)!='@'){
                        i++;
                    }
                    i--;
                    continue;
                }
                curr+=str.charAt(i);
            }
            set.add(curr);
        }
        return set.size();
    }
}