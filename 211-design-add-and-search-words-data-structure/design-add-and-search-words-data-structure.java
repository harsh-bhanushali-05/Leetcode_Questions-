class WordDictionary {
    class Node{
        Node child[]; 
        boolean end; 
        Node(){
            child = new Node[26];
        }
    }
    Node root = new Node(); 
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        Node curr = root; 
        for(int i = 0 ; i < word.length(); i++){
            if(curr.child[word.charAt(i)-'a'] == null ){
                curr.child[word.charAt(i)-'a'] = new Node();
            }
            curr = curr.child[word.charAt(i)-'a'];
        }
        curr.end = true;
    }
    public boolean f(int i ,String word , Node ro ){
        if(ro == null )return false;
        if(word.length()<=i )return ro.end;
        Node curr = ro; 
        if(word.charAt(i) == '.'){
            // replace with any letter 
            for(int k = 0 ; k < 26 ; k++)
            if(f(i+1 , word , curr.child[k]))return true;
            return false;
        }
        else{
            if(curr.child[word.charAt(i)-'a'] == null)return false; 
            return f(i+1 , word , curr.child[word.charAt(i)-'a'] );
        }
    }
    public boolean search(String word) {
        return f(0 , word , root );
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */