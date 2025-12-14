// class Solution {
//     public int numDecodings(String s) {
//         return helper(0, s);
//     }

//     public int helper(int i, String s) {
//         if (i == s.length()) return 1;
        
//         if (i > s.length() || s.charAt(i) == '0') {
//             return 0;
//         }

//         int ans = 0;
//         if (s.charAt(i) != '0') {
//             ans += helper(i+1, s);
//         }

//         if (i+1 < s.length()) {
//             if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i) >= '0' && s.charAt(i+1) <= '6') {
//                 ans += helper(i+2, s);
//             }
//         }
//         return ans;
//     }
// }

// top down memo
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n-1, s, dp);
    }

    public int helper(int i, int j, String s, int[][] dp) {
        if (i == s.length()) return 1;
        
        if (i > s.length() || s.charAt(i) == '0') {
            return 0;
        }

        int ans = 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) != '0') {
            ans += helper(i+1, j, s, dp);
            dp[i][j] = ans;
        }

        if (i+1 < s.length()) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i) >= '0' && s.charAt(i+1) <= '6') {
                ans += helper(i+2, j, s, dp);
                dp[i][j] = ans;
            }
        }
        return dp[i][j];
    }
}