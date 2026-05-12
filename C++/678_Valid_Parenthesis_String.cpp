class Solution {
public:
    bool checkValidString(string s) {
        int min = 0;
        int max = 0;
        for(const char c : s) {
            if(c == '*') {
                min--;
                max++;
            } else if(c== '(') {
                max++;
                min++;
            } else { //must be ')'
                min--;
                max--;
            }
            min = std::max(0, min);
            if(max < 0) {
                return false;
            }

        }
        return !min;
    }
};
