class Solution {
public:
    int fib(int n) {
        if(n <= 1) {
            return n;
        }
        int nMinusTwo = 0;
        int nMinusOne = 1;
        for(int i = 2; i <= n;i++) {
            int fibAtI = nMinusTwo + nMinusOne;
            nMinusTwo = nMinusOne;
            nMinusOne = fibAtI;
        }
        return nMinusOne;
    }
};
