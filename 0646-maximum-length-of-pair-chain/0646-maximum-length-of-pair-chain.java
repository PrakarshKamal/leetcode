// Recursive O(2^n) time, O(n) space
// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
//         int n = pairs.length;
//         return helper(0, n, -1, pairs);
//     }
//     public int helper(int i, int n, int prevIdx, int[][] pairs) {
//         if (i >= n) return 0;

//         int skip = helper(i+1, n, prevIdx, pairs);
//         int take = 0;
//         if (prevIdx == -1 || pairs[prevIdx][1] < pairs[i][0]) {
//             take = 1 + helper(i+1, n, i, pairs);
//         }
//         return Math.max(skip, take);
//     }
// }

// Top down O(n^2) time, O(n^2) space
// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
//         int n = pairs.length;
//         int[][] dp = new int[n][n+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(0, n, -1, pairs, dp);
//     }
//     public int helper(int i, int n, int prevIdx, int[][] pairs, int[][] dp) {
//         if (i >= n) return 0;
//         if (dp[i][prevIdx+1] != -1) return dp[i][prevIdx+1];

//         int skip = helper(i+1, n, prevIdx, pairs, dp);
//         int take = 0;
//         if (prevIdx == -1 || pairs[prevIdx][1] < pairs[i][0]) {
//             take = 1 + helper(i+1, n, i, pairs, dp);
//         }
//         dp[i][prevIdx+1] = Math.max(skip, take);
//         return dp[i][prevIdx+1];
//     }
// }

// Greedy O(n log n) time, O(1) space
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (pair[0] > lastEnd) { // checking if current chain can be extended
                count++;
                lastEnd = pair[1];
            }
        }
        return count;
    }
}