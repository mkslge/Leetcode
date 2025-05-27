class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //use two pointer approach
        int left = 0, right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            } else if(sum > target) {
                //if sum is too large we decrease the right pointer
                right--;
            } else {
                //if some is too small we increase the left pointer
                left++;
            }
        }
        return null;
    }
}
