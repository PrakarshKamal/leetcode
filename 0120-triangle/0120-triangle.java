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

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        return helper(0, 0, triangle, dp);
    }
    public int helper(int row, int col, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();
        if (row >= n) return 0;
        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int currSum = triangle.get(row).get(col);
        
        // pick i (col)
        int sum1 = currSum + helper(row+1, col, triangle, dp);

        // pick i+1 (col+1)
        int sum2 = currSum + helper(row+1, col+1, triangle, dp);

        currSum = Math.min(sum1, sum2);
        dp[row][col] = currSum;
        return dp[row][col];
    }
}