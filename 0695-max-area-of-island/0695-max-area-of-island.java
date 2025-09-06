class Solution {
    // DFS O(m * n) time, O(m * n) space
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int maxArea = 0;

        // iterate over grid
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int area = 0;
                if (grid[r][c] == 1) {
                    area = dfs(grid, r, c); // get area of current island from dfs
                    maxArea = Math.max(area, maxArea); // maxArea so far
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // edge cases
        if (r < 0 || c < 0 ||
            r >= ROWS || c >= COLS ||
            grid[r][c] == 0) {
            
            return 0;
        }

        grid[r][c] = 0; // mark visited islands to 0

        int area = 1; // initialize and include current island area 
        // explore all 4 directions
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c - 1);

        return area;
    }
}