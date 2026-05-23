class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int l = 0;
        int r = 0;
        int maxSum = 0;
        int currSum = 0;
        std::unordered_set<int> set;
        while(r < nums.size()) {
            if(!set.contains(nums[r])) {
                set.insert(nums[r]);
                currSum += nums[r];
                maxSum = std::max(maxSum, currSum);
                r++;
            } else {
                set.erase(nums[l]);
                currSum -= nums[l];
                l++;
            }
        }

        return maxSum;
    }
};
