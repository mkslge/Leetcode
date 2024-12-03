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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //base case
        if(root == null) {
            return 0;
        }
        //if both values are in range we add the value and check both
        //subtrees
        if(root.val <= high && root.val >= low) {
            return root.val + rangeSumBST(root.left,low,high)
            + rangeSumBST(root.right, low, high);
            //otherwise if root is less or equal to high we check right
        } else if(root.val <= high) {
            return rangeSumBST(root.right, low,high);
        } else {
            //otherwise we check left subtree as root is more than low
            return rangeSumBST(root.left,low,high);
        } 
    }
}
