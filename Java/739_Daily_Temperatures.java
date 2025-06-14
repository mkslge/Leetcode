class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int [] sol = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length;i++) {
            //check if our current array is bigger than our most recent
            //temperatures
            while(!stack.isEmpty() && 
            temperatures[stack.peek()] < temperatures[i]) {
                //if it is we store the difference in days between the 
                //higher temp and the lower temperature
                int idx = stack.pop();
                sol[idx] = i - idx;
            }
            //add the new temperature after we got through all of the 
            //lower temperatures
            stack.push(i);
        }
        return sol;
    }
}
