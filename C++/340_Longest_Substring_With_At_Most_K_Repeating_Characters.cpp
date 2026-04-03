/*
Time Complexity: O(n)
Space Complexity: O(1), as our map can only be as large as our character set
*/
class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        //trivial cases we can solve in O(1)
        if(k == 0) {
            return 0;
        } else if(k >= s.size()) {
            return s.size();
        }

        int dist_count = 0;
        int l = 0;
        int max_len = 0;
        std::unordered_map<char, int> map;
        for(int r = 0; r < s.size();r++) {
            //increment distinct if we find a new letter
            if(!map.contains(s[r])) {
                dist_count++;
            }
            map[s[r]]++;
            //if we went to high close the window until we reach back under the limit
            while(l < r && dist_count > k) {
                if(map[s[l]] == 1) {
                    dist_count--;
                    map.erase(s[l]);
                } else {
                    map[s[l]]--;
                }
                l++;
            }
            //update max_len if we found a new high
            max_len = std::max(max_len, r - l + 1);
        }
        return max_len;
    }
};
