class Solution {
    //global variable store solution
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        //run dfs
        dfs(k,n,1,new ArrayList<Integer>());
        //return solution
        return sol;
    }
    public void dfs(int k, int n, int start, ArrayList<Integer> curr) {
        //check if we've return end and have a list that satisfies conditions
        if(k == 0 && n == 0) {
            sol.add(new ArrayList<>(curr));
            return;
            //check if we reached end with invalid list
        } else if(k < 0 || n < 0 || k > n) {
            return;
        } 

        //go through adding possible values to list
        for(int i = start; i <= 9;i++) {
                curr.add(i);
                //make recursive call
                dfs(k - 1, n - i , i + 1,curr);
                //backtrack and iterate again
                curr.remove(curr.size() - 1);
        }
    }
}
