// O(n^2) time, O(n) space
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; // one empty tree
        dp[1] = 1; // tree with 1 node
        
        for (int i = 2; i <= n; i++) { // i is total number of nodes
            for (int root = 1; root <= i; root++) {
                // left trees * right trees
                dp[i] += dp[root-1] * dp[i-root]; 
            }
        }
        return dp[n];
    }
}