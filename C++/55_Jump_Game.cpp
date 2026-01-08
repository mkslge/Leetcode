class Solution {
public:
    bool canJump(vector<int>& nums) {
        int jumps_left = 0;
        for(int i = 0; i < nums.size();i++) {
            if(jumps_left < 0) {
                return false;
            } 
            /* The key idea here is that there are TWO cases:
            if we have more jumps then the current index, we just keep using those, but
            if we can gain more, we should just do that by starting from the current idx
            */ 
            jumps_left = max(jumps_left, nums[i]);
            jumps_left--;
        }
        return true;
    }
};
