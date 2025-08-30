class Solution {
    public void sortColors(int[] nums) {
        int [] values = new int[3];
        //count up frequency of each value
        for(int num : nums) {
            values[num]++;
        }
        int j = 0;
        for(int i = 0; i < nums.length;i++) {
            //if there are none left move to next color
            while(values[j] == 0) {
                j++;
            }
            //mark index as color and then adjust frequency
            nums[i] = j;
            values[j]--;
        }
    }
}
