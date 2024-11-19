class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> sol;
        //store number as key and index as value
        unordered_map<int, int> map;
        for(int i = 0; i < nums.size();i++) {
            //if reciprical is found that means we found the pair
            if(map.contains(target - nums[i])) {
                sol.push_back(i);
                sol.push_back(map[target - nums[i]]);
                return sol;
            } else {
                //if not we can add it to the hashmap and keep checking
                map[nums[i]] = i;
            }
        }
        //should never reach this
        return sol;
    }
};
