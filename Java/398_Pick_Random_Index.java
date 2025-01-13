class Solution {
    HashMap<Integer, ArrayList<Integer>> valueToIndices;
    Random random;
    public Solution(int[] nums) {
        //initalize random and map
        valueToIndices = new HashMap<>();
        random = new Random();
        //map every value in array to the indices that they are the array
        for(int i = 0; i < nums.length;i++) {
            //if it doesnt exist yet create the list
            if(!valueToIndices.containsKey(nums[i])) {
                valueToIndices.put(nums[i],new ArrayList<>());
            } 
            //add it to the list
            valueToIndices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        //get random index from map
        return valueToIndices.get(target).get(random.nextInt(valueToIndices.get(target).size()));
    }
}
