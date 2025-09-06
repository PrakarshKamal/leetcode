class Solution {
    // DFS O(m * n) time, O(m * n) space
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    islands++; // we found 1 island
                    dfs(grid, r, c); // check for others
                }
            }
        }
        return islands;
    }

    private void dfs (char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // edge cases
        if (r < 0 || c < 0 ||
            r >= ROWS || c >= COLS ||
            grid[r][c] == '0') {

            return;
        }

        // mark visited islands to 0
        grid[r][c] = '0';

        // explore all 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}