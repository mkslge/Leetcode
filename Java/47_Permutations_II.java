class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //sort so we can skip duplicates later on
        Arrays.sort(nums);
        //keep track of visited 
        boolean [] visited = new boolean[nums.length];
        //run dfs once
        dfs(nums,visited, new ArrayList<>());
        //return global list of solutions
        return sol;
    }
    public void dfs(int [] nums, boolean [] visited, List<Integer> list ) {
        //check if we made it the end
        if(list.size() == nums.length) {
            sol.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length;i++) {
            //if we've previously skipped the number we want to always skip it
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            //if we havent visited it start one new permuation where we visit it 
            //and continue one where we do not visit it
            if(!visited[i]) {
                //add it and mark visited
                list.add(nums[i]);
                visited[i] = true;
                //call the function
                dfs(nums,visited,list);
                //but then backtrack 
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }
}
