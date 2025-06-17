class Solution {
    boolean [][] checkedA;
    boolean [][] checkedP;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        checkedA = new boolean[heights.length][heights[0].length];
        checkedP = new boolean[heights.length][heights[0].length];
        //starting at the bottom and top row 
        for(int i = 0; i < heights.length;i++) {
            dfs(heights, i, 0, "a");
            dfs(heights, i, heights[0].length - 1, "p");
        }
        //starting at first and last column
        for(int i = 0; i < heights[0].length;i++) {
            dfs(heights, 0, i, "a");
            dfs(heights, heights.length - 1, i, "p");
        }
        //go through each cell and check if we can reach both 
        //of the atlantic and pacific
        List<List<Integer>> sol = new ArrayList<>();
        for(int i = 0; i < heights.length;i++) {
            for(int j = 0; j < heights[0].length;j++) {
                //if we can add it to our list
                if(checkedA[i][j] && checkedP[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    sol.add(temp);
                }
            }
        }
        return sol;
    }

    int [][] dir = new int[][]{{1,0},{0,1},{-1,0}, {0, -1}};

    //go backwards checking what cells would be able to reach
    //our current cell
    public void dfs(int [][]grid, int i, int j, String start) {
        //we we checked we exit otherwise we add it tor reachable
        if(start.equals("a")) {
            if(checkedA[i][j]) {
                return;
            } else {
                checkedA[i][j] = true;
            }
        } else if(start.equals("p")) {
            if(checkedP[i][j]) {
                return;
            } else {
                checkedP[i][j] = true;
            }
        }
        //go through 4 possible traversals here
        for(int k = 0; k < 4;k++) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];

            if(newI >= 0 && newJ >= 0
            && newI < grid.length && newJ < grid[0].length
            && grid[i][j] <= grid[newI][newJ]) {
                dfs(grid, newI, newJ, start);
            }
        }
    }
}
