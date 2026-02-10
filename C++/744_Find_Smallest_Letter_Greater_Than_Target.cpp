class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        char ans = letters[0];
        int l = 0;
        int r = letters.size() - 1;
        while(l <= r) {
            int m = (r + l) / 2;
            if(letters[m] > target) {
                ans = letters[m];
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
};
