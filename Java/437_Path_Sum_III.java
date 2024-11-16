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
    public int pathSum(TreeNode root, int targetSum) {
        //if its null theres no paths obviously
        if(root == null) {
            return 0;
        }
        //check paths from here
        path_aux(root,0 ,targetSum);
        //and then check again starting at the child nodes
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return sol;
    }
    public void path_aux(TreeNode root, long sum, int target) {
        //if its null exit
        if(root == null) {
            return;
        }
        //check if new sum == target
        sum += root.val;
        if(sum == target) {
            sol++;
        }
        //check subtrees recursively
        path_aux(root.left,sum,target);
        path_aux(root.right,sum , target);
    }
    
}
