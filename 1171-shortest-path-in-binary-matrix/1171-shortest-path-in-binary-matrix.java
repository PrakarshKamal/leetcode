class Solution {
    // BFS O(m * n) time, O(m * n) space
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        // starting and ending cells are blocked, return -1
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        // diagonals allowed so we have 8 directions
        int[][] dirs = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
        };

        // starting point and add it to queue and mark visited
        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        int length = 1;
        while (!q.isEmpty()) {
            int size = q.size(); // size for current level
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                // we have reached destination, return length
                if (r == N - 1 && c == N - 1) {
                    return length;
                }

                // explore in all directions now
                for (int[] dir : dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    // edge cases
                    if (newR < 0 || newC < 0 ||
                        newR >= N || newC >= N ||
                        visited[newR][newC] == true || // already visited
                        grid[newR][newC] == 1) { // blocked
                        // so we skip and continue to next iteration
                        continue;
                    }
                    // update visited and add the indices to queue
                    visited[newR][newC] = true;
                    q.offer(new int[] {newR, newC});
                }
            }
            length++;
        }
        return -1;

    }
}