class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //hashamp stores prefix sum of odd values and their frequency
        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();
        //empty subarray implictly has 0 odd numbers
        prefixFrequency.put(0,1);
        int niceCount = 0;
        int oddCount = 0;

        //go through list 
        for(int i = 0; i < nums.length;i++) {
            //check if number is odd
            if(nums[i] % 2 == 1) {
                oddCount++;
            }
            //we want to find the reciprical of current odd count
            int target = oddCount - k;
            //if it exists there are *frequency* amount of possible 
            //subarrays
            if(prefixFrequency.containsKey(target)) {
                niceCount += prefixFrequency.get(target);
            }
            //add to our map
            prefixFrequency.put(oddCount, prefixFrequency.getOrDefault
            (oddCount, 0) + 1);
        }

        
        return niceCount;
    }
}
