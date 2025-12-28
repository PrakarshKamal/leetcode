// Recursion TLE
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return helper(0, 0, triangle);
//     }
//     public int helper(int row, int col, List<List<Integer>> triangle) {
//         int n = triangle.size();
//         if (row >= n) return 0;
//         int currSum = triangle.get(row).get(col);
        
//         // pick i (col)
//         int sum1 = currSum + helper(row+1, col, triangle);

//         // pick i+1 (col+1)
//         int sum2 = currSum + helper(row+1, col+1, triangle);

//         currSum = Math.min(sum1, sum2);
//         return currSum;
//     }
// }

// Top down memo O(n^2) time, O(n^2) space
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
//         for (int[] i : dp) {
//             Arrays.fill(i, Integer.MAX_VALUE);
//         }
//         return helper(0, 0, triangle, dp);
//     }
//     public int helper(int row, int col, List<List<Integer>> triangle, int[][] dp) {
//         int n = triangle.size();
//         if (row >= n) return 0;
//         if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

//         int currSum = triangle.get(row).get(col);
        
//         // pick i (col)
//         int sum1 = currSum + helper(row+1, col, triangle, dp);

//         // pick i+1 (col+1)
//         int sum2 = currSum + helper(row+1, col+1, triangle, dp);

//         currSum = Math.min(sum1, sum2);
//         dp[row][col] = currSum;
//         return dp[row][col];
//     }
// }

// Bottom up 2D DP, O(n^2) time, O(n^2) space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for (int row = n-2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int currSum = triangle.get(row).get(col);
                int sum1 = currSum + dp[row+1][col];
                int sum2 = currSum + dp[row+1][col+1];
                dp[row][col] = Math.min(sum1, sum2);
            }
        }
        return dp[0][0];
    }
}