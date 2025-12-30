// O(n*m) time, O(1) space
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n < 3 || m < 3) return 0;
        
        int count = 0;
        for (int row = 0; row <= n-3; row++) {
            for (int col = 0; col <= m-3; col++) {
                if (isMagic3x3(row, col, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isMagic3x3(int row, int col, int[][] grid) {
        Set<Integer> seen = new HashSet<>(); // constant space since only 9 numbers to store

        if (grid[row+1][col+1] != 5) return false; // if center not 5, not possible

        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                int value = grid[i][j];
                if (value < 1 || value > 9 || seen.contains(value)) {
                    return false;
                }
                seen.add(value);
            }
        }

        // Sum of row/col/diag is always 15
        for (int i = 0; i < 3; i++) {
            if (grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2] != 15) { // row check
                return false;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (grid[row][col+j] + grid[row+1][col+j] + grid[row+2][col+j] != 15) { // col check
                return false;
            }
        }

        // diag checks
        if (grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] != 15) return false;
        if (grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2] != 15) return false;
        
        return true;
    }
}