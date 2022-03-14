class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // edge cases
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        // row check
        for (int i = 0; i < 9; i++) {
            
            boolean[] row = new boolean[9];
            
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] != '.') {
                    
                    // if digit present return false
                    if (row[board[i][j] - '1']) {
                        return false;
                    }
                    else {
                        // otherwise set to true
                        row[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        // col check
        for (int j = 0; j < 9; j++) {
            
            boolean[] col = new boolean[9];
            
            for (int i = 0; i < 9; i++) {
                
                if (board[i][j] != '.') {
                    
                    if (col[board[i][j] - '1']) {
                        return false;
                    }
                    else {
                        col[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        // block check
        for (int block = 0; block < 9; block++) {
            
            boolean[] BLOCK = new boolean[9];
            
            int iHoriz = block / 3 * 3;
            int iVert = block / 3 * 3 + 3;
            
            int jHoriz = block % 3 * 3;
            int jVert = block % 3 * 3 + 3;
            
            for (int i = iHoriz; i < iVert; i++) {
                
                for (int j = jHoriz; j < jVert; j++) {
                    
                    if (board[i][j] != '.') {
                        
                        if (BLOCK[board[i][j] - '1']) {
                            return false;
                        }
                        else {
                            BLOCK[board[i][j] - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}