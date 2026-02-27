class Solution {
public:
    int hammingWeight(int n) {
        return n != 0 ? (n & 1) + (hammingWeight(n >> 1)) : 0;
    }
};
