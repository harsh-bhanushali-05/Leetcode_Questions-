class Solution {
    class Node{
        Node [] children;
        boolean end;
        Node(){
            end = false;
            children = new Node[26];
            Arrays.fill(children , null);
        }
    }
    Node root = new Node();
    public boolean search(String str){
        Node curr = root;
        for(int i = 0 ; i < str.length();i++){
            if(curr.children[str.charAt(i)-'a'] == null)return false;
            curr = curr.children[str.charAt(i)-'a'];
        }
        return curr.end;
    }
    public void add(String str){
        Node curr = root;
         for(int i = 0 ; i < str.length();i++){
            if(curr.children[str.charAt(i)-'a'] == null){
                // doesnt exist create a new node 
                curr.children[str.charAt(i)-'a'] = new Node();
            }
            curr = curr.children[str.charAt(i)-'a'];
        }
        curr.end = true;
    }
    public boolean f(String str , int i , int dp[]){
        if(i == str.length()){
            return true;
        }
        if(dp[i]!=-1)return dp[i]==1;
        for(int len = str.length()-i; len>0 ; len--){
            String a = str.substring(i , i +len );
            // String b = str.substring(i+len, str.length());
            if(search(a)){
                if(f(str , i+len,dp)){
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str : wordDict){
            add(str);
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp , -1);
        return f(s , 0 ,dp);

    }
}