class Solution {
    public int lengthOfLongestSubstring(String s) {
        //left and right store window values
        int l = 0, r = 0, sol = 0;
        int length = s.length();
        //set stores values weve seen
        HashSet<Character> set = new HashSet<>();
        while(r < length) {
            //if set does contain char then we expand window
            //and remove start of window
            if(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            } else {
                //otherwise we add to set
                set.add(s.charAt(r));
                //check if we have our new longest substring
                sol = Math.max(sol, r - l + 1);
                //and keep going
                r++;
            }
        }
        //return highest value we got
        return sol;
    }
}
