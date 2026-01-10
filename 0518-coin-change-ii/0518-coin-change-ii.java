// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         return helper(0, n, amount, coins);
//     }
//     public int helper(int i, int n, int amount, int[] coins) {
//         if (amount == 0) return 1;
//         if (i >= n || amount < 0) return 0;

//         int pick = helper(i, n, amount-coins[i], coins);
//         int dontPick = helper(i+1, n, amount, coins);

//         return pick + dontPick;
//     }
// }

// Top down memo
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n, amount, coins, dp);
    }
    public int helper(int i, int n, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 1;
        if (i >= n || amount < 0) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];

        int pick = helper(i, n, amount-coins[i], coins, dp);
        int dontPick = helper(i+1, n, amount, coins, dp);
        dp[i][amount] = pick + dontPick;
        return dp[i][amount];
    }
}