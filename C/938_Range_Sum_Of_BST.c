/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int rangeSumBST(struct TreeNode* root, int low, int high) {
    
    int toAdd = 0;
    //check to see if root is null as our base case
    if(!root) {
        return 0;
        //if the roots value is in our range we add it to our solution
    } else if(root->val <= high && root->val >= low) {
        toAdd = root->val;
    } 
    //add the value we need and recursively check both subtrees
    return toAdd + rangeSumBST(root->left,low,high) + rangeSumBST(root->right, low, high);

}
