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
    int sol = 0;
    public int minCameraCover(TreeNode root) {

        int covered = dfs(root);
        //if the root is uncovered we add 1 our solution
        return covered == 0 ? sol + 1 : sol;
    }
    //returning 2 means a node is covered
    //returning 1 means the node has a camera on it
    //returning 0 means the camera is uncovered
    public int dfs(TreeNode curr) {
        //if node is null its essentially covered
        if(curr == null) {
            return 2;
        }
        //check subtrees being covered
        int leftSide = dfs(curr.left);
        int rightSide = dfs(curr.right);

        //if either subtree is uncovered we have to cover it so we increment
        //and return 1 (meaning it has a camera)
        if(leftSide == 0 || rightSide == 0) {
            sol++;
            return 1;
        }
        //if any side has a camera now the parent is covered so we can return 2
        if(leftSide == 1 || rightSide == 1) {
            return 2;
        } else {
            //otherwise it is uncovered
            return 0;
        }
    }
}
