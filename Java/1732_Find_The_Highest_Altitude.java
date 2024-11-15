class Solution {
    public int largestAltitude(int[] gain) {
        int [] altitude = new int[gain.length + 1];
        int max = 0;
        //altitude is calculated by past altitude + gain
        //starting altitude is 0
        for(int i = 1; i <= gain.length;i++) {
            altitude[i] = altitude[i - 1] + gain[i - 1];
            //check if we have a new max
            max = Math.max(max, altitude[i]);
        }
        //return maximum altitude
        return max;
    }
}
