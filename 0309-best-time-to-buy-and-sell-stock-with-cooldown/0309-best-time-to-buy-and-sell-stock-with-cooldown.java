// Recursive TLE
// class Solution {
//     public int maxProfit(int[] prices) {
//         return helper(0, prices, true);
//     }
//     public int helper(int i, int[] prices, boolean canBuy) {
//         if (i >= prices.length) {
//             return 0;
//         }
//         if (canBuy) { // can buy so buy or skip
//             int buy = helper(i+1, prices, false) - prices[i];
//             int skip = helper(i+1, prices, true);
//             return Math.max(buy, skip);
//         }
//         else { // can't buy so either sell or hold
//             int sell = helper(i+2, prices, true) + prices[i];
//             int hold = helper(i+1, prices, false);
//             return Math.max(sell, hold);
//         }
//     }
// }

// Top Down
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2]; // canBuy is just 0 or 1 so length 2
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, prices, 1, dp);
    }
    public int helper(int i, int[] prices, int canBuy, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        if (canBuy == 1) { // can buy so buy or skip
            int buy = helper(i+1, prices, 0, dp) - prices[i];
            int skip = helper(i+1, prices, 1, dp);
            dp[i][canBuy] = Math.max(buy, skip);
            return dp[i][canBuy];
        }
        else { // can't buy so either sell or hold
            int sell = helper(i+2, prices, 1, dp) + prices[i];
            int hold = helper(i+1, prices, 0, dp);
            dp[i][canBuy] = Math.max(sell, hold);
            return dp[i][canBuy];
        }
    }
}