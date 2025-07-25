class LRUCache {
    public class Node {
        Node next;
        Node prev;
        int val;
        int key;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    Node least;
    Node most;
    HashMap<Integer, Node> map;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        least = new Node(0,0);
        most = new Node(0,0);
        least.next = most;
        most.prev = least;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);

            addToEnd(curr);

            return curr.val;
        }
        return -1;
    }

    public void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

    }

    public void addToEnd(Node node) {
        most.prev.next = node;
        node.prev = most.prev;
        most.prev = node;
        node.next = most;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);

            delete(curr);

            addToEnd(curr);
            curr.val = value;
        } else {
            if(size == capacity) {
                Node toDelete = least.next;
                delete(toDelete);
                map.remove(toDelete.key);
                size--;
            }
            Node curr = new Node(key, value);
            map.put(key, curr);

            addToEnd(curr);
            size++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
