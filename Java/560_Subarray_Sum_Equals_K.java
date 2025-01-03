class Solution {
    public int subarraySum(int[] nums, int k) {
        //hashmap stores prefix and the amount of times weve seen it so far
       HashMap<Integer,Integer> prefixAndCount = new HashMap<>();
       //implictly add empty sum s
       prefixAndCount.put(0,1);
       
       int count = 0;
       int prefix = 0;
       
       for(int i = 0; i < nums.length;i++) {
            //update prefix
            prefix += nums[i];

            int prefixReciprical = prefix - k;
            //check if we've seen reciprical that adds up to k 
            if(prefixAndCount.containsKey(prefixReciprical)) {
                //if so we add the amount of times we've seen it to k
                count += prefixAndCount.get(prefixReciprical);
            }
            //update map with prefix amount
            prefixAndCount.put(prefix, prefixAndCount.getOrDefault(prefix,0) + 1);
       }

       
       return count;
    }
    
}
