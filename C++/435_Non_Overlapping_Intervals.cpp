class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        std::sort(intervals.begin(), intervals.end(),
        [](vector<int>& a, vector<int>& b) {
            if(a[0] != b[0]) {
                return a[0] < b[0];
            } 
            return a[1] < b[1];
        });


        int erased = 0;
        vector<int> curr_int = intervals[0];
        for(auto i = 1; i < intervals.size();i++) {
            if(curr_int[1] > intervals[i][0]) {
                erased++;
                if(curr_int[1] > intervals[i][1]) {
                    curr_int = intervals[i];
                }
            } else {
                curr_int = intervals[i];
            }
        }
        return erased;
    }
};
