// DFS
// class Solution {
//     public int numIslands(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         boolean visited[][] = new boolean[n][m];
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == '1' && !visited[i][j]) {
//                     count++;
//                     visited[i][j] = true;
//                     dfs(i, j, n, m, grid, visited);
//                 }
//             }
//         }
//         return count;
//     }

//     public void dfs(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
//         visited[i][j] = true;
//         int[][] directions = {
//             {0, 1}, {0, -1}, {1, 0}, {-1, 0}
//         };

//         for (int[] dir : directions) {
//             int newI = i + dir[0];
//             int newJ = j + dir[1];
//             if (newI >= 0 && newJ >= 0 
//                 && newI < n && newJ < m
//                 && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
//                 dfs(newI, newJ, n, m, grid, visited);
//             }
//         }
//     }
// }

// BFS
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, n, m, grid, visited);
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : directions) {
                int newI = curr[0] + dir[0];
                int newJ = curr[1] + dir[1];
                if (newI >= 0 && newJ >= 0 
                    && newI < n && newJ < m
                    && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    q.offer(new int[] {newI, newJ});
                }
            }
        }
    }
}