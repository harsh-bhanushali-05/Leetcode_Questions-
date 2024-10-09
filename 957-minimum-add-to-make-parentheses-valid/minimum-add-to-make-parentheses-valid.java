class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else{
                if(st.isEmpty() == false ){
                    st.pop();
                }
                else{
                    ans++;
                }
            }
        }
        return ans + st.size();
    }
}