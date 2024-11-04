class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //store number number in key and number of occurences
        //in value in hashmap
        Map<Integer,Integer> map = new HashMap<>();

        //iterate through array and update hashamp
        for(int curr : arr) {
            map.put(curr, map.getOrDefault(curr,0) + 1);
        }
        //create new hashset checking if there
        //is any duplicates in the amount of occurences
        HashSet<Integer> amounts = new HashSet<>();
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            //if there is return false
            if(amounts.contains(entry.getValue())) {
                return false;
            } else {
                amounts.add(entry.getValue());
            }
        }
        //if we made it through that means there were no duplicates
        //in the number of occurences
        return true;

    }
}
