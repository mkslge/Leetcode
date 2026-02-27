class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0;
        int r = nums.size() - 1;
        int sol = std::numeric_limits<int>::max();
        while(l <= r) {
            int m = (l + r ) / 2;
            //case 0, sublist sorted, we know l will be minimum
            if(nums[l] <= nums[r]) {
                return nums[l];
            } else if(nums[m] < nums[r]){
                //case 1, right side is sorted (m could be minimum)
                sol = min(sol, nums[m]);
                r = m;
            } else {
                //case 2, left side is sorted (m CANT be the minimum)
                sol = min(sol, nums[l]);
                l = m + 1;
            }
        
        }
        return sol;
    }
};
