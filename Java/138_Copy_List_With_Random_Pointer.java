/*
The key idea here is to first make a hashmap that maps the old node to the node, and then to use that when iterating through, and simply grab the 
NEW random pointer when needing to when iterating through the list.
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        Node dummy = new Node(0);
        Node toAdd = dummy;
        curr = head;
        while(curr != null) {
            toAdd.next = map.get(curr);
            if(curr.random != null) {
                toAdd.next.random = map.get(curr.random);
            }
            toAdd = toAdd.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    
}
