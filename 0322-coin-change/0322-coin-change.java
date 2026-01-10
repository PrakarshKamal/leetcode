class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        int ans = helper(0, n, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int helper(int i, int n, int[] coins, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (i >= n || amount < 0) return Integer.MAX_VALUE;
        if (dp[i][amount] != -1) return dp[i][amount];
        
        int ans = -1;

        int pickCoin = Integer.MAX_VALUE;
        int temp = helper(i, n, coins, amount-coins[i], dp);
        if (temp != Integer.MAX_VALUE) {
            pickCoin = 1 + temp;
        }
        int dontPickCoin = helper(i+1, n, coins, amount, dp);
        
        ans = Math.min(pickCoin, dontPickCoin);
        dp[i][amount] = ans;

        return dp[i][amount];
    }
}