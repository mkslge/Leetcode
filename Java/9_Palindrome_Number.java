class Solution {
    public boolean isPalindrome(int x) {
        //convert to string
        String num = Integer.toString(x);
        int left = 0, right = num.length() - 1;
        while(left < right) {
            //check if end matches beginning and move references
            if(num.charAt(left++) != num.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
