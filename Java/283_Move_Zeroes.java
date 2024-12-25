class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            /*if we've reached a nonZero number we swap it with the left pointer which will
            be the latest zero we've seen*/
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                //move to the next index;
                left++;
            } 
            //if we found a zero we just keep going
            right++;
        }

    }
}
