class Solution {
    public int maxArea(int[] height) {
        //save left and right pointer
        int right = height.length - 1;
        int left = 0;
        //save max height
        int maxHeight = 0;
        //go through loop while there is window
        while(left < right) {
            //check curr weight
            int currHeight = Math.min(height[left],height[right]) * (right - left);
            //update max height
            maxHeight = Math.max(currHeight, maxHeight);
            //update window based on what is bigger
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        //return solution
        return maxHeight;
    }
}
