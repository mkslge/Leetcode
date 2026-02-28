class Solution {
public:
    static const int MOD = 1'000'000'007;
    int concatenatedBinary(int n) {
        return helper(n, 1, 0, 0);
    }

    int helper(int goal, int curr, long long currVal, int numBits) {
        if(curr > goal) {
            return currVal;
        }
        if((curr & (curr - 1)) == 0) {
            numBits++;
        }
        int newVal = ((currVal << numBits) % MOD + curr) % MOD;
        return helper(goal, curr + 1, newVal, numBits);
    }
};
