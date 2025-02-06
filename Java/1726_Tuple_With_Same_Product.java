class Solution {
    public int tupleSameProduct(int[] nums) {
        int sol = 0;
        HashMap<Integer, Integer> set = new HashMap<>();
        //grab all possible permuations of pairs
        for(int i = 0; i < nums.length;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                int val = nums[i] * nums[j];
                set.put(val, set.getOrDefault(val, 0) + 1);
            }
           
        }

        //we go through all values that we got
        for(Map.Entry<Integer, Integer> entry : set.entrySet()) {
            //if theres more than 2 we can pair them up
            int perms = entry.getValue();
            //we pair them up 8 * (N choose 2) times
            if(perms >= 2) {
                
                sol += 8 * (perms * (perms-1) / 2);
            }
        }
        return sol;
    }
}
