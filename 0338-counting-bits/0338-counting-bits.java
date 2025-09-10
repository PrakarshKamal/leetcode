class Solution {
    // O(n log n ) time, O(n) space
    // public int[] countBits(int n) {
    //     int[] ans = new int[n + 1];
        
    //     for (int i = 0; i <= n; i++) {
    //         int count = 0;
    //         int x = i;
    //         while (x > 0) {
    //             if ((x & 1) == 1) {
    //                 count++;
    //             }
    //             x >>= 1;
    //         }
    //         ans[i] = count;
    //     }
    //     return ans;
    // }

    // DP approach O(n) time, O(n) space
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}