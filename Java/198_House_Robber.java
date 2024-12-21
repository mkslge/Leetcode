class Solution {
    //global variables that save past results and money in houses
    int [] mem;
    int [] houses;
    public int rob(int[] nums) {
        //initailize memoization array and fill with impossible values
        mem = new int[nums.length];
        Arrays.fill(mem, -1);

        //set global variable that stores value of profit in houses
        houses = nums;
        //set base case
        mem[0] = nums[0];

        //run helper
        return memoize(nums.length - 1);
    }

    public int memoize(int i) {
        //if we reached negative index we return 0
        if(i < 0) {
            return 0;
        } else if(mem[i] != -1) {
            //if we'eve reached already calculated value fetch from past result
            return mem[i];

        }
        //if we rob we skip adjacent house but add current house
        int rob = memoize(i - 2) + houses[i];
        //if we dont rob we use adjacent answer and dont add current house
        int dontRob = memoize(i - 1);

        //store result
        mem[i] = Math.max(rob, dontRob);

        return mem[i];
    }
    
}
