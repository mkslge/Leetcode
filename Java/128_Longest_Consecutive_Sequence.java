class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> values = new HashSet<>();

        for(int num : nums) {
            //put all values in a set
            values.add(num);
        }

        int max = 0;
        for(int num : values) {
            //only check if we are at the start of a sequence (nothing before it)
            if(!values.contains(num - 1)) {
                int length = 0;
                //then go through and check for how long an ascending value exists
                while(values.contains(num + length)) {
                    length++;
                }
                //see if we got a new maximum
                max = Math.max(length, max);
            }
        }
        return max;
    }
}
