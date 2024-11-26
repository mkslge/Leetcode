class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int length = matrix[0].length;
        //get left and right
        int left = 0;
        int right = (rows * length) - 1;
        //regular binary search
        while(left <= right) {
            int index = left + (right - left) / 2; //5
            //convert index to rows and columns
            int row = index / length;
            int col = index % length;
            //continue regular binary serach
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        //return if went through whole loop
        return false;
    }
}
