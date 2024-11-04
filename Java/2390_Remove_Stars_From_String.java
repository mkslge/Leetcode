class Solution {
    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();
        
        //iterate throughs string
        for(int i = 0; i < s.length();i++) {
            //if character is star, remove last element in stack
            if(s.charAt(i) == '*') {
                stack.pop();
            } else {
                //otherwise add character to stack
                stack.push(s.charAt(i));
            }
        }
        //convert stack to stringbuilder
        StringBuilder sol = new StringBuilder();
        while(!stack.isEmpty()) {

            sol.append(stack.pop());
        }
        //reverse string builder and convert it to string
        return sol.reverse().toString();
    }
}
