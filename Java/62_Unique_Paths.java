class Solution {
    //global variable to store past results
    int mem[][];
    public int uniquePaths(int m, int n) {
        //create matrix
        mem = new int[m][n];
        //fill it with a filler variable
        for(int i= 0; i < m;i++) {
            Arrays.fill(mem[i], - 1);
        }
        //final spot in matrix we need to get to should be 1
        mem[m - 1][n - 1] = 1;
        //run recursive helper
        return memoize(0,0,m,n);
    }
    public int memoize(int i, int j, int m, int n) {
        //if we have an invalid index we exit
        if( i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        //if we already computed these indices then we return past result
        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        //otherwise we calculate both going right and going down
        int right = memoize(i, j + 1,m,n);
        int down = memoize(i + 1,j ,m,n);
        //store it in our matrix
        mem[i][j] = right + down;
        //and return it :)
        return mem[i][j];
    }
    
    
}
