class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        //set up 2 references for binary search
        int left = 0, right = nums.size() - 1;
        
        while(left <= right) {
            //calculate mid index
            int mid = left + (right - left) / 2;
            //check if we found our target
            if(nums[mid] == target) {
                //if we did we have to adjust our boundaries for our left
                //and right pointers
                int shiftLeft = mid, shiftRight = mid;
                //keep adjusting until we reach boundary
                while(shiftLeft >= 0 && nums[shiftLeft] == target) {
                    shiftLeft--;
                }
                shiftLeft++;
                //do same thing but for right portion
                while(shiftRight < nums.size() && nums[shiftRight] == target) {
                    shiftRight++;
                }
                shiftRight--;
                //return our result
                return {shiftLeft,shiftRight};
                
            } else if(nums[mid] < target) {
                //search right half
                left = mid + 1;
            } else {
                //search left half
                right = mid - 1;
            }
        }
        return {-1,-1};
    }
};
