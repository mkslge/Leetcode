class Solution {
    //keeps track of visited provinces
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        visited = new boolean[l];
        int provinces = 0;
        //go through and do dfs on all provinces
        for(int i = 0; i < l;i++) {
                if(!visited[i]) {
                    //if it is not connected make a new province
                    //and run dfs to mark all connections
                    provinces++;
                    dfs(isConnected,i);
                }
                
            
        }
        return provinces;
    }
    public void dfs(int [][] isConnected, int x) {
        //if its already been visited stop
        if(visited[x]) {
            return;
        }
        //mark as visited
        visited[x] = true;
        //go through all adjacencies 
        for(int i = 0; i < isConnected.length;i++) {
            //if its connected keep going
            if(isConnected[x][i] == 1) {
                dfs(isConnected, i);
            }
        }

    }
}
