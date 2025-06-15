/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //maps original node to new cloned node
    HashMap<Node, Node> found = new HashMap<>();
    public Node cloneGraph(Node node) {
        // if its null we just return null
        if(node == null) {
            return null;
            //if we already cloned this node then we return the cloned 
            //version
        } else if(found.containsKey(node)) {
            return found.get(node);
        }
        //clone node
        Node clone = new Node(node.val);

        //save to cloned nodes
        found.put(node, clone);


        //start new list
        clone.neighbors = new ArrayList<>();
        for(int i = 0; i < node.neighbors.size();i++) {
            //recursively clone neighbors
            clone.neighbors.add(cloneGraph(node.neighbors.get(i)));
            
        }
        return clone;
    }
    
}
