class Solution {
 
    public String longestPalindrome(String s) {
        //stores solution
        String sol = "";
        int length = 0;
        //go through every character
        for(int i = 0; i < s.length();i++) {
            //set two pointers
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                //check substring
                String curr = s.substring(l,r+1);
                if(r - l + 1 > length) {
                    sol = s.substring(l,r + 1);
                    length = r - l + 1;
                } 
                 r++;
                 l--;
                
            }
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ) {
                
                if(r - l + 1 > length) {
                    sol = s.substring(l,r+1);
                    length = r - l + 1;
                } 
                 r++;
                 l--;
                
            }
        }
        
        return sol;
    }

    
}
