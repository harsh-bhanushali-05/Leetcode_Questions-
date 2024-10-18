class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> st = new Stack<>();
        for(String str :arr){
            if(str.equals("..")){
                if(st.isEmpty()==false)
                    st.pop();
            }
            else if(str.equals(".")){
                continue;
            }
            else if(str.equals("")){
                continue;
            }
            else{
                st.push(str);
            }
        }
        StringBuilder str = new StringBuilder("");
        while(st.isEmpty() == false){
            str.insert(0 , "/"+st.pop());
        }
        String ret = str.toString();
        if(ret.equals(""))return "/";
        return ret;
    }
}