class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            //check if map contains recipricol
            if(map.containsKey(target - nums[i])) {
                //if it does return solution
                return new int[] {map.get(target-nums[i]),i};
            } else {
                //otherwise add to mao and keep looking
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
