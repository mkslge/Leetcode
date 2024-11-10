class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        //go through every tile in board
        for(int i = 0; i < 9;i++) {
            for(int j = 0; j < 9; j++) {
                //check if there are any contradictions in the board
                if(board[i][j] != '.') {
                    
                    if(set.contains(board[i][j] + "r" + Integer.toString(i)) 
                    || set.contains(board[i][j] + "c" + Integer.toString(j)) 
                    || set.contains(board[i][j] + "b" + Integer.toString(i/3) 
                    + Integer.toString(j/3))) {
                        //return false i fthere are
                        return false;
                    } else {
                        //otherwise update set and keep going
                        set.add(board[i][j] + "r" + Integer.toString(i));
                        set.add(board[i][j] + "c" + Integer.toString(j));
                        set.add(board[i][j] + "b" + Integer.toString(i/3) 
                        + Integer.toString(j/3));
                    }
                }
            }
        }
        return true;
    }
}
