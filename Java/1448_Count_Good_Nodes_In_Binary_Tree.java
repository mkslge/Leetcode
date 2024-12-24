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
    public int goodNodes(TreeNode root) {
        return goodNodeHelper(root, Integer.MIN_VALUE);
    }

    public int goodNodeHelper(TreeNode curr, int max) {
        //base case if we have a null we can exit function
        if(curr == null) {
            return 0;
        }
        //if we have a new maximum we need to add 1 to our result, otherwise keep it the same
        int goodNode = curr.val >= max ? 1 : 0;
        //update the maximum value for recursive calls
        max = Math.max(curr.val, max);
        //recursively check both subtrees
        return goodNode + goodNodeHelper(curr.left, max) + goodNodeHelper(curr.right, max);
    }


    
}
