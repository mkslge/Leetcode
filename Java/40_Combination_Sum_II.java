class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //sort the list to make it easier
        //doesnt affect time complexity
        Arrays.sort(candidates);
        dfs(candidates, target, 0,0);
        return sol;
    }
    public void dfs(int [] nums, int target, int sum, int i) {
        //if we have gone over or gone through whole list we can check if we
        //have the exact sum
        if(i >= nums.length || sum >= target) {
            //if we do we can add it to our list
            if(sum == target) {
                sol.add(new ArrayList<>(list));
            }
            
            return;
        }
        //now recursively check one where we add the element to our sum
        
        list.add(nums[i]);
        sum += nums[i];
        dfs(nums,target, sum,i + 1);
        //remove for next recursive call
        list.remove(list.size() - 1);
        sum -= nums[i];

        //and one where we dont
        int curr = nums[i];
        while(i < nums.length && curr == nums[i]) {
            i++;
        }
        dfs(nums,target,sum,i);

    }
    
}
