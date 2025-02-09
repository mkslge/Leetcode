class Solution {
    public long countBadPairs(int[] nums) {
        long l = nums.length;
        //there are L choose 2 total pairs in the nums array
        long total = (l) * (l-1) / 2;
        //so we count up the frequency of each occurence of nums[i] - i 
        long goodPairs = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0 ; i < nums.length;i++) {
            //add our current amount to the number of good pairs
            goodPairs += map.getOrDefault(nums[i] - i, 0L);
            //update our map
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0L) + 1L);
       }
       //get the compliment of the good pairs for the solution
    return total - goodPairs;
    }
}
