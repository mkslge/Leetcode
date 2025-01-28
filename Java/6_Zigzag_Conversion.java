class Solution {
    public String convert(String s, int numRows) {
        //if we only have 1 row we dont need to change anything
        if(numRows == 1) {
            return s;
        }
        //create new lists for each row
       ArrayList<Character> [] rows = new ArrayList[numRows];
       for(int i = 0; i < numRows;i++) {
            rows[i] = new ArrayList<>();
       }
       int currRow = 0;
       boolean goingDown = true;
       //go through characters
       for(Character curr : s.toCharArray()) {
            rows[currRow].add(curr);
            if(currRow == numRows - 1) {
                //if we reach the end switch directions
                goingDown = false;
            } else if(currRow == 0 && !goingDown) {
                //if we reach the end switch directions
                goingDown = true;
            }
            //index row depending on boolean
            currRow = goingDown ? currRow + 1 : currRow - 1;
       }
       //append string to a stringbuilder
       StringBuilder sol = new StringBuilder();
       for(int i = 0; i < numRows;i++) {
            for(int j = 0; j < rows[i].size();j++) {
                sol.append(rows[i].get(j));
            }
       }
       //return solution as string
       return sol.toString();
        
    }
}
