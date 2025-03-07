class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            //if we have a star remove last character
            if(c == '*') {
                stack.pop();
            } else {
                //otherwise add to stack
                stack.push(c);
            }
        }
        //convert stack back to string using stringbuilder
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
