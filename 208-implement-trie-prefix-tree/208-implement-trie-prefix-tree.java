class TrieNode {
    TrieNode[] children;
    boolean end;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}

class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            
            curr = curr.children[c - 'a'];
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