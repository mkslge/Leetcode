class Solution {
    //memoization
    HashMap<Integer,Integer> storing = new HashMap<>();
    
    
    public int climbStairs(int n) {
        //check basecase
        if(n <= 0) {
            storing.put(n,0);
            return 1;
        } else if(n == 1) {
            //check 2nd base case
            storing.put(n,1);
            return 1;
        } else if(storing.containsKey(n)) {
            //return if already stored
            return storing.get(n);
        } 
            //calculate new result
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            //store and return
            storing.put(n,result);
            return result;   
    }
}
