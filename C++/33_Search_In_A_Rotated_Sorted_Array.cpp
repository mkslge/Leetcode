class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(nums[m] == target) {
                return m;
            } else
            //otherwise left side is sorted
            // 2 cases, either in here or not
            // if not in range of l and mid
            // go right
            // stay left
            if(nums[l] <= nums[m]) {
                if(nums[l] <= target && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }  else { //right is sorted
                //2 cases, either its in this range or not
                //if it is search here otherwise go left
                if(nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
};
