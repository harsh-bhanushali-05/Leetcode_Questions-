class Trie {
    class Node{
        Node child[]; 
        boolean end; 
        Node(){
            child = new Node[26];
            Arrays.fill(child , null );
            end = false; 
        }
    }
    Node root = new Node(); 
    public Trie() {
        
    }
    
    public void insert(String word) {
        Node curr = root; 
        for(int i = 0 ; i < word.length(); i++){
            if(curr.child[word.charAt(i)-'a'] == null){
                // we need to add a new Node 
                curr.child[word.charAt(i)-'a']= new Node();
                curr = curr.child[word.charAt(i)-'a'];
            }else{
                curr = curr.child[word.charAt(i)-'a'];
            }
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Node curr = root; 
        for(int i = 0 ; i < word.length(); i++){
            if(curr.child[word.charAt(i)-'a'] == null){
                return false;
            }else{
                curr = curr.child[word.charAt(i)-'a'];
            }
        }
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
         Node curr = root; 
        for(int i = 0 ; i < prefix.length(); i++){
            if(curr.child[prefix.charAt(i)-'a'] == null){
                return false;
            }else{
                curr = curr.child[prefix.charAt(i)-'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */