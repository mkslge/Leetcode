class Solution {
    public String reverseWords(String s) {
        //split string with regexd expression for one or multiple spaces
        String [] words = s.trim().split("\\s+");
        StringBuilder sol = new StringBuilder();
        //add string to string builder in reverse order
        for(int i = words.length - 1;i >= 0;i--) {
            sol.append(words[i]);
            //if it is not last word add 1 space
            if(i != 0) {
                sol.append(" ");
            }
        }
        //return string version
        return sol.toString();
    }
}
