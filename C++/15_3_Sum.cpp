class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        std::set<std::tuple<int, int, int>> set;
        for(int i = 0; i < nums.size() - 2;i++) {
            int l = i + 1;
            int r = nums.size() - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0) {
                    set.insert({nums[i], nums[l], nums[r]});
                    
                    l++;
                } else if(sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        std::vector<std::vector<int>> sums;
        for (auto [a, b, c] : set) {
            sums.push_back({a,b,c});
        }
        return sums;
    }
};
