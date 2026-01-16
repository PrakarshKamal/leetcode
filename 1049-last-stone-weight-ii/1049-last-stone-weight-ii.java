// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         return helper(0, 0, n, stones);
//     }
//     public int helper(int i, int currDifference, int n, int[] stones) {
//         if (i >= n) {
//             return Math.abs(currDifference);
//         }
//         int groupA = currDifference + stones[i];
//         int groupB = currDifference - stones[i];
//         int pickA = helper(i+1, groupA, n, stones);
//         int pickB = helper(i+1, groupB, n, stones);
        
//         return Math.min(pickA, pickB);
//     }
// }

// Top down memo O(n*S) time, O(n*2S) space, S = sum(stones)
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int[][] dp = new int[n][2*sum];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, n, sum, stones, dp);
    }
    public int helper(int i, int currDifference, int n, int sum, int[] stones, int[][] dp) {
        if (i >= n) {
            return Math.abs(currDifference);
        }
        int key = currDifference + sum;
        if (dp[i][key] != -1) return dp[i][key];

        int pickA = helper(i+1, currDifference + stones[i], n, sum, stones, dp);
        int pickB = helper(i+1, currDifference - stones[i], n, sum, stones, dp);

        dp[i][key] = Math.min(pickA, pickB);
        return dp[i][key];
    }
}