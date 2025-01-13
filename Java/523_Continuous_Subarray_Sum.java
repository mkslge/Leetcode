class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //store prefix sum, and index (-1 is implictly empty sum)
        map.put(0,-1);
        int sum = 0;

        for(int i = 0; i < nums.length;i++) {
            //add to sum
            sum += nums[i];
            //get remainder from sum
            int rem = sum % k;
            //check if we have the reciprocal and it is longer than 1
            if(map.containsKey(rem) ) {
                if(i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                //otherwise add it to our prefix sum list
                map.put(rem,i);
            }
        }
        return false;
    }
}
