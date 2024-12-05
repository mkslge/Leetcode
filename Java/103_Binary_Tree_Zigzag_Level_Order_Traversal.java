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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //if null we return an empty list
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> sol = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        //add root to start
        deque.addFirst(root);
        //initalize boolean that controls order we add to our lists
        boolean normal = true;
        while(!deque.isEmpty()) {
            //save size and create sublist
            int size = deque.size();
            ArrayList<Integer> curr = new ArrayList<>();
            //if the list is normal we do normal bfs 
            if(normal) {
                for(int i = 0; i < size;i++) {
                    
                    TreeNode popped = deque.removeFirst();
                    //check if to see if we nodes are not null before adding
                    if(popped.left != null) {
                        deque.addLast(popped.left);
                    }
                    if(popped.right != null) {
                        deque.addLast(popped.right);
                    }
                    //add popped value to sublist
                    curr.add(popped.val);
                }
            } else {
                //now go in reverse order
                for(int i = 0; i < size;i++) {
                    //remove from end this time 
                    TreeNode popped = deque.removeLast();
                    //do right first this time
                    if(popped.right != null) {
                        deque.addFirst(popped.right);
                    }
                    if(popped.left != null) {
                        deque.addFirst(popped.left);
                    }
                    //add popped to sublist
                    curr.add(popped.val);
                }

            }
            //reverse order
            normal = !normal;
            //add sublist to solution
            sol.add(curr);
        }
        
        return sol;
    }
}
