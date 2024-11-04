class Solution {
    //array to iterate through possible next steps
    int [][]dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    //matrix to see if node has been visited
    boolean [][]visited;

    public int nearestExit(char[][] maze, int[] entrance) {
        //initalize arrays
        visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        //call bfs on entrance
        return bfs(maze,entrance[0],entrance[1],entrance);
    }

    public int bfs(char [][]maze, int i, int j, int [] ent) {

        //begin bfs with queue on start
        Queue<int []> q = new LinkedList<>();

        q.add(new int[]{i,j,0});

        while(!q.isEmpty()) {
            //remove from queue 
            int [] curr = q.remove();
            //check all neighbors
            for(int k = 0; k < 4;k++) {
                //get new i and j values
                int newI = curr[0] + dir[k][0];
                int newJ = curr[1] + dir[k][1];
                //check that they are indeed valid
                if(newI >= 0 && newJ >=0
                && newI < maze.length
                && newJ < maze[0].length
                && !visited[newI][newJ] 
                && maze[newI][newJ] == '.') {
                    //check if it is exit 
                    if(newI == 0 || newJ == 0 
                    || newI == maze.length -1  
                    || maze[0].length -1 == newJ
                    ) {
                        //return result
                        return curr[2] + 1;
                    }
                    //otherwise add to queue
                    q.add(new int[]{newI,newJ,curr[2] + 1});
                    visited[newI][newJ] = true;
                }
            }

        }
        //return -1 if no exit found
        return -1;
    }
}
