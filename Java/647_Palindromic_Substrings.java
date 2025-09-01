class Solution {
    String str = "";
    public int countSubstrings(String s) {
        str = s;
        int sol = 0;
        for(int i = 0 ; i < str.length();i++) {
            sol += getSubstrings(i, i);
            sol += getSubstrings(i, i + 1);
        }
        return sol;
    }

    private int getSubstrings(int l, int r) {
        int sol = 0;
        while(l >= 0 && r < str.length()) {
            if(str.charAt(l) == str.charAt(r)) {
                sol++;
                l--;
                r++;
            } else {
                break;
            }
        }
        return sol;
    }
}
