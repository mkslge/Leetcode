class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        for(int i = 0; i < n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int [] time : times) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(time[1] - 1);
            pair.add(time[2]);
            adjList.get(time[0] - 1).add(pair);
        }

        int [] minDist = new int[n];
        for(int i = 0 ;i < n;i++) {
            minDist[i] = -1;
        }
        minDist[k - 1] = 0;

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.get(1) - b.get(1)
        );

        for(ArrayList<Integer> lst : adjList.get(k - 1)) {
            pq.add(lst);
        }

        HashSet<Integer> seen = new HashSet<>();
        seen.add(k - 1);
        int count = 1;
        while(count < n && !pq.isEmpty()) {
            ArrayList<Integer> minPair = pq.peek();
            pq.remove();
            if(seen.contains(minPair.get(0))) {
                continue;
            }
            minDist[minPair.get(0)] = minPair.get(1);
            seen.add(minPair.get(0));

            for(ArrayList<Integer> pair : adjList.get(minPair.get(0))) {
                if(!seen.contains(pair.get(0))) {
                    ArrayList<Integer> newPair = new ArrayList<>();
                    newPair.add(pair.get(0));
                    newPair.add(pair.get(1) + minPair.get(1));
                    pq.add(newPair);
                
                }
            }
            count++;
        }

        int maxValue = Integer.MIN_VALUE;
        for(int dist : minDist) {
            if(dist == -1) {
                return -1;
            }
            maxValue = Math.max(maxValue, dist);
        }
        return maxValue;


        
        

    }
}
