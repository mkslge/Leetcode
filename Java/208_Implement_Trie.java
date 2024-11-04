public class Node {
    //node class with 26 branches for every character in alphabet
    public  Node [] next = new Node[26];
    boolean hasEnd;
    public Node( boolean end) {
        hasEnd = end;
    }
    
}
class Trie {
    Node start;
    public Trie() {
        //create tree with no beginning at first
        start = new Node(false);
    }
    

    
    public void insert(String word) {
        
        Node curr = start;
        int length = word.length();
        //iterate through trie
        for(int i = 0; i < length ;i++) {
            int index = word.charAt(i) - 'a';
            //check if we need to create a new node
            if(curr.next[index] == null) {
                curr.next[index] = new Node(false);
            }
            //go to next branch
            curr = curr.next[index];
        }
        //make new branch if needed
        if(curr == null) {
            curr = new Node(true);
        }
        //or set end to true
        curr.hasEnd = true;
        
    }
    
    public boolean search(String word) {
        Node curr = start;
        int length = word.length();
        //iterate through word
        for(char ch : word.toCharArray()) {
            //if we have no branch we can return false
            if(curr.next[ch - 'a'] == null) {
                return false;
            }
            //go to next branch
            curr = curr.next[ch - 'a'];
        }
        //return true if there is an end 
        return curr.hasEnd;
    }
    
    public boolean startsWith(String prefix) {
        
        Node curr = start;
        int length = prefix.length();
        //iterate through word
        for(char ch : prefix.toCharArray()) {
            //return false if no branch
            if(curr.next[ch - 'a'] == null) {
                return false;
            }
            //go to next branch
            curr = curr.next[ch - 'a'];
        }
        //return true if it exists at all
        return true;
    }
}
