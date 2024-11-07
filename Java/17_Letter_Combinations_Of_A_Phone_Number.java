class Solution {
    List<String> sol = new ArrayList<>();

    HashMap<Character,String> chars = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        //exit if digits is empty string
        if(digits.equals("")) {
            return sol;
        }
        //store all values in hashmap mapped to letters
        chars.put('2',"abc");
        chars.put('3',"def");
        chars.put('4',"ghi");
        chars.put('5',"jkl");
        chars.put('6',"mno");
        chars.put('7',"pqrs");
        chars.put('8',"tuv");
        chars.put('9',"wxyz");
        dfs(digits,0,"");
        return sol;
    }
    public void dfs(String digits,int i, String subset) {
        //check that we are not done yet
        if( subset.length() >= digits.length()) {
            //otherwise add and return
            sol.add(new String(subset));
            return;
        }
        //check all possible values
        String possible = chars.get(digits.charAt(i));
        int length = possible.length();
        //go through and add them to subset and recursively backtrack
        for(int j= 0; j < length;j++) {
            subset += possible.substring(j,j+1);
            dfs(digits,i + 1,subset);
            subset = subset.substring(0,subset.length() - 1);
        }
    }
}
