class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> countVals;
    int min = -1;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        countVals = new HashMap<>();
        countVals.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)) {
            return -1;
        }
        int val = vals.get(key);
        int count = counts.get(key);
        int newCount = count + 1;
        counts.put(key, newCount);
        countVals.get(count).remove(key);

        if(countVals.get(count).size() == 0 && min == count) {
            min = newCount;
        }

        if(!countVals.containsKey(newCount)) {
            countVals.put(newCount, new LinkedHashSet<>());
        }

        countVals.get(newCount).add(key);
        return val;


    }
    
    public void put(int key, int value) {
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if(capacity == vals.size()) {
            int toDel = countVals.get(min).iterator().next();
            countVals.get(min).remove(toDel);
            counts.remove(toDel);
            vals.remove(toDel);

            
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        countVals.get(1).add(key);


    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
