class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                String row = num + "at row" + i;
                String col = num + "at col" + j;
                String block = num + "at block" + i/3 + "," + j/3;

                if (!seen.add(row) || !seen.add(col) || !seen.add(block)) {
                    return false;
                }
            }
        }
        return true;
    }
}