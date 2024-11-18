class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int []> sol = new ArrayList<>();
        //reverse sort array
        Arrays.sort(intervals , (arr1 , arr2) -> arr1[0]-arr2[0]);

        for(int i = 0; i < intervals.length;i++) {
            int [] curr = intervals[i];
            //if i is the first add it to array
            if(i == 0) {
                sol.add(curr);
                //if we have a new interval then we add it
            } else if(curr[0] <= sol.get(sol.size() - 1)[1]) {
                int s = sol.size() - 1;
                sol.get(s)[0] = Math.min(curr[0],sol.get(s)[0]);
                sol.get(s)[1] = Math.max(curr[1],sol.get(s)[1]);
            } else {
                //otherwise we continue
                sol.add(curr);
            }
            
        }
        //transofrm into array
        return sol.toArray(new int[sol.size()][2]);
    }

    
}
