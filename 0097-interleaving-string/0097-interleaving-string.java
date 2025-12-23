// Recursion TLE
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         return helper(0, s1, 0, s2, s3);
//     }
//     public boolean helper(int i, String s1, int j, String s2, String s3) {
//         int n = s1.length();
//         int m = s2.length();
//         if (n+m != s3.length()) {
//             return false;
//         }

//         if (i == n && j == m) return true; // base case, consumed all chars in s1 and s2

//         int k = i+j;
//         boolean checkS1Chars = false;
//         boolean checkS2Chars = false;
//         if (i < n && s1.charAt(i) == s3.charAt(k)) {
//             checkS1Chars = helper(i+1, s1, j, s2, s3);
//         }
//         if (j < m && s2.charAt(j) == s3.charAt(k)) {
//             checkS2Chars = helper(i, s1, j+1, s2, s3);
//         }
//         return checkS1Chars || checkS2Chars;
//     }
// }

// Top down memo
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, s1, 0, s2, s3, dp);
    }
    public boolean helper(int i, String s1, int j, String s2, String s3, int[][] dp) {
        int n = s1.length();
        int m = s2.length();
        if (n+m != s3.length()) {
            return false;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (i == n && j == m) { // base case, consumed all chars in s1 and s2
            return true;
        }; 

        int k = i+j;
        boolean checkS1Chars = false;
        boolean checkS2Chars = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            checkS1Chars = helper(i+1, s1, j, s2, s3, dp);
            dp[i][j] = checkS1Chars ? 1 : 0;
        }
        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            checkS2Chars = helper(i, s1, j+1, s2, s3, dp);
            dp[i][j] = checkS2Chars ? 1 : 0;
        }
        boolean ans = checkS1Chars || checkS2Chars;
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}