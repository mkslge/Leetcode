class Solution {
    //lists to store solutions
    List<List<Integer>> sol = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //run dfs that checks everything recursively
        dfs(nums);
        return sol;
    }
    public void dfs(int [] nums) {
        //check if we reached end
        int permLength = perm.size();
        if(permLength >= nums.length) {
            //add if satisfies restraints
            sol.add(new ArrayList<>(perm));
            return;
        }
        //go through recursively calling any permutations not made yet
        for(int i = 0; i < nums.length;i++) {
            if(!perm.contains(nums[i])) {
                perm.add(nums[i]);
                dfs(nums);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
