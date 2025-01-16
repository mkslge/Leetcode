class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] combinations = new int[target + 1];
        //base case is 0 can be represented as one way
        combinations[0] = 1;
        for(int i = 1; i <= target;i++) {
            //for each value in array add the combinations of the past calculations to new sol
            for(int num : nums) {
                //only if index is valid
                if(i - num >= 0) {
                    combinations[i] += combinations[i - num];
                }
            }
        }
        //return memoized answer
        return combinations[target];
    }
}
