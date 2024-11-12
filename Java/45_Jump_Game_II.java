class Solution {
    int [] memo;
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        //return final result
        return jumpHelper(nums,0);
    }

    public int jumpHelper(int [] nums, int index) {
        //if we made it then we need 0 jumps
        if(index >= nums.length - 1){
            return 0;
        } else if(memo[index] != -1) {
            //if we've already been here we can return the saved value
            return memo[index];
        }

        int minSol = Integer.MAX_VALUE;
        //for all possible jumps recursively check if they are the minimum jumps
        for(int i = nums[index]; i >= 1;i--) {
            int numJumps = jumpHelper(nums,index + i);
            if(numJumps != Integer.MAX_VALUE) {
                minSol = Math.min(minSol, numJumps + 1);
            }
            
        }
        //store solution and return
        memo[index] = minSol;
        return minSol;
    }

}
