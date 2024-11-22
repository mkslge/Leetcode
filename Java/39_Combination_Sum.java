class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //do a dfs on all candidates
        dfs(candidates, target, 0,0);
        return sol;
    }
    public void dfs(int [] candidates,int target, int sum, int start) {
        int l = candidates.length;
        //if we ave gone over we can stop
        if(sum >= target ) {
            //if we have the exact sum we can add it to our list
            if(target == sum) {
                sol.add(new ArrayList<>(subset));
            }
            return;
        }
        
        //and for each possibility we recursively call 2
        //one where it contains the elemtn and one where it doesnt
        for(int i = start; i < l;i++) {
            sum += candidates[i];
            subset.add(candidates[i]);
            dfs(candidates,target,sum,i);
            sum -= candidates[i];
            subset.remove(subset.size() - 1);
        }

    }
}
