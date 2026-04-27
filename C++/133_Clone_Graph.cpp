/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/


//Time complexity O(V + E), goes through every Vertex and Edge
//Space Complexity O(V) (Maximum V from stack, and V from hashmap)
class Solution {
public:
    std::unordered_map<Node*, Node*> visited;
    Node* cloneGraph(Node* node) {
        if(node == nullptr) {
            return nullptr;
        } else if(visited[node]) {
            return visited[node];
        }
        Node* new_node = new Node(node->val);
        visited[node] = new_node;
        std::vector<Node*> cpy_neighs;
        for(auto curr : node->neighbors) {
            cpy_neighs.push_back(cloneGraph(curr));
        }
        new_node->neighbors = cpy_neighs;
        return new_node;

    }
};
