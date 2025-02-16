class Solution {
    int [][] mem;
    boolean [][] visited;
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //initalize storage for past results
        mem = new int[row][col];
        visited  = new boolean[row][col];
        //set up base case
        mem[0][0] = grid[0][0];
        visited[0][0] = true;
        //call depth first function
        return dfs(grid, row - 1, col - 1);
    }
    public int dfs(int [][] grid, int i, int j) {
        //if its out of bounds ignore it
        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE / 2;
        } else if(visited[i][j]) {
            //if we've already visited it return the past solution
            return mem[i][j];
        }
        //get the minimum cost that is possible
        mem[i][j] = grid[i][j] + 
        Math.min(dfs(grid,i - 1, j),dfs(grid,i,j-1));
        //mark it as seen and return the result stored
        visited[i][j] = true;
        return mem[i][j];
    }
}
