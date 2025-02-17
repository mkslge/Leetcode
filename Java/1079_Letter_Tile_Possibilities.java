class Solution {
    public int numTilePossibilities(String tiles) {
        //build hashmap/array
        int [] charCount = new int[26];
        for(char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }
        //recursively call dfs
        return buildChar(charCount);
    }

    public int buildChar(int [] charCount) {
        int sol = 0;
        for(int i = 0 ; i < 26;i++) {
            //if there exists any of the letter 
            if(charCount[i] > 0) {
                //we found a new comb
                sol++;
                //backtrack
                charCount[i]--;
                sol += buildChar(charCount);
                //add back
                charCount[i]++;
            }
        }
        return sol;
    }


    
    
}
