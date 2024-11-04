class Solution {
    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();
        
        //iterate through string

        for(char curr : s.toCharArray()) {
            if(curr == '*') {
                //if character is star, remove last element in stack
                stack.pop();
            } else {
                //otherwise add character to stack
                stack.push(curr);
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
