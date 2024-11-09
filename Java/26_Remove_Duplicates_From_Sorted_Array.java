class Solution {
    public int removeDuplicates(int[] nums) {
        //pointers that keep track of where we need to add and the current
        //idnex we are searching
        int addPointer = 1;
        int currIndex = 0;
        //go through each element
        while(currIndex < nums.length) {
            //if we found a new element we need to add it to the array
            if(nums[addPointer - 1] != nums[currIndex]) {
                nums[addPointer++] = nums[currIndex];
            } 
            //always go to next element
            currIndex++;

        }
        //return number of unique elements
        return addPointer;
    }
}
