class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //compare the outermost elements until we have reached a window with size k
        //since our list is sorted we know the outermost list will be the two 
        //farthest integers from x 
        ArrayList<Integer> sol = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while(right - left + 1 > k) {
            int a = arr[left];
            int b = arr[right];
            //if a is farther away then we remove the left side
            if(Math.abs(a - x) > Math.abs(b - x)) {
                left++;
            } else {
                //if b is farther away we remove the right side
                right--;
            }
        }
        //slice the array and return it 
        for(int i = left; i <= right;i++) {
            sol.add(arr[i]);
        }
        return sol;
    }
}
