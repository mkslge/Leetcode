class Solution {
    public int pivotIndex(int[] nums) {
        //create arrays for prefix and postfix
        int [] prefix = new int[nums.length];
        int [] postfix = new int[nums.length];
        //set starting values for prefix and postfix
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        //calculate prefix
        for(int i = 1; i < nums.length;i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        //calculate postfix
        for(int i = nums.length - 2; i >= 0;i--) {
            postfix[i] = postfix[i + 1] + nums[i];
        }
        //check if any prefix and postfix are equal
        //starting from the left
        for(int i = 0; i < nums.length;i++) {
            //if something is found we return the given index
            if(prefix[i] == postfix[i]) {
                return i;
            }
        }
        //return -1 if nothing is found
        return -1;
    }
}
