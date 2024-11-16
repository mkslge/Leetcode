class Solution {
    //use memoization to store past solutions
    int [] mem; 
    public int tribonacci(int n) {
        //handle base cases
        if(n == 0) {
            return 0;
        } else if(n == 1 || n == 2){
            return 1;
        } 
        //make array and store base cases
        mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        //return auxillary function 
        return aux(n);
    }
    public int aux(int curr) {
        //check if we reached base case
        if(curr <= 2) {
            return mem[curr];
        } else if(mem[curr] != 0) {
            //if we already have the solution stored just return it
            return mem[curr];
        }
        //otherwise store solution in recursive calls
        mem[curr] = aux(curr - 1) + aux(curr - 2) + aux(curr - 3);
        //return solution that we stored
        return mem[curr];
    }
}
