/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class BSTIterator {
public:
    std::stack<TreeNode*> stack;
    TreeNode* ptr;
    BSTIterator(TreeNode* root) {
        ptr = root;
    }
    
    int next() {
        while(ptr != nullptr) {
            stack.push(ptr);
            ptr = ptr->left;
        }
        TreeNode* top = stack.top();
        stack.pop();
        ptr = top->right;
        return top->val;

    }
    
    bool hasNext() {
        return ptr != nullptr || !stack.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
