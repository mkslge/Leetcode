class Solution {
    int [] getTo; //global array to store results
    public boolean canJump(int[] nums) {
        getTo = new int[nums.length + 1];
        
        return jumpHelper(nums,0);
    }
    public boolean jumpHelper(int [] nums, int index) {
        //if we reached end we made it so we can return
        if(index >= nums.length - 1 || getTo[index] == 1) {
            return true;
        } else if(getTo[index] == -1) {
            //if we have found the index cannot be reached we return false
            return false;
        }
        //go through all of the jumps possible and check if we can make it
        for(int i = nums[index]; i >= 1;i--) {
            if(jumpHelper(nums,index + i)) {
                //if true we store result in array and return
                getTo[index] = 1;
                return true;
            }
        }
        //otherwise we store the result and return false
        getTo[index] = -1;
        return false;
    }
}
