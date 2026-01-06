class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; // also m balls
        int[] ans = new int[m];
        for (int col = 0; col < m; col++) {
            ans[col] = dfs(0, col, n, m, grid);
        }
        return ans;
    }

    public int dfs(int row, int col, int n, int m, int[][] grid) {
        if (row == n) { // base case, reached end
            return col;
        }
        int direction = grid[row][col]; // 1 or -1

        int nextCol = col + direction;
        int nextRow = row+1;

        if (nextCol < 0 || nextCol >= m) return -1; // out of bounds

        // for ball to pass grid[row][col] == grid[row][nextCol]
        if (grid[row][nextCol] != direction) return -1; // V check

        return dfs(nextRow, nextCol, n, m, grid);
    }
}