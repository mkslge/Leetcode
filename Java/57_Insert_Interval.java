class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> sol = new ArrayList<>();
        //flag to see if weve added
        boolean added = false;

        for(int i = 0; i < intervals.length;i++) {
            //if it fits we add it 
            if(newInterval[1] < intervals[i][0]) {
                sol.add(newInterval);
                added = true;
                for(int j = i; j < intervals.length;j++) {
                    sol.add(intervals[j]);
                }
                i = intervals.length;
                //otherwise if its minimum we add new interval
            } else if(newInterval[0] > intervals[i][1]) {
                sol.add(intervals[i]);
            } else {
                //otherwise we update and make a new interval
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        //if not added yet we add the last interval to the end
        if(!added) {
            sol.add(newInterval);
        }
        //return array version of updated array
        return sol.toArray(new int[sol.size()][2]);
    }
}
