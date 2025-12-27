// // DP appproach O(n*m) time, O(n*m) space
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
//         int[][] dp = new int[n][m];

//         // setting max value if not 0 so Math.min works later
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (mat[i][j] != 0) {
//                     dp[i][j] = n+m; // since n+m is the max distance in a matrix
//                 }
//             }
//         }

//         // top left to bottom right 0,0 -> n,m
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (mat[i][j] != 0) {
//                     if (i > 0) {
//                         dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
//                     }
//                     if (j > 0) {
//                         dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
//                     }
//                 }
//             }
//         }

//         // bottom right to top left n,m -> 0,0
//         for (int i = n-1; i >= 0; i--) {
//             for (int j = m-1; j >= 0; j--) {
//                 if (mat[i][j] != 0) {
//                     if (i < n-1) {
//                         dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
//                     }
//                     if (j < m-1) {
//                         dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
//                     }
//                 }
//             }
//         }
//         return dp;
//     }
// }


// In place 
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
//         // setting max value if not 0 so Math.min works later
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (mat[i][j] != 0) {
//                     mat[i][j] = n+m; // since n+m is the max distance in a matrix
//                 }
//             }
//         }
//         // top left to bottom right 0,0 -> n,m
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (mat[i][j] != 0) {
//                     if (i > 0) {
//                         mat[i][j] = Math.min(mat[i][j], mat[i-1][j] + 1);
//                     }
//                     if (j > 0) {
//                         mat[i][j] = Math.min(mat[i][j], mat[i][j-1] + 1);
//                     }
//                 }
//             }
//         }
//         // bottom right to top left n,m -> 0,0
//         for (int i = n-1; i >= 0; i--) {
//             for (int j = m-1; j >= 0; j--) {
//                 if (mat[i][j] != 0) {
//                     if (i < n-1) {
//                         mat[i][j] = Math.min(mat[i][j], mat[i+1][j] + 1);
//                     }
//                     if (j < m-1) {
//                         mat[i][j] = Math.min(mat[i][j], mat[i][j+1] + 1);
//                     }
//                 }
//             }
//         }
//         return mat;
//     }
// }

// BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
                else {
                    mat[i][j] = n+m;
                }
            }
        }
        int[][] directions = { {0,1}, {0,-1}, {1,0}, {-1,0} };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m
                    && mat[newI][newJ] > mat[i][j] + 1) {
                        mat[newI][newJ] = 1 + mat[i][j];
                        q.offer(new int[] {newI, newJ});
                    }
            }
        }
        return mat;
    }
}
