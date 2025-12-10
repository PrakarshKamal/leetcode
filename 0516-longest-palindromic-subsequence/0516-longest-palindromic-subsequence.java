// Recursion TLE
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         return helper(0, n-1, s);
//     }

//     public int helper(int i, int j, String s) {
//         if (i > j) return 0; // empty substring so no palindome

//         if (i == j) { // length 1
//             return 1;
//         }
//         else if (s.charAt(i) == s.charAt(j)) { // length 2
//             return 2 + helper(i+1, j-1, s); // 2 since we pick both chars
//         }
//         else {
//             int moveLeft = helper(i, j-1, s);
//             int moveRight = helper(i+1, j, s);
//             return Math.max(moveLeft, moveRight);
//         }
//     }
// }

// Memo top down
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n-1, s, dp);
    }
    public int helper(int i, int j, String s, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1; // length 1

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + helper(i+1, j-1, s, dp);
            return dp[i][j];
        }
        else {
            int moveLeft = helper(i, j-1, s, dp);
            int moveRight = helper(i+1, j, s, dp);
            dp[i][j] = Math.max(moveLeft, moveRight);
            return dp[i][j];
        }
    }
}