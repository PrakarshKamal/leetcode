class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                if (i == j) {
                    dp[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j == i+1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(0, s, temp, ans, dp);
        return ans;
    }

    public void helper(int idx, String s, List<String> temp, List<List<String>> ans, boolean[][] dp) {
        int n = s.length();
        if (idx >= n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (dp[idx][i]) {
                String substring = s.substring(idx, i+1);
                temp.add(substring);
                helper(i+1, s, temp, ans, dp);
                temp.remove(temp.size()-1); // backtrack
            }
        }
    }
}