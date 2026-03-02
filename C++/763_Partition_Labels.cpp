class Solution {
public:
    vector<int> partitionLabels(string s) {
        int end[26];
        for(int i = 0; i < s.size();i++) {
            end[s[i] - 'a'] = i;
        }
        vector<int> sol;
        int idx = 0;
        while(idx < s.size()) {
            int maxEnd = end[s[idx] - 'a'];
            for(int i = idx; i <= maxEnd;i++) {
                maxEnd = max(maxEnd, end[s[i] - 'a']);
            }
            sol.push_back(maxEnd - idx + 1);
            idx = maxEnd + 1;
        }
        return sol;
    }
};
