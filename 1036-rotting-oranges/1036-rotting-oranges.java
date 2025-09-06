class Solution {
    // BFS O(m * n) time, O(m * n) space
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int[][] dirs = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        Queue<int[]> q = new ArrayDeque<>();

        int fresh = 0;
        int minutes = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] {r, c}); // add rotten oranges to q
                }
                if (grid[r][c] == 1) {
                    fresh++; // maintain count of fresh oranges;
                }
            }
        }

        // q not empty and we have fresh oranges to rot
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll(); // get current rotten orange from q
                int r = rotten[0];
                int c = rotten[1];

                for (int[] dir : dirs) { // explore 4 directions
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    // edge cases
                    if (newR < 0 || newC < 0 || // bounds check
                        newR >= ROWS || newC >= COLS || // bounds check
                        grid[newR][newC] != 1) { // check if orange not fresh
                        // we can skip and continue to rot other oranges
                        continue;
                    }
                    grid[newR][newC] = 2; // rot the fresh orange
                    q.offer(new int[] {newR, newC}); // add to q
                    fresh--; // decrement fresh orange count
                }
            }
            minutes++;
        }
        if (fresh == 0) { // we made all fresh oranges -> rotten
            return minutes;
        }
        return -1; // not possible so -1
    }
}