class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;

                if (wordSet.contains(s.substring(i, j+1))) {
                    dp[i][j] = true;
                }

                for (int k = i; k < j; k++) { // cut after k
                    boolean ans = dp[i][k] && dp[k+1][j];
                    if (ans) {
                        dp[i][j] = true;
                        break;
                    }
                } 
            }
        }
        return dp[0][n-1];
    }
}