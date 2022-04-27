class Solution {
    
    private List<List<String>> result;
    
    private boolean[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        board = new boolean[n][n]; //true => there is queen   
        
        solveQueens(board, 0);
        
        return result;
    }
    
    private void solveQueens(boolean[][] board, int row) {
        //base
        if (row == board.length) {
            List<String> out = new ArrayList<>();
            
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                out.add(sb.toString());
            }
            result.add(out);
            return;
        }
        
        //recurse
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                
                board[row][col] = true;
                
                solveQueens(board, row+1);
                
                board[row][col] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col) {
        
        return  isSafeColumn(board, row, col) 
                        && 
                isSafeLeftUpperDiag(board, row, col)
                        &&
                isSafeRightUpperDiag(board, row, col);
    }
    
    private boolean isSafeColumn(boolean[][] board, int row, int col) {
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col]) {
                return false; // there is a queen, not safe
            }
        }
        return true;
    }
    
    private boolean isSafeLeftUpperDiag(boolean[][] board, int row, int col) {
        int i = row-1;
        int j = col-1;
        
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false; // there is a queen, not safe
            }
            
            i--;
            j--;
        }
        return true;
    }
    
    private boolean isSafeRightUpperDiag(boolean[][] board, int row, int col) {
        int i = row-1;
        int j = col+1;
        
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false; // there is a queen, not safe
            }
            
            i--;
            j++;
        }
        
        return true;
    }
    
    
}