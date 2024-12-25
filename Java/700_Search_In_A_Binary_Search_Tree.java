/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        //base case if our root is null we didnt find the node
        if(root == null) {
            return null;
            //if we hit the value simply return the node
        } else if(root.val == val) {
            return root;
        }
        //search through left subtree
        TreeNode left = searchBST(root.left, val);
        /*if we found something in the left subtree return the root otherwise search the 
        right subtree*/
        return left != null ? left : searchBST(root.right, val);
    }
}
