class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, sol = 0;
        for(int right = 0; right < nums.length;right++) {
            //if we find a zero we knock off k
            k -= nums[right] == 0 ? 1 : 0;
            //if we have dropped below 0 we need to knock off the left
            //until got a k back
            while(k == -1) {
                k += nums[left++] == 0 ? 1 : 0;
            }
            //check if we reached a new maximum
            sol = Math.max(sol, right - left + 1);
        }
        return sol;
    }
}
