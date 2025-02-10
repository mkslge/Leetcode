class Solution {
    public String clearDigits(String s) {
        StringBuilder sol = new StringBuilder();

        for(char curr : s.toCharArray()) {
            //if we run into a digit we pop off the last letter
            if(Character.isDigit(curr)) {
                sol.deleteCharAt(sol.length() - 1);
            } else {
                //otherwise we simply append the letter
                sol.append(curr);
            }
        }
        
        return sol.toString();
    }
}
