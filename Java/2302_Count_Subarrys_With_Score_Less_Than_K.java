class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int left = 0, right = 0;
        
        while(right < nums.length) {
            //add right side to sum
            sum += nums[right];
            //calculate window's current score 

            int length = right - left + 1;
            long score = sum * length;
            //while the score is too high close the window
            while(left <= right && score >= k) {
                sum -= nums[left];
                left++;
                length--;
                score = sum * length;
            }
            //add the length of the window to the count
            count += length;
            //increase window
            right++;
        }
        
        return count;
    }
}
