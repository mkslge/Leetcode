class Solution {
    
    public int numSquares(int n) {
        //if n is. aperfect square we can achieve O(1) time complexity
        if(Math.sqrt(n) == (int) Math.sqrt(n)) {
            return 1;
        }
        int [] mem = new int[n + 1];
        //set basecase for clearness
        mem[0] = 0;
        
        for(int i = 1; i <= n;i++) {
            //go each i up to n the solution will be the minimum of the 
            //last answers + 1, each being i - square since those are the
            //last values

            int currSol = Integer.MAX_VALUE / 2;
            for(int square : squares) {
                //if i - square is negative we can exit since we know
                //the numbers have gotten too big
                if(i - square < 0) {
                    break;
                }
                //check if we found a new minimum
                currSol = Math.min(currSol, mem[i - square] + 1);
            }
            //update minimum
            mem[i] = currSol;
        }

        //return solution
        return mem[n];
    }
    //array that stores perfect squares
    int[] squares = {
            1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 
            121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 
            441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 
            961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 
            1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500, 
            2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 
            3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 
            5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 
            6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 
            8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801, 10000
        };
}
