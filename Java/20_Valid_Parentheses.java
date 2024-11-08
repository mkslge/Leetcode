class Solution {
    public boolean isValid(String s) {
        //if odd or empty we can instantly return false
        if(s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        //otherwise use map that maps start parenthesis with ending parentheses
        HashMap<Character,Character> inOut = new HashMap<>();
        inOut.put('{','}');
        inOut.put('(',')');
        inOut.put('[',']');
        //push first parenthesis onto stack
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        //check each character in string
        while(i < s.length()) {
            //if it is a starting parenthesis push it onto stack and keep going
            if(inOut.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                //otherwise we are expecting ending parentheses
                if(stack.isEmpty()) {
                    return false;
                }
                //put and make sure the starting and ending parentheses match
                char curr = stack.pop();
                if(!inOut.containsKey(curr) || inOut.get(curr) != s.charAt(i)) {
                    return false;
                }

            }
            i++;
        }
        //make sure there are no left overs
        return stack.isEmpty();
    }
}
