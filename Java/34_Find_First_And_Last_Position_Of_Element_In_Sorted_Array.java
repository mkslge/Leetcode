class Solution {
    public int[] searchRange(int[] nums, int target) {
        //set up binary search
        int left = 0, right = nums.length - 1;
        
        
        while(left <= right) {
            //get mid index
            int mid = left + (right - left) / 2;
            //check if equal
            if(nums[mid] == target) {
                //check where boundaries end for left side
                int leftSol = mid, rightSol = mid;
                while(leftSol >= 0 && nums[leftSol] == target) {
                    leftSol--;
                }
                //adjust back
                leftSol++;
                //check where boundaries end
                while(rightSol < nums.length && nums[rightSol] == target) {
                    rightSol++;
                }
                //adjust back
                rightSol--;
                //return solution
                return new int[]{leftSol,rightSol};
            } else if(nums[mid] < target) {
                //cut in half
                left = mid + 1;
            } else {
                //cut in half
                right = mid - 1;
            }
        }
        //if we exited loop we found nothing
        return new int[]{-1,-1};
    }
}
