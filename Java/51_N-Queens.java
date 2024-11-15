class Solution {
    //global variable to track sol throughout functions
    List<List<String>> sol = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean [][] board = new boolean[n][n];
        dfs(n,board,0);
        return sol;
    }
    //check if the board is invalid or not
    public boolean invalidBoard(boolean board[][], int x, int y) {
        int n = board.length;
        for(int i = 0; i < board.length;i++) {
            if(board[x][i]) {
                return false;
            }
            if(board[i][y]) {
                return false;
            }
        }
        int i = x;
        int j = y;
        //if there is any overlap return false
        while (i >= 0 && j < n) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        // Traverse downwards (towards bottom-right)
        i = x + 1;
        j = y - 1;
        while (i < n && j >= 0) {
            if(board[i][j]) {
                return false;
            }
            i++;
            j--;
        }

         i = x;
         j = y;
         
        while (i >= 0 && j >= 0) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        // Traverse downwards (towards bottom-right)
        i = x + 1;
        j = y + 1;
        while (i < n && j < n) {
            if(board[i][j]) {
                return false;
            }
            i++;
            j++;
        }

        //return true after checked all 4 directions
        return true;
        
    }
    public void dfs(int n, boolean [][]board, int i) {
        if( i >= n) {
            //create array list from board
            //add to sol
            List<String> option = new ArrayList<>();
            //return dfs through whole row
            for(int j = 0; j < n; j++) {
                String curr = "";
                for(int k = 0; k < n;k++) {
                    if(board[j][k]) {
                        curr += "Q";
                    } else {
                        curr += ".";
                    }
                }
                option.add(curr);
            }
            
            sol.add(option);
            return;
        }
        for(int j = 0; j < n;j++) {
            
            if(invalidBoard(board,i,j) ) {
                board[i][j] = true;
                dfs(n,board,i + 1);
                board[i][j] = false;
            } 
            
        }

    }
}
