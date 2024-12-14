class Solution {
    
    public int[] countBits(int n) {
        //if 0 return an empty array
        if(n == 0) {
            return new int[]{0};
        }
        /*otherwise we go through all numbers up to n and calulcate 
        number of bits*/

        //array to store past reults (sol[0] implictly set to 0)
        int [] sol = new int[n + 1];


        for(int i = 0; i < sol.length;i++) {
            /*for each array we calculate the number of bits by first
            calculating the current bit by taking the remainder
            and also get the prior number of bits from past results
            */
            sol[i] = i % 2 + sol[i/2];
            
        }

        return sol;
    }

    
}
