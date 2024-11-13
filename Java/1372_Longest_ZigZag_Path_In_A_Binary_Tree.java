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
    public int longestZigZag(TreeNode root) {
        //if root is null we exit
        if(root == null) {
            return 0;
        }
        //otherwise we recursively check both subtrees
        return Math.max(aux(root,true,0), aux(root,false,0));
    }
    public int aux(TreeNode curr, boolean left, int val) {
        //if the curr node is null we return our accumulator
        if(curr == null) {
            return val - 1;
        }
        
        //otherwise we check between two cases
        //if we go to our left, we return the maximum between
        //our the next zig zag, versus a non zig zag but starting back at 0
        //in the other case we do the same but with the other subtree
        return left ? Math.max(aux(curr.right,false,val + 1), aux(curr.right,true,0))
         : Math.max(aux(curr.left,true,val + 1), aux(curr.left,false,0));
    }
}
