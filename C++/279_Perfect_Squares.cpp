class Solution {
public:
    int numSquares(int n) {
        //if n is a perfect square we can return solution in O(1)
        if(sqrt(n) == int (sqrt(n))) {
            return 1;
        }
        //otherwise we create a vector and keep track of prior solution
        vector<int> mem(n + 1);
        mem[0] = 0;
        //we get our solution by checking what the minimum amount we can 
        //achieve by going through all past solutions of i - square and
        //adding 1 since that would be our new value
        for(int i = 1; i <= n;i++) {
            //set to really high placeholder (cannot go above this per 
            //constraints)
            int currBest = numeric_limits<int>::max() / 2;
            int square = 1;
            while(square <= i && i - square >= 0) {
                
                currBest = min(currBest, mem[i - square] + 1);

                //get next perfect square value
                square = sqrt(square);
                square++;
                square = square * square;
            }
            
            //save solution for further calculations or answer
            mem[i] = currBest;

        }
        
        return mem[n];
    }
};
