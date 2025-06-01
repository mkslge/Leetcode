class Solution {
    //make this a global variable so we dont have to pass it in everytime
    int [] chars;
    public boolean checkInclusion(String s1, String s2) {
        chars = new int[26];
        for(int i = 0 ; i < s1.length();i++) {
            chars[s1.charAt(i) - 'a']++;
        }


        int l = 0;
        int [] perm = new int[26];
        for(int r = 0; r < s2.length();r++) {
            perm[s2.charAt(r) - 'a']++;
            //if we have to many
            if(chars[s2.charAt(r) - 'a'] < perm[s2.charAt(r) - 'a']) {
                //lets close the window until we dont have to many
                while(chars[s2.charAt(r) -'a']<perm[s2.charAt(r) - 'a']) {
                    perm[s2.charAt(l++) - 'a']--;
                }
                
            } else {
                //if we have the exact amount
                if(chars[s2.charAt(r) - 'a'] == perm[s2.charAt(r) - 'a']) {
                    //lets check if we have an exact permuation
                    if(isPerm(perm)) {
                        return true;
                    }
                }
            }
        }
        //if we got to the end of the string we dont have a permutation
        return false;
    }

    //O(1) function that checks if the string is a permutation
    public boolean isPerm(int [] contender) {
        for(int i = 0; i < 26;i++) {
            if(contender[i] != chars[i]) {
                return false;
            }
        }
        return true;
    }

}
