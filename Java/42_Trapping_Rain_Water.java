class Solution {
    public int trap(int[] height) {
        //keep track of how much water we have so far
        int water = 0;
        //use arrays to track how much water is the max from the left and right
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];
        //set starting values
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length  - 1];
        //compute left max
        for(int i = 1; i < height.length;i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1],height[i]);
        }
        //compute right max
        for(int i = height.length - 2; i >= 0;i--) {
            maxRight[i] = Math.max(maxRight[i + 1],height[i]);
        }
        //go through height and compute the water for each index
        for(int i = 0; i < height.length;i++) {
            water += Math.max(0,Math.min(maxLeft[i],maxRight[i]) - height[i]);
        }
        return water;

    }
}
