class Solution {
    public int searchInsert(int[] nums, int target) {
        //set pointers up for binary search
        int left = 0, right = nums.length - 1;

        //check while there is unchecked subarry
        while(left <= right) {
            //get middle index
            int m = left + (right - left) / 2;
            //check if we found it
            if(nums[m] == target) {
                return m;
                //check smaller half if too big
            } else if(nums[m] > target) {
                right = m - 1;
            } else {
                //check bigger half if too small
                left = m + 1;
            }
        }
        //if unfound we return index we last checked since it should have been there
        return left;
    }
}
