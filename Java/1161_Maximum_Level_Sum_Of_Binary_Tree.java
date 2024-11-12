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
    public int maxLevelSum(TreeNode root) {
        //placeholder max is minimum value
        int max = Integer.MIN_VALUE;
        //have queue to run bfs
        Queue<TreeNode> q = new LinkedList<>();
        //add first element
        q.add(root);
        //set level and curr max level
        int maxLevel = 0;
        int level = 0;
        //run bfs 
        while(!q.isEmpty()) {
            //increment level
            level++;
            int sum = 0;
            int size = q.size();
            //remove all nodes from same level
            for(int i = 0; i < size;i++) {
                TreeNode toAdd = q.remove();
                //add to queue for iterating through next level
                if(toAdd != null) {
                    sum += toAdd.val;
                    //check that node exists
                    if(toAdd.left != null) {
                        q.add(toAdd.left);
                    }
                    //check that node exists
                    if(toAdd.right != null) {
                        q.add(toAdd.right);
                    }
                }
                
                
            }
            //update max level
            if(sum > max) {
                maxLevel = level;
                max = sum;
            }
            

        }
        return maxLevel;
    }
}
