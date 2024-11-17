class Solution {
    public int maxSubArray(int[] arr) {
        //set starting values
        int sol = arr[0];
        int maxEndingAtI = arr[0];

        for(int i = 1; i < arr.length;i++) {
            //the maxendingat is either the index itself
            //or the past maxending + the index itself
            maxEndingAtI = Math.max(arr[i], maxEndingAtI + arr[i]);
            //update solution
            sol = Math.max(sol, maxEndingAtI);
        }
        //return solution
        return sol;
    }
    
    
}
