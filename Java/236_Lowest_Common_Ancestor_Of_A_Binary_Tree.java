class Solution {
    TreeNode sol = null, p = null, q = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return sol;
    }

    private boolean dfs(TreeNode curr) {
        if(curr == null) {
            return false;
        } else if(curr == p || curr == q) {
            sol = curr;
            return true;
        } 
        boolean leftHasOne = dfs(curr.left);
        boolean rightHasOne = dfs(curr.right);
        boolean bothSidesHaveOne = leftHasOne && rightHasOne;
        if(bothSidesHaveOne) {
            sol = curr;
            return true;
        }
        return leftHasOne || rightHasOne;
    }
}
