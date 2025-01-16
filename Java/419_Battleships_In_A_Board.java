class Solution {
    //stores if we visited node or not
    boolean [][] visited;
    //stores possible directions we can change during dfs
    int [][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int countBattleships(char[][] board) {
        int battleships = 0;
        visited = new boolean[board.length][board[0].length];
        //go through every node in board and if it is NOT visited
        //and it is an X we found a new battleship

        //at that point we want to dfs through to mark the rest of the
        //battle ship
        for(int i =0 ; i < board.length;i++) {
            for(int j = 0; j < board[0].length;j++) {
                if(!visited[i][j] && board[i][j] == 'X') {
                    battleships++;
                    dfs(board,i,j);
                }
            }
        }
        return battleships;
    }
    public void dfs(char [][]board, int i, int j) {
        //mark visited node as true
        visited[i][j] = true;
        //if no hit we exit here
        if(board[i][j] == '.') {
            return;
        } 

        //go through all directions and continue search
        for(int k = 0; k < 4;k++) {
            int newI = dir[k][0] + i;
            int newJ = dir[k][1] + j;
            //make sure its a valid index and we havent visited it before
            if(newI >= 0 && newJ >= 0
            && newI < board.length && newJ < board[0].length
            && !visited[newI][newJ]
            ) {
                dfs(board,newI, newJ);
            }
        }
        
    }
}
