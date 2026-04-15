class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> new_intervals;
        vector<int> to_insert = newInterval;
        
        bool added = false;

        for(auto& curr : intervals) {
            if(!added && newInterval[1] < curr[0]) {
                new_intervals.push_back(newInterval);
                added = true;
            }

            if(!added && curr[1] < newInterval[0]) {
                new_intervals.push_back(curr);
            } else if(!added) {

                newInterval[0] = std::min(newInterval[0], curr[0]);
                newInterval[1] = std::max(newInterval[1], curr[1]);
            }

            if(added) {
                new_intervals.push_back(curr);
            }
        }

        if(!added) {
            new_intervals.push_back(newInterval);
        }
        return new_intervals;
    }
};


/*
[1,2]

[1,2] [3,8]
[1,2] [3,8]
[1,2] [3,10]
[1,2] [3,10] [12,3]
*/
