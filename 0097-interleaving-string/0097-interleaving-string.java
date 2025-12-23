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

// Top down memo O(n*m) time, O(n*m) space
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int n = s1.length();
//         int m = s2.length();
//         int[][] dp = new int[n+1][m+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(0, s1, 0, s2, s3, dp);
//     }
//     public boolean helper(int i, String s1, int j, String s2, String s3, int[][] dp) {
//         int n = s1.length();
//         int m = s2.length();
//         if (n+m != s3.length()) return false;
    
//         if (dp[i][j] != -1) return dp[i][j] == 1;

//         if (i == n && j == m) { // base case, consumed all chars in s1 and s2
//             return true;
//         }; 

//         int k = i+j; // matching index of s3 
//         boolean checkS1Chars = false;
//         boolean checkS2Chars = false;
//         if (i < n && s1.charAt(i) == s3.charAt(k)) {
//             checkS1Chars = helper(i+1, s1, j, s2, s3, dp);
//         }
//         if (j < m && s2.charAt(j) == s3.charAt(k)) {
//             checkS2Chars = helper(i, s1, j+1, s2, s3, dp);
//         }
//         boolean ans = checkS1Chars || checkS2Chars;
//         dp[i][j] = ans ? 1 : 0;
//         return ans;
//     }
// }

// Bottom up O(n*m) time, O(n*m) space
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int n = s1.length();
//         int m = s2.length();
//         if (n+m != s3.length()) return false;

//         boolean[][] dp = new boolean[n+1][m+1];
//         dp[0][0] = true;

//         for (int i = 0; i <= n; i++) {
//             for (int j = 0; j <= m; j++) {
//                 int k = i+j-1;
//                 if (i == 0 && j == 0) {
//                     continue;
//                 }
//                 if (i > 0 && s1.charAt(i-1) == s3.charAt(k)) {
//                     dp[i][j] = dp[i][j] || dp[i-1][j];
//                 }
//                 if (j > 0 && s2.charAt(j-1) == s3.charAt(k)) {
//                     dp[i][j] = dp[i][j] || dp[i][j-1];
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }

// Bottom up space optimized
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n+m != s3.length()) return false;

        boolean[] prev = new boolean[m+1]; 
        
        prev[0] = true;

        for (int i = 0; i <= n; i++) {
            boolean[] curr = new boolean[m+1];
            for (int j = 0; j <= m; j++) {
                int k = i+j-1;
                if (i == 0 && j == 0) {
                    curr[j] = true;
                    continue;
                }
                if (i > 0 && s1.charAt(i-1) == s3.charAt(k)) {
                    curr[j] = curr[j] || prev[j];
                }
                if (j > 0 && s2.charAt(j-1) == s3.charAt(k)) {
                    curr[j] = curr[j] || curr[j-1];
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}