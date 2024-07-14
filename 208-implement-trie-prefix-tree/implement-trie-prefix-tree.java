class Trie {
    class node{
        node [] child;
        boolean end;
        node(){
            child= new node[26];
            Arrays.fill(child , null);
            end = false;
        }
    }
    node root;
    public Trie() {
        root = new node();
    }
    
    public void insert(String word) {
        node curr = root;
        for(int i = 0 ; i < word.length() ; i ++){
            if(curr.child[word.charAt(i)-'a']==null){
                curr.child[word.charAt(i)-'a'] = new node();
            }
            curr = curr.child[word.charAt(i)-'a'];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        node curr = root;
        for(int i = 0; i<word.length() ; i++){
           if(curr.child[word.charAt(i)-'a']==null){
                return false;
            }
            curr = curr.child[word.charAt(i)-'a'];
        }
        return curr.end;
    }
    
    public boolean startsWith(String word) {
        node curr = root;
        for(int i = 0; i<word.length() ; i++){
           if(curr.child[word.charAt(i)-'a']==null){
                return false;
            }
            curr = curr.child[word.charAt(i)-'a'];
            if(i == word.length()-1)return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */