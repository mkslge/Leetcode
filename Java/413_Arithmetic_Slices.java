class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //if length is less than 3 than we just exit since its too small
        if(nums.length < 3) {
            return 0;
        }
        
        int currDifference = nums[1] - nums[0];
        int sol = 0;
        //start stores the beginning of the current permutation
        int start = 0;

        for(int i = 2; i < nums.length;i++) {
            //if the difference is the same and the length is the long enough
            if(nums[i] - nums[i - 1] == currDifference && i - start >= 2) {
                //add it to the count
                sol += (i - start - 1);
                //otherwise if the difference is not the same
            } else if(currDifference != nums[i] - nums[i - 1]){
                //make a new difference
                currDifference = nums[i] - nums[i - 1];
                //reset the start
                start = i - 1;
            }
        }
        return sol;
    }
    

 }
