class Solution {
public:
    vector<vector<int>> sol;
    vector<vector<int>> subsets(vector<int>& nums) {
        helper(nums, vector<int>{}, 0);
        return sol;
    }

    void helper(vector<int>&nums, vector<int> curr, int idx) {
        if(idx >= nums.size()) {
            sol.push_back(curr);
            return;
        }
        helper(nums, curr, idx + 1);
        curr.push_back(nums[idx]);
        helper(nums, curr, idx + 1);
    }
};
